
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.File;
import javax.swing.table.*;

class AllOrders extends JFrame {

    private JButton btnBack, btnPlace;
    private JLabel lblPhoneNumber;
    private JTextField txtfPhoneNo;
    private JTable tblCustomer;
    private DefaultTableModel dtm;

    private CustomerCollection customerCollection;

    AllOrders(CustomerCollection customerCollection) {
        this.customerCollection = customerCollection;

        // Frame
        setSize(550, 360);
        setTitle("All Orders ");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        ;

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
        add(btnBack);

        // Defining the column names for the table
        String[] columnNames = { "OrderId", "Phone No", "Size", "Qty", "Amount", "Status" };
        dtm = new DefaultTableModel(columnNames, 0); // Creating a table model with column names and 0 rows

        for (Customer c1 : customerCollection.getCustomerObjects()) {
            Object[] rowData = { c1.getOrderId(), c1.getPhoneNumber(), c1.getSize(), c1.getQty(), c1.getAmount(),
                    c1.getStatus() };
            dtm.addRow(rowData);
        }

        tblCustomer = new JTable(dtm); // Creating a table with the defined table model
        JScrollPane tablePane = new JScrollPane(tblCustomer); // Adding the table to a scroll pane
        tablePane.setBounds(15, 50, 500, 250); // Setting position and size for the table
        add(tablePane); // Adding the scroll pane to the frame

    }

}
