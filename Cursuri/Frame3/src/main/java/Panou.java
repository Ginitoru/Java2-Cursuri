import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;

public class Panou extends JPanel {

    private JButton buton;



 //   Graphics2D g2;
    int i,j,k, d, h, m;

    boolean zz= true;
       Arc2D arc =  new Arc2D.Double(200, 200, 200, 200, 0, 60,
    Arc2D.OPEN);







       Rectangle x = new Rectangle(200,200,100,100);


    public Panou() {
        this.setBounds(0,0,800,800);
        this.setLayout(null);
        this.setBackground(Color.BLACK);
//        initNuton();
    }

     BasicStroke wideStroke = new BasicStroke(10.0f);

    public void paint (Graphics g) {
        super.paintComponent(g);


        Graphics2D  g2 = (Graphics2D) g;

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

//        for(int x = 0; x <= 90; x+=3){
//            g2.drawLine(
//                    (int) (300 + (145 * Math.cos(Math.toRadians(x)))),
//                    (int) (300 - (145 * Math.sin(Math.toRadians(x)))),
//                    (int) (300 + (150 * Math.cos(Math.toRadians(x)))),
//                    (int) (300 - (150 * Math.sin(Math.toRadians(x)))));
//
//        }


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



        AffineTransform at3 = g2.getTransform();
        AffineTransform rotate3 = AffineTransform.getRotateInstance(Math.toRadians(m), 300,300);
        g2.setTransform(rotate3);

        BasicStroke wideStroke1 = new BasicStroke(0f);
        g2.setStroke(wideStroke1);
        g2.setColor(Color.orange);

        for(int x = 0; x <= 90; x+=5){
//            g2.drawLine(
//                    (int) (300 + (145 * Math.cos(Math.toRadians(x)))),
//                    (int) (300 - (145 * Math.sin(Math.toRadians(x)))),
//                    (int) (300 + (150 * Math.cos(Math.toRadians(x)))),
//                    (int) (300 - (150 * Math.sin(Math.toRadians(x)))));

            Line2D line = new Line2D.Double(
                    Math.round (300 + (145 * Math.cos(Math.toRadians(x)))),
                    Math.round (300 - (145 * Math.sin(Math.toRadians(x)))),
                     Math.round(300 + (155 * Math.cos(Math.toRadians(x)))),
                     Math.round(300 - (155 * Math.sin(Math.toRadians(x)))));
            g2.draw(line);

//            g2.drawOval((int) (300 + (145 * Math.cos(Math.toRadians(x)))),
//                    (int) (300 - (145 * Math.sin(Math.toRadians(x)))), 3,3);

        }



        g2.setTransform(at3);

        animatie.start();
        animatie2.start();
        animatie3.start();
        animatie4.start();

    }

    private void initNuton(){
        buton = new JButton("apasa");
        buton.setBounds(250,500,100,20);
        this.add(buton);
        buton.addActionListener(e ->{
            animatie.start();
            animatie2.start();
            animatie3.start();
            animatie4.start();
        } );
    }

        //barile cyan
     Timer animatie = new Timer(20,new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {





//            System.out.println(i);
//            if(i == 360){
//                animatie.stop();
//            }


            repaint();
        }
    });

    //cifrea incarcare loading
    Timer animatie2 = new Timer(80,new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(d < 100){
                d++;
                h++;
            }


            j++;



         //   System.out.println("zz este = " + zz);
         //   System.out.println(d);

        }
    });


    //barile rosii cresc si scad
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

    Timer animatie4 = new Timer(20,new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

           if(d < 50 && m < 90){ //liniutele pleaca
               m++;
           }

           if(d > 50 && m > 0){ // liniutele se intorc
               m--;
           }
            i++;

        }
    });

}
