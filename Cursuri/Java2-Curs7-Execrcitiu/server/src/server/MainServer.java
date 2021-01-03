package server;

import mesaj.Mesaj;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainServer {

    private static List<User> useri = new ArrayList<>();
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws IOException {


        ServerSocket ss = new ServerSocket(4545);

        while(true){

            Socket clientSocket = ss.accept();

            User user = new User(clientSocket);
            try {
                lock.writeLock().lock();
                useri.add(user);
            }finally {
                lock.writeLock().unlock();
            }



            user.start();

        }


    }

    public static void trimiteMesajTuturor(Mesaj mesaj){

        try {
            lock.readLock().lock();
            useri.forEach(c -> {
                try {
                    c.trimiteMesaj(mesaj);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }finally {
            lock.readLock().unlock();
        }

    }



}
