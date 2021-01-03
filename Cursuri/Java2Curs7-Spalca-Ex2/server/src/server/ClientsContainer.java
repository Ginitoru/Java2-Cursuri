package server;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ClientsContainer {

    private static List<ServerThread> clienti = new ArrayList<>();
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void addClient(ServerThread client){
        try{
            lock.writeLock().lock();
            clienti.add(client);
        }finally {
            lock.writeLock().unlock();
        }


    }


    public static synchronized void sendMessageToAll(String message){
        try{
            lock.readLock().lock();
            clienti.forEach(c-> c.sendMessage(message));

        }finally {
            lock.readLock().unlock();
        }



    }

}
