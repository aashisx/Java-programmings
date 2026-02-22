interface vehicle{
    void run();
}

interface flyable{
    void fly();
}

class plane implements vehicle, flyable{

    @Override
   public void run(){
System.out.println("can run");
    };

    @Override
    public void fly(){
        System.out.println("Can fly tooo");
     };
}

public class vehicles{

   public static void main(String[] args){

      plane a = new plane();
      a.run();
      a.fly();
      

   }
}
