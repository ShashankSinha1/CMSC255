package Labs.Lab11;

public class Lab11 {
    public static void main (String[] args) {
        Book book1 = new Book("Da Vinci Code", "Dan Brown");
        Book book2 = new Book("It", "Stephen King");
        Book book3 = new Book("Diary of a Wimpy Kid", "Jeff Kinney");

        System.out.println(book1.toString());
        System.out.println(book2.toString());
        System.out.println(book3.toString());

        Bookshelf bookshelf = new Bookshelf(3);

        bookshelf.addBook(book1);
        bookshelf.addBook(book2);
        bookshelf.addBook(book3);

        for (Book string: bookshelf.getBooks()){
            System.out.println(string);
        }

        bookshelf.emptyBookshelf();
        for(Book string: bookshelf.getBooks()){
            System.out.print(string);
        }
    }
}

