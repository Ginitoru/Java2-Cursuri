package frames;

import media.SoundPlay;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {


    private JPanel panel;
    private JLabel backGroundLabel;
    private JLabel slideLabel;
    private TransparentPanel transparentPanel1;
    private TransparentPanel transparentPanel2;
    private int posX = 0, posY =0;
    int width = 960, height = 540;

    List<JButton> buttons;
    JButton button1;
    JButton button;
    private Image image;

    private static SoundPlay sound = new SoundPlay();

    boolean z = true;







    public MainFrame(){
        initFrame();
        setVisible(true);
        mouseListener();
        initBackGroundLabel();
        initSlideLabel();
        initButtons();
        initTransparentPanel();

//        initButton();
//        initTransButtton();

        changeFocus();
  //      focus2();
        sound.getSound();


      //  System.out.println(this.getFocusOwner());







    }

    private void initFrame(){

        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setSize(width, height);
        panel.setLayout(null);
        panel.setOpaque(false);
        this.add(panel);


    }




    private void initBackGroundLabel(){

        image = new ImageIcon("./src/main/resources/image/flow.jpg")
                .getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon image1 = new ImageIcon(image);

        backGroundLabel = new JLabel();
        backGroundLabel.setSize(width, height);

        panel.add(backGroundLabel);
        backGroundLabel.setIcon(image1);
        backGroundLabel.setOpaque(true);


    }

    private void initTransparentPanel() {
        transparentPanel1 = new TransparentPanel(0,0, 960,50);
        transparentPanel2 = new TransparentPanel(0,490, 960,50);
        backGroundLabel.add(transparentPanel1);
        backGroundLabel.add(transparentPanel2);


    }




    private void changeFocus(){


        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent e) {

                super.windowGainedFocus(e);
                System.out.println("Focus");
                transparentPanel1.setColor1(Color.RED);
                transparentPanel1.repaint();
                transparentPanel2.setColor1(Color.RED);
                transparentPanel2.repaint();

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                super.windowLostFocus(e);
                System.out.println("no focus");
                transparentPanel1.setColor1(Color.orange);
                transparentPanel1.repaint(); // ca sa repicteze panoul cu noua culoare altfel remane vechea culoare
                transparentPanel2.setColor1(Color.orange);
                transparentPanel2.repaint();
            }
        });
    }

//    void focus2(){
//        this.addWindowFocusListener(new FocusPanel(transparentPanel));
//
//
//    }

    private void initSlideLabel(){
        slideLabel = new JLabel();
        slideLabel.setBounds(0, 0, 150,490);
        backGroundLabel.add(slideLabel);
        JPanel x = new JPanel();
        x.setBounds(0, 50, 150,500);
        x.setBackground(new Color(20,150,150,90));
        slideLabel.add(x);


    }



//    private void initButton(){
//
//
//        button1 = new JButton("sound off" );
//
//      //  button1.paintComponents();
//
//
//
//        button1.setBounds(600, 200, 100 , 50);
//        button1.setOpaque(false);
//        button1.setBorderPainted(false);
//
//        button1.addActionListener(ev ->{
//
//
//
//
//            sound.getClip().stop();
//            sound.getClip().setMicrosecondPosition(0);
//
//
//
//
//
//
//
//        });
//
//        backGroundLabel.add(button1);
//    }

//    private void initTransButtton(){
//        but = new TrasnparentButton(400, 200, 100 , 50);
//        but.setText("cacat");
//
//        but.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                Component x = e.getComponent();
//                sound.getClip().start();
//                x.setBackground(new Color(255,255,255,150));
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                sound.getClip().stop();
//                sound.getClip().setMicrosecondPosition(0);
//                Component x = e.getComponent();
//                x.setBackground(new Color(0,0,0,0));
//
//
//
//            }
//        });
//        backGroundLabel.add(but);
//    }



    private void initButtons(){

        buttons = new ArrayList<>();

        String [] name = {"persist", "delete","find", "referesh", "clear", "detach" };

        for(int i = 0; i<= 5; i++){
            button = new TrasnparentButton(0, 100 + (i*55), 150,50);
            button.setText(name[i]);

            button.setBackground(new Color(0,0,0,0));
            button.setBorderPainted(false);
            button.setForeground(Color.WHITE);
            button.addActionListener( ev ->{

                sound.getClip().start();
                System.out.println("xx");

                blurImage();
//


            });




            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    Component but = e.getComponent();
                    sound.getClip().start();
                    but.setBackground(new Color(255,255,255,120));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    sound.getClip().stop();
                    sound.getClip().setMicrosecondPosition(0);
                    Component but = e.getComponent();
                    but.setBackground(new Color(0,0,0,0));

                }


            });





            slideLabel.add(button);
            buttons.add(button);
        }

    }












    private void mouseListener() {
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                posX = e.getX();
                posY = e.getY();
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {

                setLocation(e.getXOnScreen() - posX, e.getYOnScreen() - posY);

            }


        });

    }


    private void blurImage(){

        int size = 15;
        float number = 1.0f / (size*size);
        float [] data = new float[size*size];

        for(int i = 1; i< data.length; i++){
            data[i] = number;
        }

        Kernel kernel = new Kernel(size,size,data);



        File file = new File("./src/main/resources/image/flow.jpg");

        try {
            //faca o imagine buferizata


            BufferedImage  readImage = ImageIO.read(file);
            //face o subimagine a imaginii buferizata de mai sus
            BufferedImage subImage1 = readImage.getSubimage(0,0,330,1080);
          //  BufferedImage subImage2 = readImage.getSubimage(0,880,1920,200);
            //plm nu stiu ce face dar trebuie
            ColorModel cm = subImage1.getColorModel();
            //refac noua imagine si fac niste chestii
            BufferedImage src = new BufferedImage(cm, subImage1.copyData(subImage1.getRaster().createCompatibleWritableRaster()), cm.isAlphaPremultiplied(), null).getSubimage(0, 0, subImage1.getWidth(), subImage1.getHeight());
         //   BufferedImage src2 = new BufferedImage(cm, subImage2.copyData(subImage2.getRaster().createCompatibleWritableRaster()), cm.isAlphaPremultiplied(), null).getSubimage(0, 0, subImage2.getWidth(), subImage2.getHeight());
            //baga modificare de pixeli
            ConvolveOp convolveOp = new ConvolveOp(kernel,ConvolveOp.EDGE_NO_OP, null);
            //baga efectul de blurr pe poza
            convolveOp.filter(src, subImage1);
          //  convolveOp.filter(src2, subImage2);

            //fac crop la poza ca sa se potriveasca

            BufferedImage c=  readImage.getSubimage(30,0,1890,1080);



            Image image1 = new ImageIcon(c).getImage()
                    .getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon image2 = new ImageIcon(image1);
            backGroundLabel.setIcon(image2);
       //     new ConvolveOp(new Kernel(20,20, data),ConvolveOp.EDGE_NO_OP,null).filter(subImage1, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
