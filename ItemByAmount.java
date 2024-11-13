
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.File;
import javax.swing.table.*;

class ItemByAmount extends JFrame {

  private JButton btnBack, btnPlace;
  private JLabel lblPhoneNumber;
  private JTextField txtfPhoneNo;
  private JTable tblCustomer;
  private DefaultTableModel dtm;

  private CustomerCollection customerCollection;

  ItemByAmount(CustomerCollection customerCollection) {
    this.customerCollection = customerCollection;

    // Frame
    setSize(450, 360);
    setTitle("Item By Amount ");
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
    String[] columnNames = { "Size", "Qty", "Amount" };
    dtm = new DefaultTableModel(columnNames, 0); // Creating a table model with column names and 0 rows

    customerCollection.sortByamount();
    for (int i = 0; i < 6; i++) {
      Object[] row = { customerCollection.sortamount[i].getSize(), customerCollection.sortamount[i].getqty(),
          customerCollection.sortamount[i].getamount() };
      dtm.addRow(row);
    }

    tblCustomer = new JTable(dtm); // Creating a table with the defined table model
    JScrollPane tablePane = new JScrollPane(tblCustomer); // Adding the table to a scroll pane
    tablePane.setBounds(15, 50, 400, 250); // Setting position and size for the table
    add(tablePane); // Adding the scroll pane to the frame

  }

}
