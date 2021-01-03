package server;

import server.service.MyServiceImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws RemoteException {

        //Creem un registru cu rol de DNS care va rula pe portul 4545
        Registry registry = LocateRegistry.createRegistry(4545);

        //expunem instanta de myServiceImpl sub cheia de MyService
        registry.rebind("myService", new MyServiceImpl());







    }
}
