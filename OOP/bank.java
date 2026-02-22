public class bank {
    private int balance=5000 ;
     void withdraw(int amount){
        if(balance<amount){
            System.out.println("Insufficient amount");
        }else{
            balance-=amount;
            System.out.println("Your new balance is: "+ balance);
        }
      }
    void deposit(int amount){
        balance+=amount;
        System.out.println("Your new balance is: "+balance);
    }
    
}
