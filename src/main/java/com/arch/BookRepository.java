package com.arch;

public interface BookRepository {
    boolean isExist(String name);

    boolean save(BookEntity book);
}
