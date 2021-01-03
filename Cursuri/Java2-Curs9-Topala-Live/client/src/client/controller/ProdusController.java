package client.controller;

import lib.dto.ProdusDto;
import lib.service.ProdusService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Collection;

public class ProdusController {


    private ProdusService produsService;

    private ProdusController(){

        try {
            var registry = LocateRegistry.getRegistry("localhost", 4546);
            produsService = (ProdusService) registry.lookup("prduseService");


        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            e.printStackTrace();
        }


    }



    public void persist(ProdusDto produsDto){

        try {
            produsService.persist(produsDto);
        } catch (RemoteException e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        }
    }

    public Collection<ProdusDto> findAll(){

        try {
          return  produsService.findAll();
        } catch (RemoteException e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        }
    }






    private static final class SingletonHolder{
        public static final ProdusController INSTANACE = new ProdusController();
    }

    public static ProdusController getInstance(){
        return SingletonHolder.INSTANACE;
    }

}
