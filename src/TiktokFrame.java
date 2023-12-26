import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TiktokFrame extends JFrame implements ActionListener {
    JButton uploadButton;

    JButton loginButton;
    JTextField textField;
    JTextArea textArea;
    JScrollPane scrollPane;

    //make array to store images path
    String[] imagesPath =
            {
                    "images\\4706201.jpg",
                    "images/5171295.jpg",
                    "tiktokBeta4\\src\\images\\5242220.jpg"};

    TiktokFrame(){
        this.setTitle("Tiktok Beta");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0xFFFFFF));
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        //no resize able
        this.setResizable(false);
        this.setSize(400, 600);

        // make container for label and loginButton
        JPanel topContainer = new JPanel();
        topContainer.setBounds(0, 0, 400, 70);
        topContainer.setBackground(new Color(0x252A34));
        topContainer.setLayout(null);
        this.add(topContainer);

        JLabel label = new JLabel("Tiktok Beta");
        label.setForeground(new Color(0xFFFFFF));
        label.setFont(new Font("Poppins", Font.BOLD, 24));
        label.setBounds(20, 20, 200, 30);
        topContainer.add(label);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginButton.setBackground(new Color(0xFF2E63));
        loginButton.setForeground(new Color(0xFFFFFF));
        loginButton.setFocusable(false);
        loginButton.setBorder(null);
        loginButton.setPreferredSize(new Dimension(100, 40));
        loginButton.setFont(new Font("Poppins", Font.BOLD, 14));
        loginButton.setBounds(250, 20, 100, 30);
        topContainer.add(loginButton);


        JPanel imageContainer = new JPanel();
        imageContainer.setBounds(0, 70, 400, 400);
        imageContainer.setBackground(new Color(0x252A34));
        imageContainer.setLayout(null);
        this.add(imageContainer);

        //make image
        JLabel imageLabel = new JLabel();
        imageLabel.setBounds(0, 0, 400, 400);
        Image originalImage = new ImageIcon("tiktokBeta4/src/images/5242220.jpg").getImage();
        Image resizeImage = originalImage.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon resizeIcon = new ImageIcon(resizeImage);
        imageLabel.setIcon(resizeIcon);
        imageContainer.add(imageLabel);


//        JLabel imageContainer = new JLabel();
//        imageContainer.setBounds(0, 70, 400, 400);
//
//        try {
//            ImageIcon originalIcon = new ImageIcon("D:\\Dunia Perkuliahan\\Semester 7\\regular\\prognet\\tubes\\tiktokBeta4\\images\\5242220.jpg");
//            Image originalImage = originalIcon.getImage();
//            Image resizeImage = originalImage.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
//            ImageIcon resizeIcon = new ImageIcon(resizeImage);
//            imageContainer.setIcon(resizeIcon);
//            this.add(imageContainer);
//
//            System.out.println("Current directory: " + System.getProperty("user.dir"));
//            System.out.println("Image loading successful.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }





        // make bottom container
        JPanel bottomContainer = new JPanel();
        bottomContainer.setBounds(0, 500, 400, 80);
        bottomContainer.setBackground(new Color(0x252A34));
        bottomContainer.setLayout(null);
        this.add(bottomContainer);

        //add upload button
        uploadButton = new JButton("Upload");
        uploadButton.addActionListener(this);
        uploadButton.setBackground(new Color(0xFF2E63));
        uploadButton.setForeground(new Color(0xFFFFFF));
        uploadButton.setPreferredSize(new Dimension(200, 40));
        uploadButton.setFont(new Font("Poppins", Font.BOLD, 14));
        uploadButton.setFocusable(false);
        uploadButton.setBorder(null);
        uploadButton.setBounds(100, 10, 200, 40);

        bottomContainer.add(uploadButton);


        this.setVisible(true);
    }

    //function to open login page
    public void openLoginPage(){
        Auth auth = new Auth();
        auth.setVisible(true);
    }

    //function to open upload page
    public void openUploadPage(){
        Upload upload = new Upload();
        upload.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("Action Performed: " + e.getActionCommand());
        if(e.getSource() == loginButton){
            System.out.println("Login Button Clicked");
            openLoginPage();
        }
        else if(e.getSource() == uploadButton){
            System.out.println("Upload Button Clicked");
            openUploadPage();

        }
    }
}
