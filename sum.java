public class sum {
    
    public static void main(String[] args) {
        int sum = 0;
        for(String arg : args) {
            int userinput = Integer.parseInt(arg);
            sum += userinput;
    }
        System.out.println("Sum = " + sum);
    }
}
