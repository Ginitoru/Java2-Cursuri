package lib.dto.service;

import lib.dto.BackGroundImgDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BackGroundImgService extends Remote {

    byte [] getImage() throws RemoteException;

    BackGroundImgDTO getImage1() throws RemoteException;



}
