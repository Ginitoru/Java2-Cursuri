package main;

import db.Adresa;
import db.Persoana;

import javax.persistence.Persistence;
import java.util.Map;

public class Ex5 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c5PU");
        var em = emf.createEntityManager();

        Persoana persoana = new Persoana();
        Adresa adr1 = new Adresa();
        Adresa adr2 = new Adresa();

        adr1.setStrada("timisoare");
        adr1.setPersoana(persoana);

        adr2.setStrada("maniu");
        adr2.setPersoana(persoana);

        persoana.setAdresa(Map.of(
                "123466", adr1,
                "654321", adr2

        ));

        em.getTransaction().begin();
        em.persist(persoana);
        em.persist(adr1);
        em.persist(adr2);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
