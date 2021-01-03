package client;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class MainFrame extends JFrame implements ClientMessageListener {
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton button1;
    private JPanel mainPanel;
    private DisplayThread displayThread;



    private String nume;


    public MainFrame(String nume){
        this.nume = nume;

        setTitle("nume: " + nume);
       button1.addActionListener( ev -> sendMessage());
       displayThread = new DisplayThread();
       displayThread.addClientMessageListener(this);


       setContentPane(mainPanel);
       setSize(600,600);






       setLocationRelativeTo(null);
       setVisible(true);

    }

    private void sendMessage(){
           String mesaj = textArea2.getText();
           ConnectionController.getInstance().sendMessage( nume + ": " + mesaj);
           textArea2.setText("");
    }

    public void startDisplayThread(){
        displayThread.start();
    }


    @Override
    public void messageRecived(String message) {
        try {
            SwingUtilities.invokeAndWait(() -> {
                textArea1.append(message + "\n");
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
