package client;

import javax.swing.*;

public class Client {

    public static void main(String[] args) {

        String nume = JOptionPane.showInputDialog("nume: ");

        MainFrame frame = new MainFrame(nume);

        frame.startDisplayThread();


    }

}
