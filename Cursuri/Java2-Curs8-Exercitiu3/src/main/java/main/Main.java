package main;

import entity.ImageX;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java6PU");

        EntityManager em = emf.createEntityManager();

         String x = "./src/main/resources/image/flow-2.jpg";

        ImageX image = new ImageX();


         File file = new File(x);

        BufferedImage originalImage = ImageIO.read(file);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(originalImage,"jpg", baos);

        image.setImage(baos.toByteArray());

        em.getTransaction().begin();

        em.persist(image);


        em.getTransaction().commit();


        em.close();
        emf.close();





    }
}
