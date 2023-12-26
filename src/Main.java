import javax.swing.*;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
//      System.out.println("Hello World");
        TiktokFrame tiktokFrame = new TiktokFrame();

        // add icon to myFrame
        ImageIcon icon = new ImageIcon("tiktokBeta4\\src\\assets\\icon.png");
        tiktokFrame.setIconImage(icon.getImage());

        // make myFrame in the middle of the screen
        tiktokFrame.setLocationRelativeTo(null);
    }
}