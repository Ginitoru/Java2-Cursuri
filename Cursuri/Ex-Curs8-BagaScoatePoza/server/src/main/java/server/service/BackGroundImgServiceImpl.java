package server.service;

import lib.dto.BackGroundImgDTO;
import lib.dto.service.BackGroundImgService;
import server.dao.BackGroundImageDAO;
import server.entity.BackGroundImage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Random;

public class BackGroundImgServiceImpl extends UnicastRemoteObject implements BackGroundImgService {

    private String path = "./server/src/main/resources/images/flow-2.jpg";
    private String path1 = "G:\\IntelliJ\\Java2\\Ex-Curs8-BagaScoatePoza\\server\\src\\main\\resources\\images\\flow-2.jpg";

    private BackGroundImageDAO backGroundImageDAO;

    public BackGroundImgServiceImpl() throws RemoteException {
        backGroundImageDAO = new BackGroundImageDAO();
    }


    @Override
    public byte[] getImage() throws RemoteException {



        List<BackGroundImage> images = backGroundImageDAO.getImage();
        BackGroundImgDTO dto = new BackGroundImgDTO();

        Random random = new Random();

        BackGroundImage x = images.get(random.nextInt(images.size()));

    //    dto.setImage(x.getImage());

       return x.getImage();



    }

    @Override
    public BackGroundImgDTO getImage1() throws RemoteException {
      List<BackGroundImage> images = backGroundImageDAO.getImage();
      BackGroundImgDTO dto = new BackGroundImgDTO();

        Random random = new Random();

       BackGroundImage x = images.get(random.nextInt(images.size()));

       dto.setImage(x.getImage());
       dto.setId(x.getId());

       return dto;
    }


    public void sendImage(){
        backGroundImageDAO.sendImage(path);
    }





}

