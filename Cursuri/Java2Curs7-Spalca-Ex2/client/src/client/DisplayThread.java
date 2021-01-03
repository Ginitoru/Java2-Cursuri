package client;

import java.util.ArrayList;
import java.util.List;

public class DisplayThread extends Thread {

    private List<ClientMessageListener> listeners;

    public DisplayThread(){
       listeners = new ArrayList<>();
    }

    public void run(){
        while(true){
            String mesaj = ConnectionController.getInstance().reciveMessage();

        }
    }


    public void addClientMessageListener(ClientMessageListener c){
        listeners.add(c);

    }

    private void notifyAllListeners(String message){
        listeners.forEach( c-> c.messageRecived(message));
    }



}
