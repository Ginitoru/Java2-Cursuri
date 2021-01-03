package lib.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyService extends Remote {

    String reverse(String s) throws RemoteException;

}
