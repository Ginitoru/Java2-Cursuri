package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ServerThread(Socket socket) throws IOException {

                this.socket = socket;
                this.out = new PrintWriter(socket.getOutputStream(), true);
                this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


    }

    @Override
    public void run(){
        while(true){
            try {
                String messge = reciveMessge();
                ClientsContainer.sendMessageToAll(messge);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }


    public void sendMessage(String message){
        out.println(message);

    }

    public String reciveMessge() throws IOException {
        return in.readLine();
    }

}
