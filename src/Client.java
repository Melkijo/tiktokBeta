import java.io.*;
import java.net.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Client {
    BufferedReader reader;
    PrintWriter writer;
    Socket sock;
    public static void main(String[] args) throws IOException {
//      System.out.println("Hello World");

        Client main = new Client();
        main.go();


        // add icon to myFrame
//        ImageIcon icon = new ImageIcon("tiktokBeta4\\src\\assets\\icon.png");
//        tiktokFrame.setIconImage(icon.getImage());

        // make myFrame in the middle of the screen
    }

    public void go() throws IOException {
        TiktokFrame tiktokFrame = new TiktokFrame(false, null);
        tiktokFrame.setLocationRelativeTo(null);

        setUpNetworking();
    }

    private void setUpNetworking (){
        try {
            sock = new Socket("localhost", 5000);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("Koneksi berhasil dibuat");
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}