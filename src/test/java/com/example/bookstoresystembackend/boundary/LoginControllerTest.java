package com.example.bookstoresystembackend.boundary;

import com.example.bookstoresystembackend.entity.User;
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
public class LoginControllerTest {

    @InjectMocks
    private LoginController loginController;

    @Mock
    private UserRepository userRepository;

    @Test
    public void loginSuccess() {
        User user = new User();
        user.setUsername("gica");

        when(userRepository.findUserByUsernameAndPassword("gica", "ciuperca")).thenReturn(user);

        User result = loginController.getUser("gica", "ciuperca");

        assertNotNull(result);
        assertEquals("gica", result.getUsername());
    }

    @Test
    public void loginFailed() {
        when(userRepository.findUserByUsernameAndPassword("gica", "ciuperca")).thenReturn(null);

        User result = loginController.getUser("gica", "ciuperca");

        assertNull(result);
    }

    @Test(expected = MySQLDataException.class)
    public void loginException() {
        when(userRepository.findUserByUsernameAndPassword("gica", "ciuperca")).thenThrow(MySQLDataException.class);

        User result = loginController.getUser("gica", "ciuperca");
    }
}
