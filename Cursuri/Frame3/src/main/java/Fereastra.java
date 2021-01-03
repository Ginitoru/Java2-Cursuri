import org.jogamp.glg2d.GLG2DCanvas;

import javax.swing.*;

public class Fereastra extends JFrame {

    private Panou panel;
    private Canv canv;


    public Fereastra(){
        initFrame();
        this.setVisible(true);

    }


    private void initFrame(){
        this.setSize(800,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new Panou();
        canv = new Canv();

       // add(panel);

        this.setContentPane(new GLG2DCanvas(panel));




    }







}
