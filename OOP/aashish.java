public class aashish {
    public static void main(String[] args) {
        student student1 =new student("aashish",17, "Ace");
        student student2 =new student("Aashisx", 19, "Baneshwor");

        System.out.println(student1.name);
        System.out.println(student2.age);
        student1.displayinfo();
        student2.displayinfo();

    }
}
