
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.File;
import javax.swing.table.*;

class AllCustomerReport extends JFrame {

    private JButton btnBack, btnPlace;
    private JLabel lblPhoneNumber;
    private JTextField txtfPhoneNo;
    private JTable tblCustomer; // Table to display customer data
    private DefaultTableModel dtm; // Table model to manage data in the table

    private CustomerCollection customerCollection;

    AllCustomerReport(CustomerCollection customerCollection) {
        this.customerCollection = customerCollection;

        // Frame
        setSize(600, 360);
        setTitle("All Customer Report");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // back bttn
        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Arial", Font.BOLD, 14));
        btnBack.setBackground(new Color(233, 89, 89));
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(10, 10, 80, 30);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewReportsHomePage(customerCollection).setVisible(true);
            }
        });
        add(btnBack);

        String[] columnNames = { "Phone No", "XS", "S", "M", "L", "XL", "XLL", "Amount" };
        dtm = new DefaultTableModel(columnNames, 0);

        customerCollection.allInCustomer();
        for (Customer c1 : customerCollection.getUniqeCustomer()) {
            Object[] rowData = { c1.getPhoneNumber(), c1.getXS(), c1.getS(), c1.getM(), c1.getL(), c1.getXL(),
                    c1.getXXL(), c1.getAmount() };
            dtm.addRow(rowData);
        }

        tblCustomer = new JTable(dtm);
        JScrollPane tablePane = new JScrollPane(tblCustomer);
        tablePane.setBounds(15, 60, 560, 250);
        add(tablePane);

    }

}
