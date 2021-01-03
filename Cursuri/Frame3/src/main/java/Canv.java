import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;

public class Canv extends Canvas {

    private BufferStrategy bs;

    int i,j,k, d, h;
    boolean zz= true;
    BasicStroke wideStroke = new BasicStroke(10.0f);


    public Canv() {
        this.setSize(new Dimension(800, 800));
        animatie.start();
        animatie2.start();
        animatie3.start();
        this.setBackground(Color.black);

    }



    public void paint(Graphics g){

        super.paint(g);
        createBufferStrategy(3);
        bs = getBufferStrategy();

        Graphics2D  g2 = (Graphics2D) bs.getDrawGraphics();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Serif", Font.BOLD, 30));
        g2.drawString((d + "%"), 280,300);
        g2.drawLine(220,310,380,310);


        if(d < 100){
            g2.setFont(new Font("Serif", Font.BOLD, 17));
            g2.drawString("loading", 220,325);
        }else{
            g2.drawString("", 220,325);
        }



        g2.setFont(new Font("Serif", Font.BOLD, 24));

        if(h > 2){
            g2.drawString(".", 280,325);

        }

        if(h > 4){
            g2.drawString(".", 285,325);
        }

        if(h > 6){
            g2.drawString(".", 290,325);
        }

        if(h > 8){
            g2.drawString(".", 295,325);

        }

        if(h == 10){
            h =0;

        }










        if(d == 100){
            g2.setFont(new Font("Serif", Font.BOLD, 17));
            g2.drawString("powerd by", 220,325);
            g2.drawString("Ginitoru", 280,350);
        }


        g2.setColor(Color.orange);

        g2.drawLine(450,300,460,300);
        g2.drawLine(460,295,460,305);

        g2.drawLine(300,150,300,140);
        g2.drawLine(295,140,305,140);

        g2.drawLine(150,300,140,300);
        g2.drawLine(140,295,140,305);

        g2.drawLine(300,450,300,460);
        g2.drawLine(295,460,305,460);


        g2.setColor(Color.CYAN);
        g2.setStroke(wideStroke);



        g2.translate(300,300);
        g2.rotate(i* Math.PI/180);
        g2.translate(-300, -300);




        g2.drawArc(200, 200, 200, 200, 0, 60);
        g2.drawArc(200, 200, 200, 200, 90, 60);
        g2.drawArc(200, 200, 200, 200, 180, 60);
        g2.drawArc(200, 200, 200, 200, 270, 60);





        AffineTransform at = g2.getTransform();
        AffineTransform rotate = AffineTransform.getRotateInstance(Math.toRadians(-i), 300,300);
        g2.setTransform(rotate);
        //  BasicStroke wideStroke1 = new BasicStroke(2.0f);
        //   g2.setStroke(wideStroke1);

        g2.setColor(Color.RED);
//        g2.drawOval(449,300,10,10);
//        g2.drawOval(447,325,10,10);
//        g2.drawOval(440,350,10,10);
//        g2.drawOval(427,375,10,10);
//        g2.drawRect(500,400,5,10);

        g2.setTransform(at);

        AffineTransform at2 = g2.getTransform();
        AffineTransform rotate2 = AffineTransform.getRotateInstance(Math.toRadians(-j), 300,300);
        g2.setTransform(rotate2);
        g2.drawArc(190, 190, 220, 220, 30+k, 120 - 2*k);
        g2.drawArc(190, 190, 220, 220, 210+k , 120 - 2*k);
        g2.drawArc(190, 190, 220, 220, 0-k , 0 + 2*k);
        g2.drawArc(190, 190, 220, 220, 180-k , 0 + 2*k);
        g2.setTransform(at2);













//
//        g2.clearRect(0,0,800,800);// sterge canvas-ul
//
//        g2.drawRect(10,50,50,70);


//
        bs.show(); // arata
        bs.dispose(); //dispose

    }

    Timer animatie = new Timer(5,new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {


            i++;


//            System.out.println(i);
//            if(i == 360){
//                animatie.stop();
//            }


         //   repaint();
        }
    });

    Timer animatie2 = new Timer(80,new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(d < 100){
                d++;
                h++;
            }


            j++;



            //   System.out.println("zz este = " + zz);
            System.out.println(d);

        }
    });

    Timer animatie3 = new Timer(20,new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(zz == true && k < 60){

                k++;

                if(k == 60){
                    zz = false;
                }

            }

            if(zz == false && k > 0){

                k--;

                if(k == 0){
                    zz = true;
                }
            }

        }
    });















//
//
//
//
//
//
//        g = bs.getDrawGraphics();
//
//        g.clearRect(0,0,800,800);// sterge canvas-ul
//
//        g.drawRect(10,50,50,70);
//
//
//
//        bs.show(); // arata
//        bs.dispose(); //dispose








}
