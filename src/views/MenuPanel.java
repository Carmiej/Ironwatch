package views;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import models.Player;

import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import models.IronwatchDB;

public class MenuPanel extends JPanel {

    JButton startButton = new JButton("Start");
    private JTextField textField;

    public MenuPanel(Player player, IronwatchDB db) {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setBounds(100, 100, 400, 340);
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        startButton.setBounds(220, 150, 89, 23);
        add(startButton);

        textField = new JTextField();
        textField.setBounds(52, 150, 137, 20);
        add(textField);
        textField.setColumns(10);

        JLabel nameLabel = new JLabel("Please enter a player name");
        nameLabel.setBounds(52, 134, 158, 14);
        add(nameLabel);

        JLabel gravePlaque = new JLabel("~Graveyard (Database) of Fallen Heroes~");
        gravePlaque.setBounds(80, 210, 250, 14);
        add(gravePlaque);
        DefaultListModel listModel = new DefaultListModel();
        String[] heroes = db.getTable();

        for (int x = 0; x < heroes.length; x++) {
            listModel.addElement(heroes[heroes.length-x-1]);
        }

        JList list = new JList(listModel);
        list.setBounds(50, 230, 300, 80);
        add(list);
    }

    public JButton getButton() {
        return startButton;
    }

    public JTextField getField() {
        return textField;
    }
}
