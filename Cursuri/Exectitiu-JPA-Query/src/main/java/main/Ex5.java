package main;

import entiti.ex2.Employee;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Ex5 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2PU");
        var em = emf.createEntityManager();

        String x = "SELECT DISTINCT e FROM Employee e  JOIN FETCH e.tasks t";

//        TypedQuery<Employee> q = em.createQuery(x, Employee.class);
//      //  q.setParameter("supervisor", "lica");
//
//        List<Employee> employees = q.getResultList();
//
//        employees.forEach(System.out::println);
//
//        TypedQuery<Employee> q = em.createNamedQuery("findEmployy", Employee.class);
//
//       q.getResultStream()
//                .forEach(System.out::println);

        TypedQuery<Employee> u = em.createNamedQuery("findEmplyName", Employee.class);
       u.setParameter("name", "dorel");

        System.out.println("+++++++++++++++++++++++++++++++++++++");

       u.getResultStream()
               .forEach(System.out::println);











        em.close();
    }
}
