package server.service;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{

    private JPanel panel;
    private JLabel label;



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

        Image image = new ImageIcon("G:\\IntelliJ\\Java2\\Java2-Curs8-Exercitiu2\\server\\src\\server\\image\\flow-2.jpg").getImage()
                .getScaledInstance(960,540,Image.SCALE_SMOOTH);

        ImageIcon image1 = new ImageIcon(image);

        label.setSize(960,540);
        panel.add(label);
        label.setIcon(image1);



    }
}
