package dao.impl;

import dao.FolderDao;
import entities.Folder;

import javax.persistence.EntityManager;

public class FolderDaoImpl implements FolderDao {

    private EntityManager entityManager;

    public FolderDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    @Override
    public void persist(Folder folder) {
        entityManager.getTransaction().begin();
        entityManager.persist(folder);
        entityManager.getTransaction().commit();

    }

    @Override
    public void delete(Folder folder) {
        entityManager.getTransaction().begin();
        entityManager.remove(folder);
        entityManager.getTransaction().commit();


    }

    @Override
    public Folder find(int id) {
        return entityManager.find(Folder.class, id);
    }
}
