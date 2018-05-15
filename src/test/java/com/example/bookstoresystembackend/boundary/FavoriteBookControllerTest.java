package com.example.bookstoresystembackend.boundary;

import com.example.bookstoresystembackend.entity.FavoriteBook;
import com.example.bookstoresystembackend.entity.User;
import com.example.bookstoresystembackend.repository.FavoriteBookRepository;
import com.example.bookstoresystembackend.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FavoriteBookControllerTest {

    @InjectMocks
    private FavoriteBookController favoriteBookController;

    @Mock
    private FavoriteBookRepository favoriteBookRepository;
    private UserRepository userRepository;
   // ArrayList<FavoriteBook> mockedList= new List<FavoriteBook>();

    @Test
    public void createFavoriteBookSuccess() {

        when(favoriteBookRepository.findFavoriteBooksByIdBookAndIdUser(eq((long)10), eq((long)2))).thenReturn(null);
        doAnswer(returnsFirstArg()).when(favoriteBookRepository).save(any(FavoriteBook.class));

        FavoriteBook favoriteBook=new FavoriteBook();
        favoriteBook.setIdUser((long)2);
        favoriteBook.setIdBook((long)10);

        String resultSave = favoriteBookController.addNewFavoriteBook(favoriteBook);

        assertEquals("Favorite Book Saved", resultSave);
        assertNotNull(resultSave);
    }

    @Test
    public void deleteFavoriteBookSuccess() throws Exception  {

        FavoriteBook favoriteBook=new FavoriteBook();
        favoriteBook.setIdUser((long)5);
        favoriteBook.setIdBook((long)10);

        doNothing().when(favoriteBookRepository).delete(favoriteBook);
        FavoriteBookRepository my = Mockito.mock(FavoriteBookRepository.class);
        // Act
        String resultDelete= favoriteBookController.deleteNewFavoriteBookUnitTest((long)5, (long)10);
        // Assert
        assertEquals("Favorite Book Deleted", resultDelete);
        assertNotNull(resultDelete);
    }


}
