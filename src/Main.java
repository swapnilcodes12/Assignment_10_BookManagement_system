import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = BookManagement.getBooksFromFile("/home/swapnil/c/new/xyz/bitcode_new.txt");
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("Book Management System Menu");
            System.out.println("1. Add a book");
            System.out.println("2. Display all books");
            System.out.println("3. Search for a book");
            System.out.println("4. Delete a book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book price: ");
                    int price = scanner.nextInt();
                    scanner.nextLine();

                    Book newBook = new Book(title, author, price);
                    BookManagement.addBook(books, newBook);
                    break;
                case 2:
                    BookManagement.displayAllBooks(books);
                    break;
                case 3:
                    System.out.print("Enter search query: ");
                    String searchQuery = scanner.nextLine();
                    BookManagement.searchForBook(books, searchQuery);
                    break;
                case 4:
                    System.out.print("Enter the index of the book to delete: ");
                    int index = scanner.nextInt();
                    BookManagement.deleteBook(books, index);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        BookManagement.saveBooksToFile(books, "/home/swapnil/c/new/xyz/bitcode_new.txt");
    }
    }

