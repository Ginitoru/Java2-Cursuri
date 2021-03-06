package client.gui;

import client.controller.EventController;
import client.controller.EventListener;
import client.controller.MessageController;
import lib.dto.Event;
import lib.dto.MessageEvent;
import lib.dto.StatusEvent;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrmae extends JFrame implements EventListener {
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton button1;
    private JPanel mainPanel;

    private final String user;

    public MainFrmae(String user){
        super("Conectat: " + user);

        this.user= user;


        button1.addActionListener(ev ->{
            MessageController.getInstance().sendMessage(new MessageEvent(user, textArea2.getText()));

            textArea2.setText("");
        });


        EventController.getInstance().addListener(user, this);
        EventController.getInstance().listenForEvents(user);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MessageController.getInstance().changeStatus(new StatusEvent(user, StatusEvent.Status.DISCONEECTED));

                EventController.getInstance().removeListeners(user, MainFrmae.this);
            }
        });



        setContentPane(mainPanel);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void newEvent(Event event) {
        var message = "";

        if(event.getClass() == MessageEvent.class){
            var messageEvent = (MessageEvent) event;
            message = String.format("[%s] %s: %s", messageEvent.getInstant(),
                                                   messageEvent.getUser(),
                                                    messageEvent.getMessage());
        }else if(event.getClass() == StatusEvent.class){
            var statusEvent = (StatusEvent) event;

            message = String.format("%s is %s", statusEvent.getUser(), statusEvent.getStatus());

        }

        if(!message.trim().isBlank()){
            textArea1.append(message + "\n");
        }

    }
}
