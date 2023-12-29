import com.opencsv.CSVWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Upload extends JFrame implements ActionListener {
    private JButton uploadButton;

    private JTextField urlField;

    private JTextField captionField;

    private JButton localFileButton;

    private JProgressBar progressBar;

private PostList postList;

private LoginData loginData;

private String downloadFilePath;

private String tempFilePath;


    public Upload(PostList postList, LoginData loginData){


        super("Upload");
        this.postList = postList;
        this.loginData = loginData;
        for(Post post : postList.getPosts()){
            System.out.println(post.getCaption());
            System.out.println(post.getUrl());
            System.out.println(post.getUsername());
        }
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 500);
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

        JLabel captionLabel = new JLabel("Caption");
        captionLabel.setBounds(20, 220, 100, 30);
        captionLabel.setForeground(new Color(0xFFFFFF));
        captionLabel.setFont(new Font("Poppins", Font.PLAIN, 18));
        this.add(captionLabel);

        captionField = new JTextField();
        captionField.setBounds(20, 250, 330, 50);
        this.add(captionField);

        uploadButton = new JButton("Upload");
        uploadButton.setBounds(20, 320, 330, 40);
        uploadButton.setBackground(new Color(0xFF2E63));
        uploadButton.setForeground(new Color(0xFFFFFF));
        uploadButton.setPreferredSize(new Dimension(230, 40));
        uploadButton.setFont(new Font("Poppins", Font.BOLD, 14));
        uploadButton.setFocusable(false);
        uploadButton.setBorder(null);
        uploadButton.addActionListener(this);
        this.add(uploadButton);
    }

    public String downloadFile(String url) {
        InputStream in = null;
        FileOutputStream fOut = null;
        String fileName = null;

        try {
            URL remoteFile = new URL(url);
            URLConnection fileStream = remoteFile.openConnection();

            String paths = remoteFile.getPath();
            String[] path = paths.split("/");
            fileName = path[path.length-1];

            fOut = new FileOutputStream(fileName);
            in = fileStream.getInputStream();

            int data;
            long totalSize = fileStream.getContentLengthLong(); // Get the total file size

            long downloadedSize = 0;

            while ((data = in.read()) != -1) {
                fOut.write(data);
                downloadedSize++;

                int percentage = (int) ((downloadedSize * 100) / totalSize);
                progressBar.setValue(percentage);
            }

//            String filePath = System.getProperty("user.dir") + "\\" + fileName;
//            System.out.println("File downloaded to: " + filePath);

            // Get the user directory
            String userDir = System.getProperty("user.dir");

            // Construct the full path to save the file
            String filePath = userDir + File.separator + fileName;

            String convertedPath = filePath.replace('\\', '/');
            this.downloadFilePath = convertedPath;

            System.out.println("File downloaded to: " + filePath);
            System.out.println("File downloaded to: " + convertedPath);

//            fOut = new FileOutputStream(filePath);

            //add post to postList



        } catch (Exception ex) {
            System.out.println("Download failed: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "URLnya salah bre");
            return null;
        } finally {
            System.out.println("File telah berhasil didownload broh");
            try {
                assert in != null;
                in.close();
                fOut.flush();
                fOut.close();
            } catch (Exception e) {
                System.out.println("Download failed: " + e.getMessage());
            }
        }

        return fileName;
    }

    public void writeDataLineByLine(String caption, String url, String username)
    {
        // first create file object for file placed at location
        // specified by filepath
        File file = new File("D:/Dunia Perkuliahan/Semester 7/regular/prognet/tubes/tiktokBeta4/posts.csv");
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file, true);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv
//            String[] header = { "Caption", "Url", "Username" };
//            writer.writeNext(header);

//             add data to csv
//            String[] data1 = { "Panic abstract", "D:/Dunia Perkuliahan/Semester 7/regular/prognet/tubes/tiktokBeta4/src/images/4706201.jpg", "John Doe" };
//            writer.writeNext(data1);
//            String[] data2 = { "caption2", "D:/Dunia Perkuliahan/Semester 7/regular/prognet/tubes/tiktokBeta4/src/images/5171295.jpg", "username2" };
//            writer.writeNext(data2);
//            String[] data3 = { "caption3", "D:/Dunia Perkuliahan/Semester 7/regular/prognet/tubes/tiktokBeta4/src/images/5242220.jpg", "username3" };
//            writer.writeNext(data3);

            String[] data = { caption, url, username };
            writer.writeNext(data);

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action Performed: " + e.getActionCommand());

        if(e.getSource() == uploadButton){
            System.out.println("Upload Button Clicked");
            postList.showAllPost();
            String url =  urlField.getText();
            if(tempFilePath != null){
                Post post = new Post( captionField.getText(),tempFilePath, loginData.getName());
                postList.addPost(post);
                postList.showAllPost();
                writeDataLineByLine( captionField.getText(),tempFilePath, loginData.getName());

                JOptionPane.showMessageDialog(null, "File Berhasil di upload" + tempFilePath);
                return;
            }
            if(url.isEmpty()){
                JOptionPane.showMessageDialog(null, "URL tidak boleh kosong");
                return;
            }
            // Create and configure a progress bar
            progressBar = new JProgressBar(0, 100);
            progressBar.setStringPainted(true); // Display a percentage
            progressBar.setIndeterminate(true); // Use an indeterminate progress bar
            //hide progressBar

            // Create a dialog to show the progress bar
            JDialog progressDialog = new JDialog(this, "Downloading File", true);
            progressDialog.add(progressBar);
            progressDialog.pack();
            progressDialog.setLocationRelativeTo(this);

            // Start a new thread to perform the download
            Thread downloadThread = new Thread(() -> {
                try {
                    // Perform the download (replace with your actual download logic)
                    String fileName = downloadFile(url);

                    // Close the progress dialog when the download is complete
                    progressDialog.dispose();

                    // check if filename dont have extension
                    if(!fileName.contains(".")){
                        JOptionPane.showMessageDialog(null, "Download failed: " + "File tidak memiliki ekstensi", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if(fileName == null){
                        JOptionPane.showMessageDialog(null, "Download failed: " + "File tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    // check if filename already exist in downloadFileName
//                    if(downloadFileName.contains(fileName)){
//                        JOptionPane.showMessageDialog(null, "Download failed: " + "File sudah pernah didownload broh", "Error", JOptionPane.ERROR_MESSAGE);
//                        return;
//                    }
//                    downloadFileName.add(fileName);

                    // Show a success message
                    JOptionPane.showMessageDialog(null, "File telah berhasil didownload " + fileName);

                    // Get the user directory
                    String userDir = System.getProperty("user.dir");

                    // Construct the full path to save the file
                    String filePath = userDir + File.separator + fileName;

                    String convertedPath = filePath.replace('\\', '/');

                    Post post = new Post( captionField.getText(),convertedPath, loginData.getName());
                    Post post1 = new Post( captionField.getText(),filePath, loginData.getName());
                    postList.addPost(post);
//                    postList.addPost(post1);
                    writeDataLineByLine( captionField.getText(),convertedPath, loginData.getName());


                    postList.showAllPost();


                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    // Handle any exceptions here
                    progressDialog.dispose();
                    JOptionPane.showMessageDialog(null, "Download failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            // Start the download thread
            downloadThread.start();





            // Show the progress dialog
            progressDialog.setVisible(true);
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
                this.tempFilePath = file.getAbsolutePath();
                //add post to postList


            }
            else{
                System.out.println("File is not image");
            }


        }

    }
}
