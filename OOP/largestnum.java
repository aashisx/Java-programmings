public class largestnum {
    public static void main(String[] args) {
        int largest = Integer.MIN_VALUE; 
        for (String arg : args) {
            int userinput = Integer.parseInt(arg);
            if (userinput > largest) {
                largest = userinput;
            }
        }
        System.out.println("Largest number = " + largest);
}
}