class Studentt {
    int id;
    String name;

    Studentt(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("Inside parameterized constructor");
    }

    Studentt() {
        this(0, "Unknown");
        System.out.println("Inside no-argument constructor");
    }

    void display() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
    }


    public static void main(String[] args) {
        System.out.println("Creating student with no-arg constructor:");
        Studentt s1 = new Studentt();
        s1.display();

        System.out.println();

        System.out.println("Creating student with parameterized constructor:");
        Studentt s2 = new Studentt(201, "John");
        s2.display();
    
}