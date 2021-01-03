import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class BlurredImage extends JPanel {
    public void paint(Graphics g) {
        try {
            BufferedImage myImage = ImageIO.read(this.getClass().getResource("tycus.jpg"));

            BufferedImage filteredImage = new BufferedImage(myImage.getWidth(null), myImage
                    .getHeight(null), BufferedImage.TYPE_BYTE_GRAY);

            Graphics g1 = filteredImage.getGraphics();
            g1.drawImage(myImage, 1000, 1000, null);

            float[] blurKernel = { 1 / 9f, 1 / 9f, 1 / 9f, 1 / 9f, 1 / 9f, 1 / 9f, 1 / 9f, 1 / 9f, 1 / 9f };

            BufferedImageOp blur = new ConvolveOp(new Kernel(3, 3, blurKernel));
            myImage = blur.filter(myImage, null);
            g1.dispose();

            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(myImage, null, 3, 3);
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Blurred Image");
        frame.add(new BlurredImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

