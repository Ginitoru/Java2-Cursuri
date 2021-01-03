package client;

import javax.swing.*;

public class Client {
    public static void main(String[] args) {
        MessageController.getInstance();

        String usename = JOptionPane.showInputDialog("Username");

        new MainFrame(usename);
    }
}
