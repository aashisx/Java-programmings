public class prime {
    public static void main(String[] args) {



        int num=Integer.parseInt(args[0]);
        if(num<=1){
            System.out.println(num+" is not prime");
        }else{
            for(int i=2;i<=Math.sqrt(num);i++){
                if(num%i==0){
                    System.out.println(num+" is not prime");
                    return;
                }
            }
            System.out.println(num+" is prime");
    }
}
}