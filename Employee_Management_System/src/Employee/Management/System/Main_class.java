package Employee.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Main_class extends JFrame {
    Main_class() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1120, 630);
        add(img);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(220, 155, 800, 50);
        heading.setFont(new Font("Raleway", Font.BOLD, 40));
        img.add(heading);

        JButton add = new JButton("Add Employee");
        add.setBounds(335, 270, 150, 40);
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        img.add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
                setVisible(false);
            }
        });

        JButton view = new JButton("View Employee");
        view.setBounds(565, 270, 150, 40);
        view.setForeground(Color.white);
        view.setBackground(Color.black);
        img.add(view);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new View_Employee();
                setVisible(false);
            }
        });

        JButton rem = new JButton("Remove Employee");
        rem.setBounds(565, 370, 150, 40);
        rem.setForeground(Color.white);
        rem.setBackground(Color.black);
        img.add(rem);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveEmployee();
                setVisible(false);
            }
        });

        JButton reportBtn = new JButton("Summary Report");
        reportBtn.setBounds(335, 370, 150, 40);
        reportBtn.setForeground(Color.white);
        reportBtn.setBackground(Color.black);
        img.add(reportBtn);
        reportBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmployeeSummaryReport();
                setVisible(false);
            }
        });

        // New button for Department Management
        JButton deptBtn = new JButton("Manage Departments");
        deptBtn.setBounds(450, 470, 200, 40);  // Placed below the other buttons, centered between them
        deptBtn.setForeground(Color.white);
        deptBtn.setBackground(Color.black);
        img.add(deptBtn);
        deptBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManageDepartment();  // You need to create this class separately
                setVisible(false);
            }
        });

        // ✅ New button for Custom Query
        JButton customQueryBtn = new JButton("Custom Query");
        customQueryBtn.setBounds(450, 530, 200, 40);  // Aligned below the last button
        customQueryBtn.setForeground(Color.white);
        customQueryBtn.setBackground(Color.black);
        img.add(customQueryBtn);
        customQueryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomQuery();  // You need to create this class separately
                setVisible(false);
            }
        });

        setSize(1120, 630);
        setLocation(250, 100);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main_class();
    }
}
