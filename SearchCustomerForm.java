import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.*;

class SearchCustomerForm extends JFrame {

    private JButton btnBack, btnSearch;
    private JLabel lblPhoneNumber, lblTotal;
    private JTextField txtfPhoneNo;
    private JTable tblCustomer;
    private DefaultTableModel dtm;
    private CustomerCollection customerCollection;

    SearchCustomerForm(CustomerCollection customerCollection) {
        this.customerCollection = customerCollection;

        // Frame setup
        setSize(450, 400);
        setTitle("Search Customer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Back button
        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Arial", Font.BOLD, 14));
        btnBack.setBackground(new Color(233, 89, 89));
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(10, 10, 80, 30);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HomePage(customerCollection).setVisible(true);
            }
        });
        add(btnBack);

        // Phone Number label and text field
        lblPhoneNumber = new JLabel("Phone No :");
        lblPhoneNumber.setFont(new Font("Arial", Font.BOLD, 15));
        lblPhoneNumber.setBounds(35, 60, 100, 35);
        add(lblPhoneNumber);

        txtfPhoneNo = new JTextField();
        txtfPhoneNo.setBounds(130, 60, 150, 35);
        add(txtfPhoneNo);

        // Search button
        btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("Arial", Font.BOLD, 16));
        btnSearch.setBackground(new Color(0, 128, 128));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setBounds(300, 60, 100, 30);
        btnSearch.addActionListener(evt -> {
            String phoneNo = txtfPhoneNo.getText();
            boolean isFound = customerCollection.searchCustomer(phoneNo);

            if (!isFound) {
                JOptionPane.showMessageDialog(null, "Customer not found!");
            } else {
                loadCustomerData();
            }
        });
        add(btnSearch);

        // Table setup
        String[] columnNames = { "Size", "Qty", "Amount" };
        dtm = new DefaultTableModel(columnNames, 0);
        tblCustomer = new JTable(dtm);

        // Adding initial rows for each size
        String[] sizes = { "L", "M", "XS", "S", "XL", "XXL" };
        for (String size : sizes) {
            dtm.addRow(new Object[] { size, 0, "0.00" });
        }

        JScrollPane scrollPane = new JScrollPane(tblCustomer);
        scrollPane.setBounds(25, 110, 400, 150);
        add(scrollPane);

        // Total label
        lblTotal = new JLabel("Total : 0.00");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 16));
        lblTotal.setBounds(300, 270, 150, 30);
        add(lblTotal);

    }

    private void loadCustomerData() {
        // Reset table data
        for (int i = 0; i < dtm.getRowCount(); i++) {
            dtm.setValueAt(0, i, 1); // Set quantity to 0
            dtm.setValueAt("0.00", i, 2); // Set amount to 0.00
        }

        double totalAmount = 0.0;
        String phoneNo = txtfPhoneNo.getText();

        boolean isFound = customerCollection.searchCustomer(phoneNo);

        if (!isFound) {
            JOptionPane.showMessageDialog(null, "Customer not found!");
            return;
        }

        // Populate table with customer data
        for (Customer customer : customerCollection.getCustomerObjects()) {
            if (customer.getPhoneNumber().equals(phoneNo)) {
                String size = customer.getSize();
                int qty = customer.getQty();
                double amount = customer.getAmount();

                for (int i = 0; i < dtm.getRowCount(); i++) {
                    if (dtm.getValueAt(i, 0).equals(size)) {
                        dtm.setValueAt(qty, i, 1);
                        dtm.setValueAt(String.format("%.2f", amount), i, 2);
                        totalAmount += amount;
                        break;
                    }
                }
            }
        }

        lblTotal.setText("Total : " + String.format("%.2f", totalAmount));
        revalidate();
        repaint();
    }
}
