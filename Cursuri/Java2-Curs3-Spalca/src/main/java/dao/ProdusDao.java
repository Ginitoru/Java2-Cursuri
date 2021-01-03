package dao;

import db.Produs;

import javax.persistence.EntityManager;

public class ProdusDao {

    private EntityManager em;

    public ProdusDao(EntityManager em) {
        this.em = em;
    }

    public void adaugaProdus(Produs p){
        em.persist(p);
    }

    public Produs getProdus(int id){
        return em.find(Produs.class, id);
    }

    public void stergeProdus(Produs p){
        em.remove(p);
    }

    public Produs mergeProdus(Produs p){
       return em.merge(p);
    }

    public void clearContext(){
        em.clear();

    }

    public void closeContext(){
        em.close();
    }



}
