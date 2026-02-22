public class reversestring {
    public static void main(String[] args) {
        String str = args[0];
        String reversedStr = new StringBuilder(str).reverse().toString();
        System.out.println("Reversed string: " + reversedStr);
    }
}
