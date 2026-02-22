class Student {
   
    private String name;
    private int marks;


    public String getName() {
        return name;
    }

 
    public void setName(String name) {
        this.name = name;
    }

    // Getter for marks
    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
public class assgn7{
    public static void main(String[] args) {
        Student s = new Student();

    
        s.setName("Ravi");
        s.setMarks(85);

        System.out.println("Student Name: " + s.getName());
        System.out.println("Student Marks: " + s.getMarks());
    }
}

