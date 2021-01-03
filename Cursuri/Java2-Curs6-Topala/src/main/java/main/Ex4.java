package main;

import db.ex3.Student;

import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Ex4 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("curs6PU");
        var em = emf.createEntityManager();


       Query query =  em.createNativeQuery("SELECT *FROM student", Student.class);

        List<Student> student = query.getResultList();

        student.forEach(System.out::println);


        em.close();
        emf.close();

    }
}
