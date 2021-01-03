package main;

import gui.MainFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        MainFrame mainFrame = new MainFrame();

        JFrame f = new JFrame();

        f.setContentPane(mainFrame.getPanel());

        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }
}
