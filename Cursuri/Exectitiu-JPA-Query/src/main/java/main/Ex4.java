package main;

import entiti.ex2.Employee;
import entiti.ex2.Task;

import javax.persistence.Persistence;
import java.util.List;

public class Ex4 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2PU");
        var em = emf.createEntityManager();



        try{
            Task t = new Task();
            t.setDescription("curata");
            t.setSupervisor("tilica");

            Task t1 = new Task();
            t1.setDescription("spalat");
            t1.setSupervisor("lica");

            Task t2 = new Task();
            t2.setDescription("cacare");
            t2.setSupervisor("gimbirel");

            Employee e = new Employee();
            e.setName("gigle");
            Employee e2 = new Employee();
            e2.setName("fane");
            Employee e3 = new Employee();
            e3.setName("dorel");
            Employee e4  = new Employee();
            e4.setName("bila");

            e.setTasks(List.of(t1, t2));
            e2.setTasks(List.of(t1, t2, t));
            e3.setTasks(List.of(t2));
            e4.setTasks(List.of(t));

            em.getTransaction().begin();
            em.persist(e);
            em.persist(e3);
            em.persist(e2);
            em.persist(e4);
            em.getTransaction().commit();


        }finally {
            em.close();
            emf.close();
        }
    }
}
