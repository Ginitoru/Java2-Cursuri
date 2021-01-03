package service.impl;

import dao.FolderDao;
import dao.impl.FolderDaoImpl;
import entities.Folder;
import service.FolderService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FolderServiceImpl implements FolderService {

    private FolderDao folderDao;



    public FolderServiceImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercitiu");
        EntityManager em = emf.createEntityManager();

        this.folderDao = new FolderDaoImpl(em);
    }

    @Override
    public void persist(Folder folder) {
            folderDao.persist(folder);
    }

    @Override
    public void delete(int id) {

        Folder folder = find(id);
        if(folder != null){
            folderDao.delete(folder);
        }else{
            System.out.println("nu exista folderul");
        }

    }

    @Override
    public Folder find(int id) {
        return folderDao.find(id);
    }
}
