import java.io.*;
import java.net.*;

public class Client {
    BufferedReader reader;
    PrintWriter writer;
    Socket sock;
    public static void main(String[] args) throws IOException {

        Client main = new Client();
        main.go();

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