public class Ashis {
    public static void main(String[] args) {

        String name= null;
        try {
            System.out.println("Name: " + name);
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception: " + e.getMessage());
        }
        System.out.println("Name in lowercase: " + name.toLowerCase());

        
    }
}
    	