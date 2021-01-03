package server.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class BackGroundImageDAO {

    private EntityManagerFactory em;

    public BackGroundImageDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("xxx");
        EntityManager em = emf.createEntityManager();

    }



    public void sendImage(){

    }





}
