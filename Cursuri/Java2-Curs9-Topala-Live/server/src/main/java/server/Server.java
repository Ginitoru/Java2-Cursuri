package server;

import server.service.ComandaServiceImpl;
import server.service.ProdusServiceImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {

        try {
            var registry = LocateRegistry.createRegistry(4546);

            registry.rebind("prduseService", new ProdusServiceImpl());
            registry.rebind("comandaService", new ComandaServiceImpl());

        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

}
