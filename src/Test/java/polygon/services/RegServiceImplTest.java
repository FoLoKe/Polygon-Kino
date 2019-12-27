package polygon.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import polygon.models.User;
import polygon.repos.UserRepository;
import polygon.services.interfaces.RegService;

import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegServiceImplTest {

    @Autowired
    private RegService regService;

    @MockBean
    private UserRepository userRepository;


    @Test
    public void emailExists() {
        User user = new User();
        String email = "vit.tagunov@gmail.com";
        user.setEmail(email);
        UserRepository userRepositoryMock = mock(UserRepository.class);
        Mockito.when(userRepositoryMock.findByEmail(email)).thenReturn(user);
        boolean expected = regService.emailExists(email);
        Assert.assertFalse(expected);

    }

    @Test
    public void userExists() {
        User user = new User();
        String username = "Vitalik";
        user.setUsername(username);
        UserRepository userRepositoryMock = mock(UserRepository.class);
        Mockito.when(userRepositoryMock.findByUsername(username)).thenReturn(user);
        boolean expected = regService.userExists(username);
        Assert.assertFalse(expected);
    }

    @Test
    public void validateEmail() {
        String email = "vit.tagunov@gmail.com";
        boolean expected = regService.validateEmail(email);
        Assert.assertTrue(expected);
    }

    @Test
    public void notValidateEmail() {
        String email = "Vitalik";
        boolean expected = regService.validateEmail(email);
        Assert.assertFalse(expected);
    }
}