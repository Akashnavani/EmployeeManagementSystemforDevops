package Employee.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.*;
import java.sql.ResultSet;

public class EmployeeSummaryReport extends JFrame implements Printable {

    JLabel totalEmpLabel, avgSalaryLabel;
    JButton printBtn;

    String reportText = "";

    public EmployeeSummaryReport() {
        setTitle("Employee Summary Report");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        totalEmpLabel = new JLabel("Total Employees: ");
        totalEmpLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(totalEmpLabel);

        avgSalaryLabel = new JLabel("Average Salary: ");
        avgSalaryLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(avgSalaryLabel);

        printBtn = new JButton("Print Report");
        printBtn.addActionListener(e -> printReport());
        add(printBtn);

        loadSummaryData();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Add window listener using named inner class
        addWindowListener(new ReportWindowListener());

        setVisible(true);
    }

    private void loadSummaryData() {
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT COUNT(*) AS empCount, AVG(salary) AS avgSalary FROM employee");

            if (rs.next()) {
                int empCount = rs.getInt("empCount");
                double avgSalary = rs.getDouble("avgSalary");

                totalEmpLabel.setText("Total Employees: " + empCount);
                avgSalaryLabel.setText(String.format("Average Salary: ₹%.2f", avgSalary));

                reportText = "Employee Summary Report\n\n";
                reportText += "Total Employees: " + empCount + "\n";
                reportText += String.format("Average Salary: ₹%.2f\n", avgSalary);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading summary data: " + ex.getMessage());
        }
    }

    private void printReport() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean doPrint = job.printDialog();
        if (doPrint) {
            try {
                job.print();
            } catch (PrinterException e) {
                JOptionPane.showMessageDialog(this, "Print error: " + e.getMessage());
            }
        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        g2d.setFont(new Font("Arial", Font.PLAIN, 12));
        int y = 20;
        for (String line : reportText.split("\n")) {
            g2d.drawString(line, 10, y);
            y += 15;
        }
        return PAGE_EXISTS;
    }

    // Named inner class for window listener to avoid anonymous class issues
    private class ReportWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            // Open main class window when this window closes
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new EmployeeSummaryReport();
    }
}
