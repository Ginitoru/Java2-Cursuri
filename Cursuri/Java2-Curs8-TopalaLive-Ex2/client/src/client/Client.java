package client;

import client.controller.MessageController;
import client.gui.MainFrmae;
import lib.dto.StatusEvent;

import javax.swing.*;

public class Client {

    public static void main(String[] args) {

        var user = JOptionPane.showInputDialog("username: ");

        MessageController.getInstance().changeStatus(new StatusEvent(user, StatusEvent.Status.CONNECTED));

        new MainFrmae(user);


    }









}
