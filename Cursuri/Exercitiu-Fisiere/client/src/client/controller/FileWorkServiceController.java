package client.controller;

import lib.dto.FileWorkerDTO;
import lib.service.FileWorkerService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class FileWorkServiceController implements FileWorkerService {

    private FileWorkerService fileWorkerService;


    private FileWorkServiceController() {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 4546);

            fileWorkerService = (FileWorkerService) registry.lookup("file");

        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<String> showFiles() {
        try {
           return fileWorkerService.showFiles();
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public void changeDirectory(FileWorkerDTO fileWorkerDTO) {
        try {
            fileWorkerService.changeDirectory(fileWorkerDTO);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public void createFile(FileWorkerDTO fileWorkerDTO) {
        try {
            fileWorkerService.createFile(fileWorkerDTO);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteFile(FileWorkerDTO fileWorkerDTO){
        try {
            fileWorkerService.deleteFile(fileWorkerDTO);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void renameFile(FileWorkerDTO fileWorkerDTO){
        try {
            fileWorkerService.renameFile(fileWorkerDTO);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createDirectory(FileWorkerDTO fileWorkerDTO){
        try {
            fileWorkerService.createDirectory(fileWorkerDTO);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    private static final class SingletonHolder{
        public static final FileWorkServiceController INSTANCE = new FileWorkServiceController();
    }

    public static FileWorkServiceController getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
