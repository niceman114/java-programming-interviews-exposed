package com.wiley.javainterviewsexposed.chapter08;

public final class BookRecord {

    private String author;
    private String bookTitle;

    public BookRecord(String author, String bookTitle) {
        this.author = author;
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookTitle() {
        return bookTitle;
    }


}