package client.controller;

import lib.api.BackGroundService;
import lib.dto.BackGroundImage;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class BackGroundImageController implements BackGroundService {

    private BackGroundService imageService;

    private BackGroundImageController() {

        try {
            var registry = LocateRegistry.getRegistry("localhost", 4545);

            imageService = (BackGroundService) registry.lookup("getImageIcon");


        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    public BackGroundImage getImage() {
        try {
           return imageService.getImage();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static final class SingletonHolder{
        public static BackGroundImageController INSTANCE = new BackGroundImageController();
    }

    public static BackGroundImageController getInstance(){
        return SingletonHolder.INSTANCE;
    }

}
