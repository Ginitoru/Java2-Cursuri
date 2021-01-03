package service.impl;

import dao.FisierDao;
import dao.impl.FisierDaoImpl;
import entities.Fisier;
import service.FisierService;

import javax.persistence.Persistence;

public class FisierServiceImpl implements FisierService {

    FisierDao fisierDao;

    public FisierServiceImpl() {

        var emf = Persistence.createEntityManagerFactory("exercitiu");
        var em = emf.createEntityManager();

        this.fisierDao = new FisierDaoImpl(em);
    }

    @Override
    public void persist(Fisier fisier) {
        fisierDao.persist(fisier);
    }

    @Override
    public void remove(int id) {
        Fisier fisier = find(id);
        if(fisier != null){
            fisierDao.delete(fisier);
        }else{
            System.out.println("fisierul nu exista");
        }

    }

    @Override
    public Fisier find(int id) {
        return fisierDao.find(id);
    }
}
