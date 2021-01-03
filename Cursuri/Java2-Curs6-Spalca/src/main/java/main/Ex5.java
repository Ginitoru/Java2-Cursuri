package main;

import db.ex5.License;
import db.ex5.Masina;

import javax.persistence.Persistence;

public class Ex5 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("curs6PU");
        var em = emf.createEntityManager();


        try{

            Masina m = new Masina();

            m.setMarca("dacia");

            License lic = new License();
            lic.setCod("b");
            lic.setNr(1);
            lic.setRegieun("eru");


            em.getTransaction().begin();
            em.persist(m);

            em.getTransaction().commit();


        }finally {
            em.close();
            emf.close();
        }

    }
}
