package service.impl;

import dao.ZborDao;
import dao.impl.ZborDaoImpl;
import entities.Avion;
import entities.TipAvion;
import entities.Zbor;
import service.ZborService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ZborServiceImpl implements ZborService {

    private ZborDao zborDao;
    private EntityManagerFactory emf;;
    private EntityManager em;

    public ZborServiceImpl() {

        this.emf = Persistence.createEntityManagerFactory("java2CU");
        this.em = emf.createEntityManager();
        this.zborDao = new ZborDaoImpl(em);

    }

    @Override
    public void persist(Zbor zbor) {
        try{
            zborDao.persist(zbor);
        }finally {
            this.closeResources();
        }

    }

    @Override
    public Zbor find(int id) {
        return zborDao.find(id);
    }

    @Override
    public void remove(int id) {

        try{

            Zbor zbor = zborDao.find(id);

            if(zbor != null) {
                zborDao.remove(zbor);
            }

            if(zbor == null){
                System.out.println("flight is not in the list");
            }

        }finally {
            this.closeResources();
        }
    }

    @Override
    public Zbor refresh(Zbor Zbor) {
        return zborDao.refresh(Zbor);
    }

    @Override
    public void detach(Zbor zbor) {
        zborDao.detach(zbor);
    }

    @Override
    public void clear() {
        zborDao.clear();
    }

    @Override
    public void update(int id, String plecare, TipAvion tipAvion) {

        try{

            Zbor zbor = new Zbor();
            Avion avion = new Avion();

            avion.setTipAvion(tipAvion);

            zbor.setId(id);
            zbor.setPlecare(plecare);
            zbor.setAvion(avion);

            zborDao.update(zbor);

        }finally {
            this.closeResources();
        }

    }

    private void closeResources(){
        em.close();
        emf.close();
    }
}
