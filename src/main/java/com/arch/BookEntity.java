package com.arch;

public class BookEntity {
    private Long id;
    private String name;
    private String author;

    public BookEntity(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}
