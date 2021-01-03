package client.controller;

import lib.api.MessageService;
import lib.dto.Event;
import lib.dto.MessageEvent;
import lib.dto.StatusEvent;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.List;

public class MessageController implements MessageService {

    private MessageService messageService;





    private MessageController(){
        try {
            var registry = LocateRegistry.getRegistry("localhost", 4545);

            messageService = (MessageService) registry.lookup("serviceMessage");
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void sendMessage(MessageEvent messageEvent) {
        try {
            messageService.sendMessage(messageEvent);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void changeStatus(StatusEvent statusEvent)  {
        try {
            messageService.changeStatus(statusEvent);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Event> getEvents(String user){

        try {
            return messageService.getEvents(user);
        } catch (RemoteException e) {
            e.printStackTrace();
           throw new RuntimeException(e);
        }
    }


    private static final class SingeltonHolder{
        public static final MessageController INSTANCE = new MessageController();
    }


    public static MessageController getInstance(){
        return SingeltonHolder.INSTANCE;
    }





}
