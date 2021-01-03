package main;

import entity.ImageX;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private JPanel panel;
    private JLabel label;

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("java6PU");



    EntityManager em = emf.createEntityManager();

    ImageX image = em.find(ImageX.class, 2);


    ImageIcon imageIcon = new ImageIcon(image.getImage());







    public Frame() {
        initFrame();
        initBackGroundLabel();



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
        this.setVisible(true);

    }

    private void initBackGroundLabel(){
        label = new JLabel();

        Image image = new ImageIcon(imageIcon.getImage()).getImage()
                .getScaledInstance(960,540,Image.SCALE_SMOOTH);

        ImageIcon image1 = new ImageIcon(image);

        label.setSize(960,540);
        panel.add(label);
        label.setIcon(image1);




    }
}
