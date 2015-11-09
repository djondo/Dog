package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rudi on 11/9/2015.
 */
public class DogGuif extends JFrame {
    private JPanel rootPanel;
    private JCheckBox puppyCheckBox;
    private JButton addDogToListButton;
    private JTextField dogNameTextField;
    private JTextField dogAgeTextField;
    private JButton deleteDogButton;
    private JList DogJList;
    private JList<Dog> dogJList;

    DefaultListModel<Dog> dogListModel;


    public DogGuif() {
        super("List of dogs");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(new Dimension(300, 500));

        dogListModel = new DefaultListModel<Dog>();
        dogJList.setModel(dogListModel);
        dogJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        deleteDogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fetch and delete the selected dog object
                Dog toDelete = DogGuif.this.dogJList.getSelectedValue();
                DogGuif.this.dogListModel.removeElement(toDelete);
            }
        });
        addDogToListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Read in data from JTextFields and checkBox and make a new dog object
                // Add the dog object to the list
                String dogName = DogGuif.this.dogNameTextField.getText();
                String dogAgeAsString = dogAgeTextField.getText();
                int dogAge;

                try {
                    dogAge = Integer.parseInt(dogAgeAsString);
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(DogGuif.this, "Enter an integer number for dog's age");
                    return;
                }
                boolean isPuppy = puppyCheckBox.isSelected();
                Dog newDog = new Dog(dogName, isPuppy, dogAge);
                DogGuif.this.dogListModel.addElement(newDog);

            }


        });
    }
}
