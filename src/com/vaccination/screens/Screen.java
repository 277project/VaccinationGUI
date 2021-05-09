package com.vaccination.screens;

import com.vaccination.classes.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JFrame{
    private JTable SearchResults;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JButton searchButton;
    private JPanel panelMain;
    private JPanel panelTop;
    private JPanel panelBottom;
    private JPanel panelMiddle;
    private JLabel firstName;
    private JLabel lastName;

    Screen() {
        super("Search for persons");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        String[] cols = {"ID", "FN"};
        String[][] data = {{"12", "Wassim"}};
        SearchResults = new JTable(data, cols);

        JScrollPane sp=new JScrollPane(SearchResults);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String[][] data = Person.getData(firstName,lastName);
                String[] columns = {"ID", "First", "Last"};
                SearchResults = new JTable(data, columns);
            }
        });


    }

    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.setVisible(true);
    }


}
