package client.gui;

import client.controller.ComandaController;
import client.controller.ProdusController;
import lib.dto.AdresaDto;
import lib.dto.Categorie;
import lib.dto.ComandaDto;
import lib.dto.ProdusDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProduseFrame extends JFrame {
    private JList list1;
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton adaugaButton;
    private JButton adaugaComandaButton;
    private DefaultListModel<ProdusDto> model = new DefaultListModel<>();

    public ProduseFrame(){

        list1.setModel(model);
        list1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        refresh();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(400, 700);
        setLocale(null);
        setVisible(true);


        adaugaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var produs = new ProdusDto(
                        textField1.getText(),
                        Double.parseDouble(textField2.getText()),
                                Categorie.ALIMENTE


                );

                ProdusController.getInstance().persist(produs);
                refresh();



                textField1.setText("");
                textField2.setText("");
            }
        });

        adaugaComandaButton.addActionListener(ev -> {
            var produse = (List<ProdusDto>) list1.getSelectedValuesList();

            if(!produse.isEmpty()){
                var total = produse.stream().mapToDouble(ProdusDto::getPret).sum();
                var ids = produse.stream().map(ProdusDto::getId).collect(Collectors.toSet());

                //todo: create dialog for insertin adress and phone numbers.

                var comanda = new ComandaDto(
                        total,
                        Instant.now(),
                        new AdresaDto("timisoara", "4"),
                        Set.of("123", "432"),
                        ids
                );

                ComandaController.getInstance().persist(comanda);
            }
        });

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                var selected = (ProdusDto) list1.getSelectedValue();

                if(selected != null && e.getClickCount() ==2){
                    new ComandaFrame(selected.getId());
                }
            }
        });

    }

    private void refresh(){
        var produse = ProdusController.getInstance().findAll();

        model.clear();
    }







}
