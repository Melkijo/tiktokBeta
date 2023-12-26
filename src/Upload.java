import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;

public class Upload extends JFrame implements ActionListener {
    private JButton uploadButton;

    private JTextField urlField;

    private JButton localFileButton;
//    private JFileChooser fileChooser;
    public Upload(){
        super("Upload");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.getContentPane().setBackground(new Color(0x252A34));

        JLabel label = new JLabel("UPLOAD");
        label.setForeground(new Color(0xFFFFFF));
        label.setFont(new Font("Poppins", Font.BOLD, 28));
        label.setBounds(120, 20, 200, 30);
        this.add(label);


        JLabel uploadLabel = new JLabel("Using Url");
        uploadLabel.setBounds(20, 70, 100, 30);
        uploadLabel.setForeground(new Color(0xFFFFFF));
        uploadLabel.setFont(new Font("Poppins", Font.PLAIN, 18));
        this.add(uploadLabel);

        urlField = new JTextField();
        urlField.setBounds(150, 70, 200, 30);
        this.add(urlField);

        // make text label "or"
        JLabel orLabel = new JLabel("or");
        orLabel.setBounds(190, 120, 100, 30);
        orLabel.setForeground(new Color(0xFFFFFF));
        orLabel.setFont(new Font("Poppins", Font.PLAIN, 18));
        this.add(orLabel);

        //make local file button
        localFileButton = new JButton("Choose File");
        localFileButton.setBounds(20, 170, 330, 40);
        localFileButton.setBackground(new Color(0xFFFFFF));
        localFileButton.setForeground(new Color(0x252A34));
        localFileButton.setPreferredSize(new Dimension(230, 40));
        localFileButton.setFont(new Font("Poppins", Font.BOLD, 14));
        localFileButton.setFocusable(false);
        localFileButton.setBorder(null);
        localFileButton.addActionListener(this);
        localFileButton.setBorder(BorderFactory.createLineBorder(new Color(0xFF2E63), 2));
        this.add(localFileButton);

        uploadButton = new JButton("Upload");
        uploadButton.setBounds(20, 250, 330, 40);
        uploadButton.setBackground(new Color(0xFF2E63));
        uploadButton.setForeground(new Color(0xFFFFFF));
        uploadButton.setPreferredSize(new Dimension(230, 40));
        uploadButton.setFont(new Font("Poppins", Font.BOLD, 14));
        uploadButton.setFocusable(false);
        uploadButton.setBorder(null);
        uploadButton.addActionListener(this);
        this.add(uploadButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action Performed: " + e.getActionCommand());

        if(e.getSource() == uploadButton){
            JOptionPane.showMessageDialog(this, "File Uploaded");
        }
        else if( e.getSource() == localFileButton){
            System.out.println("Choose File");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new java.io.File("."));
            fileChooser.setDialogTitle("Choose File");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.setBounds(20, 170, 330, 40);
            fileChooser.showOpenDialog(this);
            File file = fileChooser.getSelectedFile();
            System.out.println(file);

            // check if the file format is image
            String fileName = file.getName();
            String extension = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
            System.out.println(extension);
            if(extension.equals("jpg") || extension.equals("png") || extension.equals("jpeg")){
                System.out.println("File is image");
                JOptionPane.showMessageDialog(this, "File Uploaded" + file);

            }
            else{
                System.out.println("File is not image");
            }


        }

    }
}
