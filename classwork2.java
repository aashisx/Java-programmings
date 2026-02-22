import java.io.*;

public class classwork2 {
    public static void main(String[] args) {
        try {
            FileReader r = new FileReader("test.txt");
            BufferedReader b = new BufferedReader(r);
            String data;
            while ((data = b.readLine()) != null) {
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println("Error " + e.getMessage() );
        }
    }
}