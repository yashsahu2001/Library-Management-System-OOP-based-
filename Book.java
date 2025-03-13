package com.library;

import java.util.*;
import java.util.stream.Collectors;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private int copies;

    public Book(int bookId, String title, String author, int copies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

    public String displayInfo() {
        return "ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Copies: " + copies;
    }

    public boolean borrowBook() {
        if (copies > 0) {
            copies--;
            return true;
        }
        return false;
    }

    public void returnBook() {
        copies++;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }
}