import java.io.*;
import java.util.ArrayList;

public class BookManagement {
    public static void addBook(ArrayList<Book> books, Book newBook) {

        books.add(newBook);
        saveBooksToFile(books,"/home/swapnil/c/new/xyz/bitcode_new.txt");
        System.out.println("Book added successfully.");
    }

    public static void displayAllBooks(ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("All Books:");
            for (int i = 0; i < books.size(); i++) {
                System.out.println("Book " + (i + 1) + ":\n" + books.get(i));
            }
        }
    }

    public static void searchForBook(ArrayList<Book> books, String searchBook) {
        if (books.isEmpty()) {
            System.out.println("No books available to search.");
        } else {
            searchBook = searchBook;
            boolean found = false;

            System.out.println("Search Books:");
            for (Book book : books) {
                if (book.getTitle().contains(searchBook) || book.getAuthor().contains(searchBook)) {
                    System.out.println(book);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No matching books found.");
            }
        }
    }

    public static void deleteBook(ArrayList<Book> books, int index) {
        if (index >= 0 ) {
            books.remove(index);
            saveBooksToFile(books,"/home/swapnil/c/new/xyz/bitcode_new.txt");
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Enter index is not matched.");
        }
    }

    static void saveBooksToFile(ArrayList<Book> books, String filePath) {
        try (FileOutputStream fileOut = new FileOutputStream(filePath,false);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(books);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static ArrayList<Book> getBooksFromFile(String filePath) {
        ArrayList<Book> books = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            books = (ArrayList<Book>) objectIn.readObject();
        } catch (FileNotFoundException e) {
            saveBooksToFile(new ArrayList<>(), filePath);
        } catch (IOException | ClassNotFoundException e) {
        }
        return books;
    }

}


