package server.service;

import lib.service.MyService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyServiceImpl extends UnicastRemoteObject implements MyService {

    public MyServiceImpl() throws RemoteException{
        super();
    }

    @Override
    public String reverse(String s) throws RemoteException {
        return new StringBuilder(s).reverse().toString();
    }
}
