import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.File;
import javax.swing.table.*;

class ItemByQty extends JFrame {

    private JButton btnBack, btnPlace;
    private JLabel lblPhoneNumber;
    private JTextField txtfPhoneNo;
    private JTable tblCustomer;
    private DefaultTableModel dtm;

    private CustomerCollection customerCollection;

    ItemByQty(CustomerCollection customerCollection) {
        this.customerCollection = customerCollection;

        // Frame
        setSize(450, 360);
        setTitle("Item By Qty ");
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

        String[] columnNames = { "Size", "Qty", "Amount" };
        dtm = new DefaultTableModel(columnNames, 0);

        customerCollection.categorizedByQty();

        for (int i = 0; i < 6; i++) {
            Object[] row = { customerCollection.sortqty[i].getSize(), customerCollection.sortqty[i].getqty(),
                    customerCollection.sortqty[i].getamount() };
            dtm.addRow(row);
        }

        tblCustomer = new JTable(dtm);
        JScrollPane tablePane = new JScrollPane(tblCustomer);
        tablePane.setBounds(15, 50, 400, 250);
        add(tablePane);

    }

}
