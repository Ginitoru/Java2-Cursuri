package main;

import db.ex3.NumePrenumeId;
import db.ex3.Persoana;
import db.ex3.Student;

import javax.persistence.Persistence;

public class Ex3 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("curs6PU");
        var em = emf.createEntityManager();


        var id = new NumePrenumeId();

        id.setNume("gigel2");
        id.setPrenume("ion2");

        var persoana = new Persoana();

        persoana.setNume(id.getNume());
        persoana.setPrenume(id.getNume());
        persoana.setVarsta(25);

        var student = new Student();

        student.setId(id);
        student.setCod("nume_tudent");

        em.getTransaction().begin();
        em.persist(persoana);
        em.persist(student);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
