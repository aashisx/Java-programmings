//singleton eg:

public class Ace{
   static Ace student;
  private Ace(){}

  static Ace MethodToMakeObject(){
    if(student==null){
      student=new Ace();
    }
    return student;
  }
  void study(){
    System.out.println("Method to study" );
  }

 
}