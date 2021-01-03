package client.gui;

import client.controller.FileWorkServiceController;
import lib.dto.FileWorkerDTO;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {

    private JPanel panel;
    private JButton button;
    private JTextField textField;
    private JTextArea textArea;



    private String [] buttonName = {"ShowFiles", " ChangeDirectory", "CreateFile", "DeleteFile",
                                    "RenameFaile", "CreateDirectory"};


    private List<JButton> buttons = new ArrayList<>();




    public MainFrame(){
        initFrame();
        initButtons();
        initTextFiled();
        initTextArea();
        InitActionListers();
    }

    private void initFrame(){
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setLayout(null);
        this.add(panel);
        this.setVisible(true);

    }


    private void initButtons(){

        for(int i = 0; i < 5; i++ ){
            button = new JButton(buttonName[i]);
            button.setBounds(20,150 + i*50,200, 30);

            buttons.add(button);
            panel.add(button);

        }
    }

    private void initTextFiled(){
        textField = new JTextField();
        textField.setBounds(100, 450, 700, 50 );
        panel.add(textField);

    }

    private void initTextArea(){
        textArea = new JTextArea();
        textArea.setBounds(250,20,600,400);
        panel.add(textArea);
    }

    private void InitActionListers(){
        buttons.get(0).addActionListener(ev -> {
            textArea.setText("");

            FileWorkerDTO dto = new FileWorkerDTO(textField.getText());
            List<String> x =  FileWorkServiceController.getInstance().showFiles();
            System.out.println(x);
            textArea.append(x.toString());
            System.out.println("xxx");
        });


        buttons.get(2).addActionListener(ev ->{

            FileWorkerDTO dto = new FileWorkerDTO(textField.getText());

            System.out.println(textField.getText());

            FileWorkServiceController.getInstance().createFile(dto);
            System.out.println("yyyyy");

        });

        buttons.get(1).addActionListener(ev-> {
            FileWorkerDTO dto = new FileWorkerDTO(textField.getText());
            System.out.println(dto.getPath()+ "     --lll");


            FileWorkServiceController.getInstance().changeDirectory(dto);


        });

        buttons.get(3).addActionListener(ev->{
            FileWorkerDTO dto = new FileWorkerDTO(textField.getText());
            FileWorkServiceController.getInstance().deleteFile(dto);

        });


        buttons.get(4).addActionListener(ev ->{
            FileWorkerDTO dto = new FileWorkerDTO(textField.getText());
            FileWorkServiceController.getInstance().renameFile(dto);
            System.out.println("gggggg" + "\\" + dto.getPath());

        });



    }






}
