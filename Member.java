package com.library;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private int memberId;
    private String name;
    private List<Integer> borrowedBooks;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String borrowBook(Book book) {
        if (book.borrowBook()) {
            borrowedBooks.add(book.getBookId());
            return name + " borrowed " + book.getTitle();
        }
        return "Book is not available.";
    }

    public String returnBook(Book book) {
        if (borrowedBooks.contains(book.getBookId())) {
            book.returnBook();
            borrowedBooks.remove(Integer.valueOf(book.getBookId()));
            return name + " returned " + book.getTitle();
        }
        return "This book was not borrowed.";
    }

    public int getMemberId() {
        return memberId;
    }
}