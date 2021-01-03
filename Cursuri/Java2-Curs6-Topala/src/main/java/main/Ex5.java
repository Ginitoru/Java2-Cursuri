package main;

import db.ex3.Student;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Ex5 {
    public static void main(String[] args) {

        var emf = Persistence.createEntityManagerFactory("curs6PU");
        var em = emf.createEntityManager();

        //SELECT * FROM student -> nativ
        //SELECT s FROM Student s ->JPQL




        TypedQuery<Student> query =
                em.createQuery("SELECT s FROM Student s WHERE s.id.nume = ?0 AND s.id.prenume=:nume", Student.class);

        //in JPQL putem defini parametrii de tipul:
        // - index: (?0)
        //-named: (:prenume)

//        query.getResultList();
//
//        query.setParameter(0,"ion");
//        query.setParameter("prenume", "ion");
//
//        List<Student> studenti = query.getResultList();
//
//        studenti.forEach(System.out::println);
//
//        System.out.println("================");

        //named queris

      var namedQuery =   em.createNamedQuery("Studet.findAll", Student.class);

      namedQuery.getResultList().forEach(System.out::println);

        em.close();
        emf.close();
    }
}
