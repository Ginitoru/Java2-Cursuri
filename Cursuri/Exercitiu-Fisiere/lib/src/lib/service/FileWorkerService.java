package lib.service;

import lib.dto.FileWorkerDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface FileWorkerService extends Remote {

    List<String> showFiles() throws RemoteException;

    void changeDirectory(FileWorkerDTO fileWorkerDTO) throws RemoteException;

    void createFile(FileWorkerDTO fileWorkerDTO) throws RemoteException;

    void deleteFile(FileWorkerDTO fileWorkerDTO) throws RemoteException;

    void renameFile(FileWorkerDTO fileWorkerDTO) throws RemoteException;

    void createDirectory(FileWorkerDTO fileWorkerDTO) throws RemoteException;
}
