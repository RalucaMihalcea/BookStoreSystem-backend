package com.example.bookstoresystembackend.boundary;

import com.example.bookstoresystembackend.entity.Review;
import com.example.bookstoresystembackend.entity.User;
import com.example.bookstoresystembackend.repository.ReviewRepository;
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
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserRepository userRepository;

    @Test
    public void createUserSuccessfuly() throws Exception {

        when(userRepository.findUserByUsername(eq("andra"))).thenReturn(null);
        doAnswer(returnsFirstArg()).when(userRepository).save(any(User.class));

        String resultSave = userController.addNewUserWithUsename("andra");

        assertEquals("Saved", resultSave);
        assertNotNull(resultSave);
    }

}
