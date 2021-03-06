package dao.impl;

import dao.PisicaDao;
import entities.Pisica;

import javax.persistence.EntityManager;

public class PisicaDaoImpl implements PisicaDao {

    private EntityManager entityManager;

    public PisicaDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    @Override
    public void persist(Pisica p) {
        entityManager.getTransaction().begin();
        entityManager.persist(p);
        entityManager.getTransaction().commit();
    }

    @Override
    public Pisica find(int id) {
       return  entityManager.find(Pisica.class, id);
    }

    @Override
    public void remove(Pisica p) {
        entityManager.getTransaction().begin();
        entityManager.remove(p);// p trebuie sa faca parte din contextul de persistenta altfel ne va da o eroare.
        entityManager.getTransaction().commit();
    }

    @Override
    public Pisica refresh(Pisica p) {
        //actualizeaza instanta cu ce exista in  baza de date
        entityManager.refresh(p);
        return p;
    }

    @Override
    public Pisica merge(Pisica p) {
       //pune instanta de pisica in context
       return  entityManager.merge(p);

    }

    @Override
    public void detach(Pisica p) {
        // ii spunem entity manager-ului sa nu mai administreze instanta
        entityManager.detach(p);
    }

    @Override
    public void clear() {
        // detasam toate instantele administrate de EntityManager
        entityManager.clear();

    }

    @Override
    public void modifica(Pisica p) {
        entityManager.getTransaction().begin();
        Pisica merged = merge(p);

        entityManager.getTransaction().commit();
    }
}
