package frames;

import javax.swing.*;
import java.awt.*;

public class TransparentPanel extends JPanel {



    int [] x = {100, 107, 853, 860,};
    int [] y = {0, 9, 9, 0};
    int [] y2 = {50,41,41,50};

    Polygon trapez = new Polygon(x, y, 4);
    Polygon trapez2 = new Polygon(x, y2, 4);

    Color color1 = Color.RED;


    public TransparentPanel(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setBackground(new Color(255 ,255,255,20));
        this.setOpaque(false);// cel mai important ca sa mearga panourile semitransparente

    }



    @Override
    protected void paintComponent(Graphics g) {

        if (!isOpaque() && getBackground().getAlpha() < 255) {
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());

        }
                if(this.getY() < 300){
                    g.drawPolygon(trapez);
                    g.setColor(color1);
                    g.fillPolygon(trapez);
                }else{
                    g.drawPolygon(trapez2);
                    g.setColor(color1);
                    g.fillPolygon(trapez2);

                }


        super.paintComponent(g);
    }



    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

}
