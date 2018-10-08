public class Book implements Cloneable {
    String bookName;
    double price;
    Person author;


    public Book(String bn, double price, Person author) {
        bookName = bn;
        this.price = price;
        this.author = author;
    }

    public Object clone() {
        Book b = null;
        try {
            b = (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return b;
    }

    public static void main(String args[]) {
        Person p = new Person("Dream", 34);
        Book book1 = new Book("Java开发", 30.00, p);
        Book book2 = (Book) book1.clone();
        book2.price = 44.00;
        book2.author.age = 45;
        book2.author.name = "Fish";
        book2.bookName = "Android开发";
        System.out.print("age = " + book1.author.age + "  name = "
                + book1.bookName + "     price = " + book1.price);
        System.out.println();
        System.out.print("age = " + book2.author.age + "  name = "
                + book2.bookName + "     price = " + book2.price);

        System.out.println(book1 == book2);
    }

}

class Person {
    int age = 0;
    String name = "";

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

}