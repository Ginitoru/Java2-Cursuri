package main;

import db.Fisier;
import db.Folder;

import javax.persistence.Persistence;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {

        var emf = Persistence.createEntityManagerFactory("java2PU");
        var em = emf.createEntityManager();

        Fisier fis1 = new Fisier();
        fis1.setNume("x");
        fis1.setLinii(List.of("linia x1", "linia x2"));

        Fisier fis2 = new Fisier();
        fis2.setNume("y");
        fis2.setLinii(List.of("linia y1", "linia y2"));

        Folder f = new Folder();
        f.setNume("a");
        f.setFisier(List.of(fis1, fis2));

        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
