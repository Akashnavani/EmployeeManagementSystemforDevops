package Employee.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CustomQuery extends JFrame implements ActionListener {

    JTextArea queryArea;
    JButton executeButton, backButton;
    JTable resultTable;

    CustomQuery() {
        setTitle("Custom SQL Query Executor");
        setSize(900, 700);
        setLocation(300, 100);
        setLayout(null);
        getContentPane().setBackground(new Color(200, 230, 250));

        JLabel heading = new JLabel("Enter your custom SQL query:");
        heading.setBounds(30, 20, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(heading);

        queryArea = new JTextArea();
        queryArea.setBounds(30, 60, 800, 100);
        queryArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(queryArea);

        executeButton = new JButton("Execute");
        executeButton.setBounds(30, 170, 100, 30);
        executeButton.addActionListener(this);
        add(executeButton);

        backButton = new JButton("Back");
        backButton.setBounds(150, 170, 100, 30);
        backButton.addActionListener(this);
        add(backButton);

        resultTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(resultTable);
        scrollPane.setBounds(30, 220, 820, 400);
        add(scrollPane);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == executeButton) {
            String query = queryArea.getText().trim();
            if (query.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a SQL query.");
                return;
            }

            try {
                conn c = new conn();
                ResultSet rs = c.statement.executeQuery(query);
                resultTable.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        } else if (e.getSource() == backButton) {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new CustomQuery();
    }
}
