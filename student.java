public class student {
    static String name ;
    String phnum;
    int age;
    String address;
    student(String name, int age, String add){
     this.name=name;
     this.age=age;
     this.address=add;
    }
    void displayinfo(){
        System.out.println("The name of student is: " + this.name);
        System.out.println("The age of student is: "+ this.age);
        System.out.println("The address of student is: "+ this.address);


    }
}
