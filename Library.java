package com.library;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Library {
    private Map<Integer, Book> books;
    private Map<Integer, Member> members;

    public Library() {
        this.books = new HashMap<>();
        this.members = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getBookId(), book);
    }

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    public String borrowBook(int memberId, int bookId) {
        if (members.containsKey(memberId) && books.containsKey(bookId)) {
            return members.get(memberId).borrowBook(books.get(bookId));
        }
        return "Invalid member ID or book ID.";
    }

    public String returnBook(int memberId, int bookId) {
        if (members.containsKey(memberId) && books.containsKey(bookId)) {
            return members.get(memberId).returnBook(books.get(bookId));
        }
        return "Invalid member ID or book ID.";
    }

    public List<String> displayBooks() {
        return books.values().stream().map(Book::displayInfo).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter number of copies: ");
                    int copies = scanner.nextInt();
                    library.addBook(new Book(bookId, title, author, copies));
                    break;
                case 2:
                    System.out.print("Enter member ID: ");
                    int memberId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    library.addMember(new Member(memberId, name));
                    break;
                case 3:
                    System.out.print("Enter member ID: ");
                    int memId = scanner.nextInt();
                    System.out.print("Enter book ID: ");
                    int bkId = scanner.nextInt();
                    System.out.println(library.borrowBook(memId, bkId));
                    break;
                case 4:
                    System.out.print("Enter member ID: ");
                    int memIdR = scanner.nextInt();
                    System.out.print("Enter book ID: ");
                    int bkIdR = scanner.nextInt();
                    System.out.println(library.returnBook(memIdR, bkIdR));
                    break;
                case 5:
                    System.out.println("Available Books: ");
                    library.displayBooks().forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}