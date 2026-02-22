class Students {
    int id;
    String name;

    Students(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
    }
}
public class TestStudent {
    public static void main(String[] args) {
        Students s1 = new Students(101, "Aashish");
        s1.display();

        System.out.println();

        Students s2 = new Students(102, "Nikka");
        s2.display();
    }
}
