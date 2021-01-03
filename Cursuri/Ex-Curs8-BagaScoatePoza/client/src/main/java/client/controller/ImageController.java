package client.controller;

import lib.dto.BackGroundImgDTO;
import lib.dto.service.BackGroundImgService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ImageController implements BackGroundImgService {

    private BackGroundImgService backGroundImgService;

    public ImageController() {
        try {
            Registry registry = LocateRegistry.getRegistry(4547);

            backGroundImgService = (BackGroundImgService) registry.lookup("serviceImage");

        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public byte[] getImage(){
        try {
          return  backGroundImgService.getImage();
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public BackGroundImgDTO getImage1() {
        try {
          return  backGroundImgService.getImage1();
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static final class SingletonHolder{
        public static final ImageController INSTANCE = new ImageController();
    }

    public static ImageController getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
