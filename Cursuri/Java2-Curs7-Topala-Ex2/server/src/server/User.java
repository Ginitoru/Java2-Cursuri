package server;

import lib.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class User {

    private Socket socket;

    private ObjectInputStream in;

    private ObjectOutputStream out;

    private Chat chat;

    private boolean active = true;

    public User(Socket socket, Chat chat) throws IOException {
        this.socket = socket;
        this.chat = chat;


        in = new ObjectInputStream(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());

        chat.addUser(this);
        startRecivingMessages();

    }

    private void startRecivingMessages(){
        new Thread(() -> {
           while(active){
               try {
                   Message message = (Message)in.readObject();

                   chat.newMessage(message);

               } catch (IOException e) {
                   e.printStackTrace();
               } catch (ClassNotFoundException e) {
                   e.printStackTrace();
               }
           }

        }).start();
    }

    public void sendMessage(Message message) throws IOException {
        out.writeObject(message);
        out.flush();
    }
}
