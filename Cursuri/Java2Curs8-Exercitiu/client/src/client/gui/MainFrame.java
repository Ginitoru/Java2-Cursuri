package client.gui;

import client.controller.EventController;
import client.controller.EventListener;
import client.controller.MessageController;
import lib.dto.Event;
import lib.dto.MessageEvent;
import lib.dto.StatusEvent;

import javax.swing.*;

public class MainFrame extends JFrame implements EventListener {
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton button1;
    private JPanel panou;

    private final String user;

    public MainFrame(String user){
        super("connect:" + user);
        this.user = user;

        button1.addActionListener(ev -> {
            MessageController.getInstance().sendMessage(new MessageEvent(user, textArea2.getText()));

        });

        EventController.getInstance().addListener(user, this);
        EventController.getInstance().listenForEvents(user);

        setContentPane(panou);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void newEvent(Event event) {
        String message ="";

        if(event.getClass() == MessageEvent.class){

            MessageEvent messageEvent = (MessageEvent) event;

            message = messageEvent.getInstant().toString() + " " +
                     messageEvent.getUser() + " " +
                     messageEvent.getMessage();
        }else if(event.getClass() == StatusEvent.class){

            StatusEvent statusEvent = (StatusEvent) event;

            message = String.format("%s is %s", statusEvent.getUser(), statusEvent.getStatus());
        }

        if(!message.trim().isBlank()){
            textArea1.append(message + "\n");
        }


    }
}
