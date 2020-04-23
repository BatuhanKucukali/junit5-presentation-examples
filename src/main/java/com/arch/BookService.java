package com.arch;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public boolean create(BookDto bookDto) {
        if (bookRepository.isExist(bookDto.getName())) {
            return true;
        }

        BookEntity book = new BookEntity(bookDto.getName(), bookDto.getName()); // O oo

        return bookRepository.save(book);
    }
}
