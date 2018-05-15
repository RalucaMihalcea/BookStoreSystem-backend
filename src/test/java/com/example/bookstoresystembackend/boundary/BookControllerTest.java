package com.example.bookstoresystembackend.boundary;

import com.example.bookstoresystembackend.entity.Book;
import com.example.bookstoresystembackend.entity.User;
import com.example.bookstoresystembackend.repository.BookRepository;
import com.example.bookstoresystembackend.repository.UserRepository;
import com.mysql.jdbc.exceptions.MySQLDataException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void searchBookSuccess() {
        Book book = new Book();
        book.setId((long) 10);
        book.setTitle("The Alchemist");

        when(bookRepository.findBookById((long) 10))
                .thenReturn(book);

        Book result = bookController.getBook((long) 10);

        assertNotNull(result);
        assertEquals(((long) 10), (long) result.getId());
    }

    @Test
    public void searchBookFailed() {
        when(bookRepository.findBookById((long) 10))
                .thenReturn(null);

        Book result = bookController.getBook((long) 10);

        assertNull(result);
    }

    @Test(expected = MySQLDataException.class)
    public void searchBookException() {
        when(bookRepository.findBookById((long) 10))
                .thenThrow(MySQLDataException.class);

        Book result = bookController.getBook((long) 10);
    }

}
