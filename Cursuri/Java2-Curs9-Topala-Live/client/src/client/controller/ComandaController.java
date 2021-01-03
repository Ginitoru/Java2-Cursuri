package client.controller;

import lib.dto.ComandaDto;
import lib.service.ComandaService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Collection;

public class ComandaController {

    private  ComandaService comandaService;


    private ComandaController(){
        try {
            var registry = LocateRegistry.getRegistry("localhost", 4546);
            comandaService = (ComandaService) registry.lookup("comandaService");

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }


    }


    private static final class SingletonHolder{
        public static final ComandaController INSTANCE = new ComandaController();
    }

    public static ComandaController getInstance(){
        return SingletonHolder.INSTANCE;

    }


    public void persist(ComandaDto comandaDto){
        try {
            comandaService.persists(comandaDto);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Collection<ComandaDto> findByProdusId(int produsID){
        try {
            return comandaService.findByProdusId(produsID);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
