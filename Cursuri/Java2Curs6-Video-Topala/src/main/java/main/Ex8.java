package main;

import db.ex1.Bere;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Ex8 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java6PU");
        var em = emf.createEntityManager();
            //select b FROM Bere b WHERE b.nume = "stejar"


        CriteriaBuilder cb = em.getCriteriaBuilder();
        //Criteria Builder - clasa care construieste cluzele interogarii - equal, graterThan, notNull

        CriteriaQuery<Bere> query = cb.createQuery(Bere.class);

        Root<Bere> b = query.from(Bere.class);

        //select b FROM Bere b WHERE b.nume = "stejar"
        query.select(b)
                .where(cb.equal(b.get("nume"), "stejar"));

        TypedQuery<Bere> q = em.createQuery(query);
        List<Bere> beri = q.getResultList();

        beri.forEach(System.out::println);










        em.close();
        emf.close();

    }
}
