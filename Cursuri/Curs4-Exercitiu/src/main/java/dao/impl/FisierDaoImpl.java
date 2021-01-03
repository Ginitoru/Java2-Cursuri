package dao.impl;

import dao.FisierDao;
import entities.Fisier;

import javax.persistence.EntityManager;

public class FisierDaoImpl implements FisierDao {

    private EntityManager entityManager;

    public FisierDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void persist(Fisier fisier) {
        entityManager.getTransaction().begin();
        entityManager.persist(fisier);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Fisier fisier) {
        entityManager.getTransaction().begin();
        entityManager.remove(fisier);
        entityManager.getTransaction().commit();
    }

    @Override
    public Fisier find(int id) {
        return entityManager.find(Fisier.class, id);
    }
}
