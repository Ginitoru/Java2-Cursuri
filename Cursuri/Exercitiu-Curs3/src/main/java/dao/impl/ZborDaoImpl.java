package dao.impl;

import dao.ZborDao;
import entities.Zbor;

import javax.persistence.EntityManager;

public class ZborDaoImpl implements ZborDao {

    private EntityManager entityManager;

    public ZborDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void persist(Zbor zbor) {
        entityManager.getTransaction().begin();
        entityManager.persist(zbor);
        entityManager.getTransaction().commit();

    }

    @Override
    public Zbor find(int id) {
        return entityManager.find(Zbor.class, id);
    }

    @Override
    public void remove(Zbor zbor) {
        entityManager.getTransaction().begin();
        entityManager.remove(zbor);
        entityManager.getTransaction().commit();

    }

    @Override
    public Zbor refresh(Zbor zbor) {
         entityManager.refresh(zbor);
         return zbor;
    }

    @Override
    public Zbor merge(Zbor zbor) {

      return  entityManager.merge(zbor);

    }

    @Override
    public void detach(Zbor zbor) {
        entityManager.detach(zbor);
    }

    @Override
    public void clear() {
        entityManager.getClass();
    }

    @Override
    public void update(Zbor zbor) {
        entityManager.getTransaction().begin();
        entityManager.merge(zbor);
        entityManager.getTransaction().commit();

    }

}
