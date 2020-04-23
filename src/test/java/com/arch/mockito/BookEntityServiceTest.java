package com.arch.mockito;

import com.arch.BookEntity;
import com.arch.BookDto;
import com.arch.BookRepository;
import com.arch.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookEntityServiceTest {

    @Mock
    BookRepository bookRepository;

    BookService service;

    @BeforeEach
    void setUp() {
        service = new BookService(bookRepository);
    }

    @Test
    void create_ShouldReturnTrue_WhenBookIsExist() {
        // arrange
        BookDto bookDto = new BookDto("Sapiens", "Yuval Hariri");

        when(bookRepository.isExist(bookDto.getName())).thenReturn(true);

        // act
        boolean result = service.create(bookDto);

        // assertion
        assertTrue(result);
    }

    @Test
    void create_ShouldReturnTrue_WhenBookIsNotExist() {
        // arrange
        BookDto bookDto = new BookDto("Sapiens", "Yuval Hariri");

        when(bookRepository.isExist(bookDto.getName())).thenReturn(false);
        when(bookRepository.save(any())).thenReturn(true);

        // act
        boolean result = service.create(bookDto);

        // assertion
        assertTrue(result);

        ArgumentCaptor<BookEntity> argumentCaptor = ArgumentCaptor.forClass(BookEntity.class);
        verify(bookRepository).save(argumentCaptor.capture());

        BookEntity bookEntity = argumentCaptor.getValue();

        Assertions.assertEquals(bookDto.getName(), bookEntity.getName());
        Assertions.assertEquals(bookDto.getAuthor(), bookEntity.getAuthor());
    }
}
