import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.File;

public class ViewReportsHomePage extends JFrame {

    private JButton btnBack, btnViewCustomers, btnBestCustomers, btnAllCustomers,
            btnCategorizedByQty, btnCategorizedByAmount, btnOrdersByAmount, btnAllOrders;

    private CustomerCollection customerCollection;

    ViewReportsHomePage(CustomerCollection customerCollection) {
        this.customerCollection = customerCollection;

        setTitle("View Reports");
        setSize(650, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        // Back button
        btnBack = new JButton("Back");
        btnBack.setBounds(10, 10, 80, 30);
        btnBack.setBackground(new Color(255, 102, 102));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                new HomePage(customerCollection).setVisible(true);
            }
        });

        add(btnBack);

        // View Customers button
        btnViewCustomers = new JButton("View Customers");
        btnViewCustomers.setBounds(50, 60, 150, 40);
        btnViewCustomers.setBackground(new Color(0, 204, 0));
        btnViewCustomers.setForeground(Color.WHITE);
        btnViewCustomers.setFont(new Font("Arial", Font.BOLD, 12));
        btnViewCustomers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();

                new ViewCustomerForm(customerCollection).setVisible(true);
            }
        });

        add(btnViewCustomers);

        // Best in Customers button
        btnBestCustomers = new JButton("Best In Customers");
        btnBestCustomers.setBounds(50, 110, 150, 40);
        btnBestCustomers.setBackground(new Color(0, 204, 0));
        btnBestCustomers.setForeground(Color.WHITE);
        btnBestCustomers.setFont(new Font("Arial", Font.BOLD, 12));
        btnBestCustomers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new BestInCustomerForm(customerCollection).setVisible(true);
            }
        });

        add(btnBestCustomers);

        // All Customers button
        btnAllCustomers = new JButton("All Customers");
        btnAllCustomers.setBounds(50, 160, 150, 40);
        btnAllCustomers.setBackground(new Color(0, 204, 0));
        btnAllCustomers.setForeground(Color.WHITE);
        btnAllCustomers.setFont(new Font("Arial", Font.BOLD, 12));
        btnAllCustomers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AllCustomerReport(customerCollection).setVisible(true);
            }
        });

        add(btnAllCustomers);

        // Categorized By Qty button
        btnCategorizedByQty = new JButton("Categorized By QTY");
        btnCategorizedByQty.setBounds(220, 60, 180, 40);
        btnCategorizedByQty.setBackground(new Color(0, 51, 153));
        btnCategorizedByQty.setForeground(Color.WHITE);
        btnCategorizedByQty.setFont(new Font("Arial", Font.BOLD, 12));
        btnCategorizedByQty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ItemByQty(customerCollection).setVisible(true);
            }
        });

        add(btnCategorizedByQty);

        // Categorized By Amount button
        btnCategorizedByAmount = new JButton("Categorized By Amount");
        btnCategorizedByAmount.setBounds(220, 110, 180, 40);
        btnCategorizedByAmount.setBackground(new Color(0, 51, 153));
        btnCategorizedByAmount.setForeground(Color.WHITE);
        btnCategorizedByAmount.setFont(new Font("Arial", Font.BOLD, 12));
        btnCategorizedByAmount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ItemByAmount(customerCollection).setVisible(true);
            }
        });

        add(btnCategorizedByAmount);

        // Orders By Amount button
        btnOrdersByAmount = new JButton("Orders By Amount");
        btnOrdersByAmount.setBounds(420, 60, 180, 40);
        btnOrdersByAmount.setBackground(new Color(128, 128, 128));
        btnOrdersByAmount.setForeground(Color.WHITE);
        btnOrdersByAmount.setFont(new Font("Arial", Font.BOLD, 12));
        btnOrdersByAmount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new OrderByAmount(customerCollection).setVisible(true);
            }
        });

        add(btnOrdersByAmount);

        // All Orders button
        btnAllOrders = new JButton("All Orders");
        btnAllOrders.setBounds(420, 110, 180, 40);
        btnAllOrders.setBackground(new Color(128, 128, 128));
        btnAllOrders.setForeground(Color.WHITE);
        btnAllOrders.setFont(new Font("Arial", Font.BOLD, 12));
        btnAllOrders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AllOrders(customerCollection).setVisible(true);
            }
        });

        add(btnAllOrders);

    }
}
