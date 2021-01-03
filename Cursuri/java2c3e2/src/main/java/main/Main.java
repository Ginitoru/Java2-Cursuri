package main;

import gui.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        JFrame f = new JFrame();
        f.setContentPane(frame.getMainPanel());


        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);


    }

}
