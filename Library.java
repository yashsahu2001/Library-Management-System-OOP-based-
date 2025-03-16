package com.library;

import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public String addBook(Book book) {
        books.add(book);
        return "Book \"" + book.toString() + "\" added to the library.";
    }

    public String removeBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                return "Book with ISBN " + isbn + " removed from the library.";
            }
        }
        return "Book not found.";
    }

    public String listBooks() {
        if (books.isEmpty()) {
            return "No books available in the library.";
        }
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book.toString()).append("\n");
        }
        return sb.toString();
    }

    public String findBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book.toString();
            }
        }
        return "Book not found.";
    }

    // Add this getter method
    public List<Book> getBooks() {
        return books;
    }
}