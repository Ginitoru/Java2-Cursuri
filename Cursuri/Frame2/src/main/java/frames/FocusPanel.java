package frames;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FocusPanel extends WindowAdapter {

    JPanel transparentPanel;

    public FocusPanel(JPanel transparentPanel){
        this.transparentPanel = transparentPanel;

    }


    @Override
    public void windowGainedFocus(WindowEvent e) {
        super.windowGainedFocus(e);


    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        super.windowLostFocus(e);

    }
}
