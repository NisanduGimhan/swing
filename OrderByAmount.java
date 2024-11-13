
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.File;
import javax.swing.table.*;

class OrderByAmount extends JFrame {

  private JButton btnBack, btnPlace;
  private JLabel lblPhoneNumber;
  private JTextField txtfPhoneNo;
  private JTable tblCustomer;
  private DefaultTableModel dtm;

  private CustomerCollection customerCollection;

  OrderByAmount(CustomerCollection customerCollection) {
    this.customerCollection = customerCollection;

    // Frame
    setSize(550, 360);
    setTitle("Order By Amount ");
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

    String[] columnNames = { "OrderId", "Phone No", "Size", "Qty", "Amount", "Status" };
    dtm = new DefaultTableModel(columnNames, 0);
    customerCollection.odramount();
    for (int i = 0; i < customerCollection.odramount.length; i++) {
      Object[] row = { customerCollection.odramount[i].getOrderId(), customerCollection.odramount[i].getPhoneNumber(),
          customerCollection.odramount[i].getSize(), customerCollection.odramount[i].getQty(),
          customerCollection.odramount[i].getAmount(), customerCollection.odramount[i].getStatus() };
      dtm.addRow(row);
    }

    tblCustomer = new JTable(dtm);
    JScrollPane tablePane = new JScrollPane(tblCustomer);
    tablePane.setBounds(15, 50, 500, 250);
    add(tablePane);

  }

}
