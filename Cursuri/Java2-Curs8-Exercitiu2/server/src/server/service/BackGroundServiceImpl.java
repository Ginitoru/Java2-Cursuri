package server.service;

import lib.api.BackGroundService;
import lib.dto.BackGroundImage;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BackGroundServiceImpl extends UnicastRemoteObject implements BackGroundService {



    private String path = "./server/src/server/image/flow-2.jpg";
    private List<BackGroundImage> images = new ArrayList<>();

    public BackGroundServiceImpl() throws RemoteException {
    }

    @Override
    public BackGroundImage getImage() throws RemoteException {
        BackGroundImage image1 = new BackGroundImage();
        Image image = new ImageIcon(path).getImage()
                .getScaledInstance(960,540,Image.SCALE_SMOOTH);
        image1.setImage(image);
        return image1;
    }

    public List<BackGroundImage> getImages() {
        return images;
    }
}
