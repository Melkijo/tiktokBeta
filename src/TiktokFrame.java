import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



public class TiktokFrame extends JFrame implements ActionListener {
    JButton uploadButton;

    JButton loginButton;

    JButton logoutButton;

    JButton refreshButton;

    JScrollPane scrollPane;

    JPanel scrollableContainer;

    PostList postList = new PostList();

    private boolean isLogin = false;

    private LoginData loginData ;

    TiktokFrame( boolean isLogin,LoginData loginData ) {

        this.isLogin = isLogin;
        this.loginData = loginData;

//    posts.add(new Post("caption1", "D:/Dunia Perkuliahan/Semester 7/regular/prognet/tubes/tiktokBeta4/src/images/4706201.jpg", "username1"));
//    posts.add(new Post("caption2", "D:/Dunia Perkuliahan/Semester 7/regular/prognet/tubes/tiktokBeta4/src/images/5171295.jpg", "username2"));
//    posts.add(new Post("caption3", "D:/Dunia Perkuliahan/Semester 7/regular/prognet/tubes/tiktokBeta4/src/images/5242220.jpg", "username3"));

        postList.addPost(new Post("Panic abstract", "D:/Dunia Perkuliahan/Semester 7/regular/prognet/tubes/tiktokBeta4/src/images/4706201.jpg", "John Doe"));
        postList.addPost(new Post("caption2", "D:/Dunia Perkuliahan/Semester 7/regular/prognet/tubes/tiktokBeta4/src/images/5171295.jpg", "username2"));
        postList.addPost(new Post("caption3", "D:/Dunia Perkuliahan/Semester 7/regular/prognet/tubes/tiktokBeta4/src/images/5242220.jpg", "username3"));

        this.setTitle("Tiktok Beta");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0xFFFFFF));
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        // no resize able
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


        //make logout button
        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(this);
        logoutButton.setBackground(new Color(0xFF2E63));
        logoutButton.setForeground(new Color(0xFFFFFF));
        logoutButton.setFocusable(false);
        logoutButton.setBorder(null);
        logoutButton.setPreferredSize(new Dimension(100, 40));
        logoutButton.setFont(new Font("Poppins", Font.BOLD, 14));
        logoutButton.setBounds(250, 20, 100, 30);

        if(!isLogin){
            logoutButton.setVisible(false);
        }

        topContainer.add(logoutButton);


        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginButton.setBackground(new Color(0xFF2E63));
        loginButton.setForeground(new Color(0xFFFFFF));
        loginButton.setFocusable(false);
        loginButton.setBorder(null);
        loginButton.setPreferredSize(new Dimension(100, 40));
        loginButton.setFont(new Font("Poppins", Font.BOLD, 14));
        loginButton.setBounds(250, 20, 100, 30);



        if(isLogin){
            loginButton.setVisible(false);
        }

        topContainer.add(loginButton);

        // Make scrollable container
        scrollableContainer = new JPanel();
        scrollableContainer.setBackground(new Color(0xFFFFFF));
        scrollableContainer.setLayout(new GridLayout(0, 1)); // Use GridLayout for vertical arrangement
        this.add(scrollableContainer);

        // Make scroll pane
        scrollPane = new JScrollPane(scrollableContainer);
        scrollPane.setBounds(0, 70, 385, 430);
        this.add(scrollPane);

        // Make image container
//        JPanel imageContainer = new JPanel();
//        imageContainer.setBackground(new Color(0xFFFFFF));
//        imageContainer.setLayout(new GridLayout(0, 1)); // Use GridLayout for vertical arrangement
//        scrollableContainer.add(imageContainer);

        //make post container

        updatePostList(postList);




        // make bottom container
        JPanel bottomContainer = new JPanel();
        bottomContainer.setBounds(0, 500, 400, 80);
        bottomContainer.setBackground(new Color(0x252A34));
        bottomContainer.setLayout(null);
        this.add(bottomContainer);

        // add upload button
        uploadButton = new JButton("Upload");
        uploadButton.addActionListener(this);
        uploadButton.setBackground(new Color(0xFF2E63));
        uploadButton.setForeground(new Color(0xFFFFFF));
        uploadButton.setPreferredSize(new Dimension(200, 40));
        uploadButton.setFont(new Font("Poppins", Font.BOLD, 14));
        uploadButton.setFocusable(false);
        uploadButton.setBorder(null);
        uploadButton.setBounds(20, 10, 200, 40);

        bottomContainer.add(uploadButton);

        // add refresh button
        refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(this);
        refreshButton.setBackground(new Color(0xFF2E63));
        refreshButton.setForeground(new Color(0xFFFFFF));
        refreshButton.setPreferredSize(new Dimension(75, 40));
        refreshButton.setFont(new Font("Poppins", Font.BOLD, 14));
        refreshButton.setFocusable(false);
        refreshButton.setBorder(null);
        refreshButton.setBounds(250, 10, 100, 40);

        bottomContainer.add(refreshButton);

        this.setVisible(true);
    }

    //make function that can auto update the login status
    public void updateLoginStatus(boolean isLogin){
        this.isLogin = isLogin;
        if(isLogin){
            loginButton.setVisible(false);
            logoutButton.setVisible(true);
        }else{
            loginButton.setVisible(true);
            logoutButton.setVisible(false);
        }
    }





    // function to open login page
    public void openLoginPage() {
        Auth auth = new Auth();
        auth.setVisible(true);
    }

    // function to open upload page
    public void openUploadPage() {
        Upload upload = new Upload(postList,loginData);
        upload.setVisible(true);
    }

    public void updatePostList( PostList postList){

        //remove the previos list
        scrollableContainer.removeAll();
        scrollableContainer.revalidate();
        scrollableContainer.repaint();


        // Make image, username and caption
        for (Post post : postList.getPosts()) {
            try {
                //make post container
                JPanel postContainer = new JPanel();
                postContainer.setBackground(new Color(0xFFFFFF));
                postContainer.setLayout(null);
                postContainer.setPreferredSize(new Dimension(360, 400));



                // make image
                BufferedImage image = ImageIO.read(new File(post.getUrl()));

                if(image == null){
                    image = ImageIO.read(new File("D:/Dunia Perkuliahan/Semester 7/regular/prognet/tubes/tiktokBeta4/src/images/4706201.jpg"));
                }

                JLabel imageLabel = new JLabel(new ImageIcon(image));



                //resize image
                imageLabel.setIcon(new ImageIcon(image.getScaledInstance(375, 300, Image.SCALE_SMOOTH)));

                imageLabel.setBounds(0, 0, 375, 300);
                postContainer.add(imageLabel);

                // make username
                JLabel usernameLabel = new JLabel(post.getUsername());
                usernameLabel.setBounds(20, 310, 100, 30);
                usernameLabel.setForeground(new Color(0x252A34));
                usernameLabel.setFont(new Font("Poppins", Font.BOLD, 14));
                postContainer.add(usernameLabel);

                //make button to view image
                JButton viewButton = new JButton("View");
                viewButton.setBounds(250, 310, 100, 30);
                viewButton.setBackground(new Color(0xFF2E63));
                viewButton.setForeground(new Color(0xFFFFFF));
                viewButton.setPreferredSize(new Dimension(75, 40));
                viewButton.setFont(new Font("Poppins", Font.BOLD, 14));
                viewButton.setFocusable(false);
                viewButton.setBorder(null);
                postContainer.add(viewButton);
                viewButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("View Button Clicked");
                        try {
                            Desktop.getDesktop().open(new java.io.File(post.getUrl()));
                        } catch (Exception ex) {
                            System.out.println("View failed: " + ex.getMessage());
                        }
                    }
                });

                // make caption
                JLabel captionLabel = new JLabel(post.getCaption());
                captionLabel.setBounds(20, 340, 350, 30);
                captionLabel.setForeground(new Color(0x252A34));
                captionLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
                postContainer.add(captionLabel);


                scrollableContainer.add(postContainer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("Action Performed: " + e.getActionCommand());
        if (e.getSource() == loginButton) {
            System.out.println("Login Button Clicked");
            openLoginPage();
        } else if (e.getSource() == uploadButton) {
            System.out.println("Upload Button Clicked");
            if(isLogin == false){
                JOptionPane.showMessageDialog(this, "You must login first");
                return;
            }

            openUploadPage();

        }
        else if(e.getSource() == refreshButton){
            System.out.println("Refresh Button Clicked");
            postList.showAllPost();

            updatePostList(postList);
        }

        else if(e.getSource() == logoutButton){
            System.out.println("Logout Button Clicked");
            isLogin = false;
            //close this page
            JOptionPane.showMessageDialog(this, "Logout Success");
            this.dispose();

        }
    }
}


