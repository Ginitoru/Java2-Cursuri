package main;

import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class Myopia {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createUI();
            }
        });
    }

    public static void createUI() {
        JFrame f = new JFrame ("Myopia");

        LayerUI<JComponent> layerUI = new BlurLayerUI();
        JPanel panel = createPanel();
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.green);
        JLayer<JComponent> jlayer = new JLayer<JComponent>(panel, layerUI);
        f.add(panel2);
       // panel2.add(jlayer);
       f.add (jlayer);

        f.setSize(300, 200);
        f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo (null);

        f.setVisible (true);
    }

    private static JPanel createPanel() {
        JPanel p = new JPanel();

//        ButtonGroup entreeGroup = new ButtonGroup();
//        JRadioButton radioButton;
//        p.add(radioButton = new JRadioButton("Beef", true));
//        entreeGroup.add(radioButton);
//        p.add(radioButton = new JRadioButton("Chicken"));
//        entreeGroup.add(radioButton);
//        p.add(radioButton = new JRadioButton("Vegetable"));
//        entreeGroup.add(radioButton);
//
//        p.add(new JCheckBox("Ketchup"));
//        p.add(new JCheckBox("Mustard"));
//        p.add(new JCheckBox("Pickles"));
//
//        p.add(new JLabel("Special requests:"));
//        p.add(new JTextField(20));
//
//        JButton orderButton = new JButton("Place Order");
//        p.setBounds(0,0,200,200);
//        p.add(orderButton);

        JLabel x= new JLabel("XXXXXX");
        p.add(x);

        p.setBounds(0,0,200,200);
        p.setBackground(new Color(255,255,255,50));

        return p;
    }
}

class BlurLayerUI extends LayerUI<JComponent> {
    private BufferedImage mOffscreenImage;
    private BufferedImageOp mOperation;

    public BlurLayerUI() {
        float ninth = 1.0f / 9.0f;
        float[] blurKernel = {
                ninth, ninth, ninth,
                ninth, ninth, ninth,
                ninth, ninth, ninth
        };
        mOperation = new ConvolveOp(
                new Kernel(3, 3, blurKernel),
                ConvolveOp.EDGE_NO_OP, null);
    }

    @Override
    public void paint (Graphics g, JComponent c) {
        int w = c.getWidth();
        int h = c.getHeight();

        if (w == 0 || h == 0) {
            return;
        }

        // Only create the offscreen image if the one we have
        // is the wrong size.
        if (mOffscreenImage == null ||
                mOffscreenImage.getWidth() != w ||
                mOffscreenImage.getHeight() != h) {
            mOffscreenImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        }
        System.out.println("xxxxx");
        Graphics2D ig2 = mOffscreenImage.createGraphics();
        ig2.setClip(g.getClip());
        super.paint(ig2, c);
        ig2.dispose();

        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(mOffscreenImage, mOperation, 0, 0);
    }
}
