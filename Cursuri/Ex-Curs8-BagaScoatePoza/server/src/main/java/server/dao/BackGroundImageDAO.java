package server.dao;


import server.entity.BackGroundImage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BackGroundImageDAO {

    private EntityManager em;

    public BackGroundImageDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("xxx");
        em = emf.createEntityManager();

    }


    public void sendImage(String path){
        BackGroundImage image = new BackGroundImage();

  //      File file = new File(path);

        Path p1 = Paths.get(path);


        //returneaza dimensiunea imaginii->fisierului
//        try {
//            Files.size(p1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        try {

//            BufferedImage originalImage = ImageIO.read(file);

            byte []  z = Files.readAllBytes(p1);

            System.out.println(z.length);


  //          ByteArrayOutputStream baos = new ByteArrayOutputStream();
 //           ImageIO.write(originalImage, "jpg", baos);

            image.setImage(z);

            em.getTransaction().begin();

            em.persist(image);

            em.getTransaction().commit();






        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<BackGroundImage> getImage(){
        TypedQuery<BackGroundImage> query = em.createNamedQuery("BackGroudnImage.finAll", BackGroundImage.class);

       return query.getResultList();
    }
}
