package client;

import api.MyService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {

        //obtinem registrul ce ruleaza pe masina virtuala la portul 4545
        Registry registry = LocateRegistry.getRegistry("localhost", 4545);

        //obtinem din registru un stub asociat cheii myService
        MyService service = (MyService) registry.lookup("myService");


        var res = service.reverse("hello");

        System.out.println(res);
    }
}
