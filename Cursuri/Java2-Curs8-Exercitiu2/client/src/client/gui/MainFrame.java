package client.gui;

import client.controller.BackGroundImageController;

import javax.swing.*;

public class MainFrame extends JFrame {

    private JPanel panel;
    private JLabel label;



    public MainFrame() {
        initFrame();
//        initBackGroundLabel();



    }


    private void initFrame(){

        this.setSize(960, 540);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setSize(960,540);
        panel.setLayout(null);
        panel.setOpaque(false);
        this.add(panel);

        label = new JLabel();
        var image = BackGroundImageController.getInstance().getImage();
        label.setSize(960,540);
        panel.add(label);
        label.setIcon(image);


        this.setVisible(true);

    }

//    private void initBackGroundLabel(){
//        label = new JLabel();
//        var image = BackGroundImageController.getInstance().getImage();
//        label.setSize(960,540);
//        panel.add(label);
//        label.setIcon(image);
//
//
//    }
}
