import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class filereader {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("aashisx.txt");
            FileOutputStream fout = new FileOutputStream("copied.txt");
            FileInputStream img = new FileInputStream("photo.png");
            FileOutputStream imgout = new FileOutputStream("copied.jpg");
            int data;
            while ((data = fin.read()) != -1) {
                fout.write(data);
            }
            while ((data = img.read()) != -1) {
                imgout.write(data);
            }
            fin.close();
            fout.close();
            System.out.println("File copied successfully.");
    
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
    