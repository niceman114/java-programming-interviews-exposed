package com.wiley.javainterviewsexposed.chapter06.builder;

import java.util.Date;

enum BookType {
    FICTION,
    NON_FICTION
}

public class LibraryBook {
    public static class Builder {
        private BookType bookType = BookType.FICTION;
        private String bookName;

        public Builder withBookType(final BookType bookType) {
            this.bookType = bookType;
            return this;
        }

        public Builder withBookName(final String bookName) {
            this.bookName = bookName;
            return this;
        }

        public LibraryBook build() {
            return new LibraryBook(bookType, bookName);

        }
    }

    private final BookType bookType;
    private final String bookName;

    public LibraryBook(final BookType bookType, final String bookName) {
        this.bookType = bookType;
        this.bookName = bookName;
    }

    public BookType getBookType() {
        return bookType;
    }

    public String getBookName() {
        return bookName;
    }
}
