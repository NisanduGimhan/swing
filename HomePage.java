import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.File;

class HomePage extends JFrame {

    private JLabel titleLabel;
    private JButton btnSearch, btnStatus, btnReports, btnDelete, btnPlaceOrder;
    private ImageIcon imageIcon;

    private CustomerCollection customerCollection;

    HomePage(CustomerCollection customerCollection) {
        this.customerCollection = customerCollection;
        setSize(500, 600);
        setTitle("Fashion Shop");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        titleLabel = new JLabel("Fashion Shop", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setBounds(0, 20, 500, 60);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(0, 102, 204));
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel);

        // Search
        btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("Arial", Font.BOLD, 14));
        btnSearch.setBounds(35, 120, 180, 45);
        btnSearch.addActionListener(evt -> {
            String[] options = { "Search Customer", "Search Order", "Cancel" };
            int choice = JOptionPane.showOptionDialog(null,
                    "Please select the option",
                    "Search Options",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,
                    options,
                    options[0]);
            switch (choice) {
                case 0:
                    System.out.println("Search Customer selected");
                    dispose();
                    new SearchCustomerForm(customerCollection).setVisible(true);
                    break;
                case 1:
                    System.out.println("Search Order selected");
                    dispose();
                    new SearchOrderForm(customerCollection).setVisible(true);
                    break;
                case 2:
                    System.out.println("Cancel selected");
                    // Add action for "Cancel"
                    break;
                default:
                    System.out.println("No option selected");
                    break;
            }
        });
        add(btnSearch);

        // Status
        btnStatus = new JButton("Status");
        btnStatus.setFont(new Font("Arial", Font.BOLD, 14));
        btnStatus.setBounds(35, 190, 180, 45);
        btnStatus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StatusForm(customerCollection).setVisible(true);
            }
        });
        add(btnStatus);

        // Report
        btnReports = new JButton("Report");
        btnReports.setFont(new Font("Arial", Font.BOLD, 14));
        btnReports.setBounds(35, 260, 180, 45);
        btnReports.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                new ViewReportsHomePage(customerCollection).setVisible(true);
            }
        });

        add(btnReports);

        // Delete
        btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Arial", Font.BOLD, 14));
        btnDelete.setBounds(35, 330, 180, 45);
        btnDelete.addActionListener(evt -> {
            dispose();
            new DeleteForm(customerCollection).setVisible(true);

        });
        add(btnDelete);

        // Place Order
        btnPlaceOrder = new JButton("Place Order");
        btnPlaceOrder.setFont(new Font("Arial", Font.BOLD, 25));
        btnPlaceOrder.setBounds(35, 430, 180, 65);
        btnPlaceOrder.setBackground(new Color(39, 186, 196));
        btnPlaceOrder.addActionListener(evt -> {
            dispose();
            new AddCustomerForm(customerCollection).setVisible(true);

        });
        add(btnPlaceOrder);

        imageIcon = new ImageIcon("C:\\Users\\Nisan\\Desktop\\swing\\img.jpg");
        JLabel labelx = new JLabel(imageIcon);
        labelx.setBounds(220, 0, 300, 1140);
        add(labelx);

    }

}
