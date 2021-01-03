package lib.api;

import lib.dto.BackGroundImage;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BackGroundService extends Remote {

    BackGroundImage getImage() throws RemoteException;





}
