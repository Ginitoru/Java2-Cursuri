package client;

import mesaj.Mesaj;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;

public class Client extends JFrame {
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton button1;
    private JPanel mainpanel;

    String nume;

    public Client(String nume) throws IOException {
        this.nume = nume;
        connectToserver();
    }



    private void connectToserver() throws IOException {
        Socket socket = new Socket("localhost", 4545);

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in  = new ObjectInputStream(socket.getInputStream());

        new Thread(() ->{
                while(true) {

                    try {
                       Mesaj mesaj = (Mesaj) in.readObject();
                       SwingUtilities.invokeAndWait(() -> textArea1.append(mesaj + "\n"));

                    } catch (IOException | ClassNotFoundException | InterruptedException | InvocationTargetException e) {
                        e.printStackTrace();
                    }

                }
        }).start();

        button1.addActionListener(ev ->{
            String text = textArea2.getText();
            Mesaj mesaj = Mesaj.of(nume, text);

            try {
                out.writeObject(mesaj);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }



        });


    }




}
