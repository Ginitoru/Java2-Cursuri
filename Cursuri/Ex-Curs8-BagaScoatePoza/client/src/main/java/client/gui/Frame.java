package client.gui;

import client.controller.ImageController;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private JPanel panel;
    private JLabel label;


    public Frame() {

        initFrame();


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
        initBackGRoundLabel();
        this.add(panel);
        this.setVisible(true);



    }



    private void initBackGRoundLabel(){
        label = new JLabel();

        byte [] image = ImageController.getInstance().getImage();

//        ImageIcon image1 = new ImageIcon(image);
        Image image1 = new ImageIcon(image).getImage()
                    .getScaledInstance(960,540,Image.SCALE_SMOOTH);

        ImageIcon image2 = new ImageIcon(image1);

        label.setSize(960,540);
        panel.add(label);
        label.setIcon(image2);
    }


}
