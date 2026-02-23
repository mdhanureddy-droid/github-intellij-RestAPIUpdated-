package Lombok;

public class BookDemo {

    public static void main(String[] args) {
        Book book = new Book();

        book.setIsbn("978-0134685991");
        book.setAisle("A1");

        System.out.println("Book Details:");
        System.out.println("ISBN: " + book.getIsbn());
        System.out.println("Aisle: " + book.getAisle());
        System.out.println("Book Object: " + book.toString());

        Book book2 = new Book();
        book2.setIsbn("978-0321356680");
        book2.setAisle("B2");

        System.out.println("\nSecond Book:");
        System.out.println(book2);

        System.out.println("\nAre books equal? " + book.equals(book2));

        System.out.println("Book1 hashCode: " + book.hashCode());
        System.out.println("Book2 hashCode: " + book2.hashCode());
    }

}