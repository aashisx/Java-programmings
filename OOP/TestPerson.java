class Person {
    Person(String name) {
        System.out.println("Person name: " + name);
    }
}

class Student extends Person {
    Student(String name) {
        super(name);
        System.out.println("Student name: " + name);
    }
}

public class TestPerson {
    public static void main(String[] args) {
        Student s = new Student("Nikka");
    }
}

