package server;

import server.service.BackGroundServiceImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public static void main(String[] args) throws RemoteException {

        Registry registry = LocateRegistry.createRegistry(4545);

        registry.rebind("getImageIcon", new BackGroundServiceImpl());

 //       new Frame();



    }
}
