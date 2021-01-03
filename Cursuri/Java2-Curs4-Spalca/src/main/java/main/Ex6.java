package main;

import db.Articol;
import db.Autor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class Ex6 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c4PU");
        EntityManager em = emf.createEntityManager();

        try{

            Autor a1 = new Autor();
            Autor a2 = new Autor();

            a1.setNume("autoror 1");
            a2.setNume("autor a2");

            Articol q1 = new Articol();
            q1.setTitlu("titlu 1");

            Articol q2 = new Articol();

            q2.setTitlu("titlu2");


            a1.setArticole(new ArrayList<>());
            a2.setArticole(new ArrayList<>());
            q1.setAutori(new ArrayList<>());
            q2.setAutori(new ArrayList<>());

            a1.getArticole().add(q1);
            a1.getArticole().add(q2);

            a2.getArticole().add(q1);
            a2.getArticole().add(q2);

            q1.getAutori().add(a1);
            q1.getAutori().add(a2);

            q2.getAutori().add(a1);
            q2.getAutori().add(a2);

            em.getTransaction().begin();

            em.persist(a1);
            em.persist(a2);
            em.persist(q1);
            em.persist(q2);

            em.getTransaction().commit();



        }finally{
            em.close();
            emf.close();
        }

    }

}
