package lib.dto.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BackGroundImageService extends Remote {

    byte [] getImage() throws RemoteException;

    byte [] sendImage() throws RemoteException;

}
