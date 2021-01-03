package main;

import db.Departament;

import javax.persistence.Persistence;

public class Ex3 {
    public static void main(String[] args) {

        var emf = Persistence.createEntityManagerFactory("java2c4PU");
        var em = emf.createEntityManager();


        Departament dep = em.find(Departament.class, 1);

       System.out.println(dep.getAngajati());
        em.getTransaction().begin();

        dep.getAngajati().removeIf(angajat -> angajat.getNume().equals("gigel"));
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
