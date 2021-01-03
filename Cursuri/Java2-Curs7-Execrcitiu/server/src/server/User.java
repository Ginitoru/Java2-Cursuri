package server;

import mesaj.Mesaj;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class User extends Thread {

    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public User(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new ObjectInputStream(socket.getInputStream());
        this.out = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run(){

        while(true){

            try {
                Mesaj mesaj = (Mesaj)in.readObject();
                MainServer.trimiteMesajTuturor(mesaj);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


    }

    public void trimiteMesaj(Mesaj mesaj) throws IOException {
        out.writeObject(mesaj);
        out.flush();
    }

}
