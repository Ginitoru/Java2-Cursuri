package main;

import db.Adresa;
import db.Organizatie;

import javax.persistence.Persistence;
import java.util.Map;

public class Ex4 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c5PU");
        var em = emf.createEntityManager();

        Organizatie org = new Organizatie();
        Adresa adr1 = new Adresa();
        Adresa adr2 = new Adresa();

        adr1.setStrada("timisoare");
        adr1.setOrganizatie(org);

        adr2.setStrada("maniu");
        adr2.setOrganizatie(org);

        org.setAdrese(Map.of(
                "123466", adr1,
                "654321", adr2

        ));

        em.getTransaction().begin();
        em.persist(org);
        em.persist(adr1);
        em.persist(adr2);

        em.getTransaction().commit();

        em.close();
        emf.close();




    }
}
