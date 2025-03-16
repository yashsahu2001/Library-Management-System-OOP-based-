package com.library;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. Remove a Book");
            System.out.println("3. List Books");
            System.out.println("4. Find a Book");
            System.out.println("5. Borrow a Book");
            System.out.println("6. Return a Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.println(library.addBook(new Book(title, author, isbn)));
                    break;
                case 2:
                    System.out.print("Enter ISBN to remove: ");
                    isbn = scanner.nextLine();
                    System.out.println(library.removeBook(isbn));
                    break;
                case 3:
                    System.out.println("\nLibrary Collection:");
                    System.out.println(library.listBooks());
                    break;
                case 4:
                    System.out.print("Enter ISBN to find: ");
                    isbn = scanner.nextLine();
                    System.out.println(library.findBook(isbn));
                    break;
                case 5:
                    System.out.print("Enter ISBN to borrow: ");
                    isbn = scanner.nextLine();
                    for (Book book : library.getBooks()) {  // Use getBooks() method
                        if (book.getIsbn().equals(isbn)) {
                            System.out.println(book.borrow());
                            break;
                        }
                    }
                    break;

                case 6:
                    System.out.print("Enter ISBN to return: ");
                    isbn = scanner.nextLine();
                    for (Book book : library.getBooks()) {  // Use getBooks() method
                        if (book.getIsbn().equals(isbn)) {
                            System.out.println(book.returnBook());
                            break;
                        }
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}