package frames;

import javax.swing.*;
import java.awt.*;

public class TrasnparentButton extends JButton {

    public TrasnparentButton(int x, int y, int width, int height) {
        this.setBounds(x,y,width, height);
        this.setBorderPainted(false);
        this.setOpaque(false);
        this.setBackground(new Color(255,255,255,0));
        this.setContentAreaFilled(false);
      //  mouseListeners();

    }

    @Override
    protected void paintComponent(Graphics g) {

        if (!isOpaque() && getBackground().getAlpha() < 255) {
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        super.paintComponent(g);
    }


//    private void mouseListeners(){
//        this.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                Component x = e.getComponent();
//
//                x.setBackground(new Color(255,255,255,150));
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                Component x = e.getComponent();
//                x.setBackground(new Color(0,0,0,0));
//            }
//        });
//
//
//    }

}
