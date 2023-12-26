import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Auth extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    private JButton registerAddButton;
    private JTextField nameField;

    public Auth(){
        super("Login");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);

        this.getContentPane().setBackground(new Color(0x252A34));

        JLabel label = new JLabel("LOGIN");
        label.setForeground(new Color(0xFFFFFF));
        label.setFont(new Font("Poppins", Font.BOLD, 28));
        label.setBounds(150, 20, 100, 30);
        this.add(label);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setForeground(new Color(0xFFFFFF));
        emailLabel.setFont(new Font("Poppins", Font.PLAIN, 18));
        emailLabel.setBounds(50, 70, 100, 30);

        this.add(emailLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 70, 200, 30);
        this.add(usernameField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50, 120, 100, 30);
        passwordLabel.setForeground(new Color(0xFFFFFF));
        passwordLabel.setFont(new Font("Poppins", Font.PLAIN, 18));

        this.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 120, 200, 30);
        this.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(50, 170, 300, 40);
        loginButton.setBackground(new Color(0xFF2E63));
        loginButton.setForeground(new Color(0xFFFFFF));
        loginButton.setPreferredSize(new Dimension(200, 40));
        loginButton.setFont(new Font("Poppins", Font.BOLD, 14));
        loginButton.setFocusable(false);
        loginButton.setBorder(null);
        loginButton.addActionListener(this);
        this.add(loginButton);

        // make registration button
        registerButton = new JButton("Register");
        registerButton.setBounds(50, 220, 300, 40);
        registerButton.setBackground(new Color(0xFFFFFF));
        registerButton.setForeground(new Color(0x252A34));
        registerButton.setPreferredSize(new Dimension(200, 40));
        registerButton.setFont(new Font("Poppins", Font.PLAIN, 14));
        registerButton.setFocusable(false);
        // add red border in registerButton
        registerButton.setBorder(BorderFactory.createLineBorder(new Color(0xFF2E63), 2));

        registerButton.addActionListener(this);
        this.add(registerButton);


    }

    //make registration page
    public void openRegisterPage(){
        JFrame registerFrame = new JFrame("Register");
        registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registerFrame.setSize(400, 400);
        registerFrame.setLocationRelativeTo(null);
        registerFrame.setLayout(null);
        registerFrame.setVisible(true);

        registerFrame.getContentPane().setBackground(new Color(0x252A34));

        JLabel label = new JLabel("REGISTER");
        label.setForeground(new Color(0xFFFFFF));
        label.setFont(new Font("Poppins", Font.BOLD, 28));
        label.setBounds(150, 20, 200, 30);
        registerFrame.add(label);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setForeground(new Color(0xFFFFFF));
        nameLabel.setFont(new Font("Poppins", Font.PLAIN, 18));
        nameLabel.setBounds(50, 70, 100, 30);

        registerFrame.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 70, 200, 30);
        registerFrame.add(nameField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(50, 120, 100, 30);
        emailLabel.setForeground(new Color(0xFFFFFF));
        emailLabel.setFont(new Font("Poppins", Font.PLAIN, 18));
        registerFrame.add(emailLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 120, 200, 30);
        registerFrame.add(usernameField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50, 170, 100, 30);
        passwordLabel.setForeground(new Color(0xFFFFFF));
        passwordLabel.setFont(new Font("Poppins", Font.PLAIN, 18));
        registerFrame.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 170, 200, 30);
        registerFrame.add(passwordField);

        registerAddButton = new JButton("Register");
        registerAddButton.setBounds(50, 220, 300, 40);
        registerAddButton.setBackground(new Color(0xFF2E63));
        registerAddButton.setForeground(new Color(0xFFFFFF));
        registerAddButton.setPreferredSize(new Dimension(200, 40));
        registerAddButton.setFont(new Font("Poppins", Font.BOLD, 14));
        registerAddButton.setFocusable(false);
        registerAddButton.setBorder(null);
        registerAddButton.addActionListener(this);
        registerFrame.add(registerAddButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("Action Performed: " + e.getActionCommand());
        if(e.getSource() == loginButton){
            System.out.println("Login Button Clicked");
        }
        else if(e.getSource() == registerButton){
            System.out.println("Register Button Clicked");
            openRegisterPage();
        }
        else if(e.getSource() == registerAddButton){
            System.out.println("Register Add Button Clicked");
            JOptionPane.showMessageDialog(this, "Register Success");
        }
    }
}
