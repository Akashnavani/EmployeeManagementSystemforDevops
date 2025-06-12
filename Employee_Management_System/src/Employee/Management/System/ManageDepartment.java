package Employee.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ManageDepartment extends JFrame implements ActionListener {
    JTextField deptNameField, locationField;
    JButton addBtn, deleteBtn, backBtn;
    Choice deptChoice;

    public ManageDepartment() {
        setTitle("Manage Departments");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel deptLabel = new JLabel("Department Name:");
        deptLabel.setBounds(30, 30, 150, 25);
        add(deptLabel);

        deptNameField = new JTextField();
        deptNameField.setBounds(180, 30, 150, 25);
        add(deptNameField);

        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setBounds(30, 70, 150, 25);
        add(locationLabel);

        locationField = new JTextField();
        locationField.setBounds(180, 70, 150, 25);
        add(locationField);

        addBtn = new JButton("Add Department");
        addBtn.setBounds(30, 110, 150, 30);
        addBtn.setBackground(Color.black);
        addBtn.setForeground(Color.white);
        addBtn.addActionListener(this);
        add(addBtn);

        JLabel existingLabel = new JLabel("Existing Departments:");
        existingLabel.setBounds(30, 160, 150, 25);
        add(existingLabel);

        deptChoice = new Choice();
        deptChoice.setBounds(180, 160, 150, 25);
        add(deptChoice);

        deleteBtn = new JButton("Delete Department");
        deleteBtn.setBounds(30, 200, 150, 30);
        deleteBtn.setBackground(Color.red);
        deleteBtn.setForeground(Color.white);
        deleteBtn.addActionListener(this);
        add(deleteBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(200, 200, 130, 30);
        backBtn.setBackground(Color.gray);
        backBtn.setForeground(Color.white);
        backBtn.addActionListener(this);
        add(backBtn);

        loadDepartments();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                new Main_class();
            }
        });

        setVisible(true);
    }

    private void loadDepartments() {
        deptChoice.removeAll();
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM department");
            while (rs.next()) {
                deptChoice.add(rs.getString("deptName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            String deptName = deptNameField.getText();
            String location = locationField.getText();
            if (deptName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Department Name cannot be empty");
                return;
            }
            try {
                conn c = new conn();
                String query = "INSERT INTO department (deptName, location) VALUES ('" + deptName + "', '" + location + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Department added successfully");
                loadDepartments();
                deptNameField.setText("");
                locationField.setText("");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error adding department: " + ex.getMessage());
            }
        } else if (e.getSource() == deleteBtn) {
            String deptName = deptChoice.getSelectedItem();
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete " + deptName + "?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    conn c = new conn();
                    String query = "DELETE FROM department WHERE deptName = '" + deptName + "'";
                    c.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(this, "Department deleted");
                    loadDepartments();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error deleting department: " + ex.getMessage());
                }
            }
        } else if (e.getSource() == backBtn) {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new ManageDepartment();
    }
}
