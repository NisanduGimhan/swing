
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class SearchOrderForm extends JFrame {

    private JButton btnBack, btnSearch;
    private JTextField txtfID;
    private JLabel lblordId, lblID, lblPhoneNumber, lblSize, lblt, lblQty, lblAmount, lblPrice, lblStatus, lblStatusx,
            lblSizex, lblPhonenox, lblQtyx;
    private JTextField txtfPhoneNo, txtfSize, txtfQty;

    private CustomerCollection customerCollection;

    SearchOrderForm(CustomerCollection customerCollection) {

        this.customerCollection = customerCollection;

        // Frame
        setSize(450, 360);
        setTitle("Search Order");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // back bttn
        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Arial", Font.BOLD, 14));
        btnBack.setBackground(new Color(233, 89, 89));
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(2, 0, 80, 30);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HomePage(customerCollection).setVisible(true);
            }
        });
        add(btnBack);

        // ID
        lblID = new JLabel("Enter Order ID :");
        lblID.setFont(new Font("Arial", Font.BOLD, 15));
        lblID.setBounds(10, 40, 130, 35);
        add(lblID);

        // ID text Field
        txtfID = new JTextField("");
        txtfID.setBounds(130, 40, 150, 35);

        add(txtfID);

        // Search btn
        btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("Arial", Font.BOLD, 16));
        btnSearch.setBackground(new Color(0, 128, 128));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setBounds(300, 40, 100, 30);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                String orderID = txtfID.getText();
                int index = customerCollection.searchOrderId(orderID);

                if (index != -1) {

                    Customer customer = customerCollection.getCustomerObjects()[index];

                    lblPhonenox.setText(customer.getPhoneNumber());
                    lblSizex.setText(customer.getSize());
                    lblQtyx.setText(String.valueOf(customer.getQty()));
                    lblPrice.setText(String.valueOf(customer.getAmount()));
                    lblStatusx.setText(customer.getStatus());
                } else {
                    JOptionPane.showMessageDialog(null, "Order not found.");
                }
            }

        });
        add(btnSearch);

        // Phone Number
        lblPhoneNumber = new JLabel("Phone No :");
        lblPhoneNumber.setFont(new Font("Arial", Font.BOLD, 15));
        lblPhoneNumber.setBounds(10, 100, 130, 35);
        add(lblPhoneNumber);

        // phone no text Field
        lblPhonenox = new JLabel("");
        lblPhonenox.setFont(new Font("Arial", Font.BOLD, 15));
        lblPhonenox.setBounds(130, 100, 150, 35);
        add(lblPhonenox);

        // Size
        lblSize = new JLabel("Size :");
        lblSize.setFont(new Font("Arial", Font.BOLD, 15));
        lblSize.setBounds(10, 140, 130, 35);
        add(lblSize);

        // Size Text Field
        lblSizex = new JLabel("");
        lblSizex.setFont(new Font("Arial", Font.BOLD, 15));
        lblSizex.setBounds(130, 140, 150, 35);
        add(lblSizex);

        // Qty
        lblQty = new JLabel("Qty :");
        lblQty.setFont(new Font("Arial", Font.BOLD, 15));
        lblQty.setBounds(10, 180, 130, 35);
        add(lblQty);

        // Qty Text Field
        lblQtyx = new JLabel("");
        lblQtyx.setFont(new Font("Arial", Font.BOLD, 15));
        lblQtyx.setBounds(130, 180, 150, 35);
        add(lblQtyx);

        // Amount
        lblAmount = new JLabel("Amount :");
        lblAmount.setFont(new Font("Arial", Font.BOLD, 15));
        lblAmount.setBounds(10, 220, 130, 35);
        add(lblAmount);

        // Amount Text Field
        lblPrice = new JLabel("");
        lblPrice.setFont(new Font("Arial", Font.BOLD, 15));
        lblPrice.setBounds(130, 220, 150, 35);
        add(lblPrice);

        // Status
        lblStatus = new JLabel("Status :");
        lblStatus.setFont(new Font("Arial", Font.BOLD, 15));
        lblStatus.setBounds(10, 260, 130, 35);
        add(lblStatus);

        // Statusx Text Field
        lblStatusx = new JLabel("");
        lblStatusx.setFont(new Font("Arial", Font.BOLD, 14));
        lblStatusx.setBounds(130, 260, 150, 35);
        add(lblStatusx);

    }

}
