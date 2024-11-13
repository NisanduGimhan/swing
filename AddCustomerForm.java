import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class AddCustomerForm extends JFrame {

  private JButton btnBack;
  private JButton btnPlace;
  private JLabel lblordId, lblID, lblPhoneNumber, lblSize, lblt, lblQty, lblAmount, lblPrice;
  private JTextField txtfPhoneNo, txtfSize, txtfQty;

  private CustomerCollection customerCollection;

  AddCustomerForm(CustomerCollection customerCollection) {
    this.customerCollection = customerCollection;
    setSize(400, 360);
    setTitle("Add Customer");
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
        new HomePage(customerCollection).setVisible(true);
      }
    });

    add(btnBack);

    // Order Id
    lblordId = new JLabel("Order ID :");
    lblordId.setFont(new Font("Arial", Font.BOLD, 14));
    lblordId.setBounds(35, 60, 100, 25);
    add(lblordId);

    // ORD#00001

    lblID = new JLabel(customerCollection.generateOrderId());
    lblID.setFont(new Font("Arial", Font.BOLD, 14));
    lblID.setBounds(130, 60, 100, 25);
    add(lblID);

    // Phone Number
    lblPhoneNumber = new JLabel("Phone No :");
    lblPhoneNumber.setFont(new Font("Arial", Font.BOLD, 14));
    lblPhoneNumber.setBounds(35, 100, 100, 25);
    add(lblPhoneNumber);

    // phone no text Field
    txtfPhoneNo = new JTextField();
    txtfPhoneNo.setBounds(130, 100, 100, 25);
    txtfPhoneNo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        String PhoneNo = txtfPhoneNo.getText();
        boolean isNumber = customerCollection.phoneNumberValidate(PhoneNo);

        if (!isNumber) {
          JOptionPane.showMessageDialog(null, "Invalid phone number.");
        }

      }
    });

    add(txtfPhoneNo);

    // Size
    lblSize = new JLabel("Size :");
    lblSize.setFont(new Font("Arial", Font.BOLD, 14));
    lblSize.setBounds(35, 140, 100, 25);
    add(lblSize);

    // Size Text Field
    txtfSize = new JTextField();
    txtfSize.setBounds(130, 140, 100, 25);
    txtfSize.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        String size = txtfSize.getText();
        boolean isSize = customerCollection.tSize(size);

        if (!isSize) {
          JOptionPane.showMessageDialog(null, "Invalid Size.");
        }

      }
    });
    add(txtfSize);

    // XS/S/M/L/XL/XXL
    lblt = new JLabel("(XS/S/M/L/XL/XXL)");
    lblt.setFont(new Font("Arial", Font.BOLD, 14));
    lblt.setBounds(240, 140, 140, 25);
    add(lblt);

    // Qty
    lblQty = new JLabel("Qty :");
    lblQty.setFont(new Font("Arial", Font.BOLD, 14));
    lblQty.setBounds(35, 180, 100, 25);
    add(lblQty);

    // Qty Text Field
    txtfQty = new JTextField();
    txtfQty.setBounds(130, 180, 100, 25);
    txtfQty.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        int qty = Integer.parseInt(txtfQty.getText());
        boolean isQty = customerCollection.qantity(qty);

        String size = txtfSize.getText();
        double finalAmount = customerCollection.amount(size, qty);
        lblPrice.setText(String.format("%.2f", (double) finalAmount));

        if (!isQty) {
          JOptionPane.showMessageDialog(null, "Invalid Qty.");
        }

      }
    });
    add(txtfQty);

    // Amount
    lblAmount = new JLabel("Amount :");
    lblAmount.setFont(new Font("Arial", Font.BOLD, 14));
    lblAmount.setBounds(35, 220, 100, 25);
    add(lblAmount);

    // Total Amount
    lblPrice = new JLabel("");
    lblPrice.setFont(new Font("Arial", Font.BOLD, 14));
    lblPrice.setBounds(130, 220, 100, 25);
    add(lblPrice);

    // place btn
    btnPlace = new JButton("Place");
    btnPlace.setFont(new Font("Arial", Font.BOLD, 16));
    btnPlace.setBackground(new Color(0, 128, 128));
    btnPlace.setForeground(Color.WHITE);
    btnPlace.setBounds(300, 280, 80, 30);
    btnPlace.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        String orderId = lblID.getText();
        String phoneNumber = txtfPhoneNo.getText();
        String size = txtfSize.getText();
        int qty = Integer.parseInt(txtfQty.getText());
        double amount = Double.parseDouble(lblPrice.getText());

        boolean isNumber = customerCollection.phoneNumberValidate(phoneNumber);
        boolean isQty = customerCollection.qantity(qty);
        boolean isSize = customerCollection.tSize(size);

        if (!isNumber) {
          JOptionPane.showMessageDialog(null, "Invalid phone number.");
          txtfPhoneNo.setText("");
        } else if (!isSize) {
          JOptionPane.showMessageDialog(null, "Invalid Size.");
          txtfSize.setText("");
        } else if (!isQty) {
          JOptionPane.showMessageDialog(null, "Invalid Qty.");
          txtfQty.setText("");
        } else {

          Customer c1 = new Customer(orderId, phoneNumber, size, qty, amount, 1);
          boolean isAdded = customerCollection.addCustomer(c1);

          if (isAdded) {
            JOptionPane.showMessageDialog(null, "Added Success..");

          }

          lblID.setText(customerCollection.generateOrderId());
          txtfPhoneNo.setText("");
          txtfSize.setText("");
          txtfQty.setText("");
          lblPrice.setText("");
        }
      }
    });
    add(btnPlace);

  }

}
