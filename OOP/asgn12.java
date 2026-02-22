interface Readable {
    void read();
}

interface Writable {
    void write();
}

class Book implements Readable, Writable {
    public void read() {
        System.out.println("Reading the book");
    }

    public void write() {
        System.out.println("Writing in the book");
    }
}

public class asgn12 {
    public static void main(String[] args) {
        Book b = new Book();
        b.read();
        b.write();
    }
}
