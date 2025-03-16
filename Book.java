package com.library;

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
    }

    public String borrow() {
        if (!isBorrowed) {
            isBorrowed = true;
            return "\"" + title + "\" has been borrowed.";
        }
        return "\"" + title + "\" is already borrowed.";
    }

    public String returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            return "\"" + title + "\" has been returned.";
        }
        return "\"" + title + "\" was not borrowed.";
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        String status = isBorrowed ? "Borrowed" : "Available";
        return "Book: " + title + " | Author: " + author + " | ISBN: " + isbn + " | Status: " + status;
    }
}