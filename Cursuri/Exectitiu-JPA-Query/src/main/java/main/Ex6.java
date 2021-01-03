package main;

import javax.persistence.Persistence;
import javax.persistence.Query;

public class Ex6 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2PU");
        var em = emf.createEntityManager();

        em.getTransaction().begin();

        String x = "DELETE FROM Employee e WHERE e.name = :name";

        Query q = em.createQuery(x);
      //  q.setParameter("name","zzzzzz");
        q.setParameter("name", "fane");
        int rows = q.executeUpdate();
        System.out.println(rows);


        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
