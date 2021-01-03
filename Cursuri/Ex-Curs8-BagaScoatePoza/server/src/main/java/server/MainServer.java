package server;

import server.service.BackGroundImgServiceImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainServer {
    public static void main(String[] args) throws RemoteException {

        Registry registry = LocateRegistry.createRegistry(4547);

        registry.rebind("serviceImage", new BackGroundImgServiceImpl());

        BackGroundImgServiceImpl x = new BackGroundImgServiceImpl();

        x.sendImage();





    }
}
