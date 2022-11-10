package Labs.Lab11;

import java.util.ArrayList;

public class Bookshelf {
    private int size;
    private ArrayList<Book> books;

    /**************************************************************************************
     * This is the default constructor for the class which initializes the ArrayList and
     * sets the value of the size to 2
     **************************************************************************************/

    public Bookshelf() {
        size = 2;
        books = new ArrayList<Book>();
    }

    /**************************************************************************************
     * This constructor takes a value for size and sets the instance variable to the one
     * provides and initializes ArrayList
     **************************************************************************************/

    public Bookshelf(int size){
        this.size = size;
        books = new ArrayList<Book>(size);
    }

    /**************************************************************************************
     * This method returns the value of the instance variable size after it runs through
     * either of the constructors
     **************************************************************************************/

    public int getSize(){
        return this.size;
    }

    /**************************************************************************************
     * This method returns the ArrayList for the instance variable books after it runs
     * through either of the constructors
     **************************************************************************************/

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    /************************************************************************************
     * This method checks whether the size of the ArrayList is equal the size of
     * the shelf. If it returns true, then it returns nothing because the shelf is
     * full based on the values of sizes. If the sizes are not equal, then it'll add
     * a book, based on the given parameter newBook, to the next index of ArrayList books
     ************************************************************************************/

    public String addBook(Book newBook){
        if (books.size() == size){
            System.out.println("There is no room on the shelf");
        }
        else{
            books.add(newBook);
        }
        return null;
    }

    /**************************************************************************************
     * This method removes the first book on the bookshelf and returns it but only if the
     * ArrayList books has no empty values. If it is empty, then it will return null
     **************************************************************************************/

    public Book removeBook(){
        if(!books.isEmpty()){
            return books.remove(0);
        }
        return null;
    }

    /*********************************************************************************************
     * This method empties all the values within the ArrayList books and sets each value to null
     *********************************************************************************************/

    public void emptyBookshelf(){
        books.clear();
    }


}
