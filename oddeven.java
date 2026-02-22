public class oddeven {
    public static void main(String[] args) {        
        int userinput = Integer.parseInt(args[0]);
        if (userinput % 2 == 0) {
            System.out.println(userinput + " is Even number");
        } else {
            System.out.println(userinput + " is Odd number");
        }
        
    }
}
