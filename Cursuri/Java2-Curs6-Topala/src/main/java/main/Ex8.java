package main;

import db.ex3.Student;

import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class Ex8 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("curs6PU");
        var em = emf.createEntityManager();


        CriteriaBuilder builder = em.getCriteriaBuilder();

        //SELECT s FROM Studnet s WHERE s.id.nume = "gigel"
        var nume  = "gigel";

        CriteriaQuery<Student> query = builder.createQuery(Student.class);

        Root<Student> root = query.from(Student.class); // echivalent cu "s" din SELECT s FROM...

        Predicate predicate = builder.conjunction(); //1=1

        if(nume != null){

            predicate = builder.and(
                    predicate,
                    builder.equal(root.get("id").get("nume"), nume) // echivalent cu s.id.nume = : nume
            );
        }
        //predicate = 1= 1 AND s.id.nume = "gigel"
        query.where(predicate);

        List<Student> studenti = em.createQuery(query)
                .getResultList();

        studenti.forEach(System.out::println);








        em.close();
        emf.close();

    }

}
