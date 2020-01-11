package polygon.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import polygon.models.User;
import polygon.repos.RoomRepository;
import polygon.repos.UserRepository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PolygonUserDetailsServiceTest {

    @Autowired
    private PolygonUserDetailsService polygonUserDetailsService;

    @MockBean
    UserRepository userRepository;

    @Test
    public void loadUserByUsername() {
        User user = new User();
        String username = "Vitalik";
        user.setUsername(username);
//        UserRepository userRepositoryMock = mock(UserRepository.class);
        Mockito.when(userRepository.findByUsername(username)).thenReturn(user);
        polygonUserDetailsService.loadUserByUsername(username);
        Mockito.verify(userRepository,Mockito.times(1)).findByUsername(username);
    }

    @Test
    public void getUserByUsername() {
        User user = new User();
        String username = "Vitalik";
        user.setUsername(username);
//        UserRepository userRepositoryMock = mock(UserRepository.class);
        Mockito.when(userRepository.findByUsername(username)).thenReturn(user);
        User expected = polygonUserDetailsService.getUserByUsername(username);
//        Mockito.verify(userRepository,Mockito.times(1)).findByUsername(username);
        Assert.assertEquals("Vitalik",expected.getUsername());
    }

    @Test
    public void saveUser() {
        User user = new User();
        polygonUserDetailsService.saveUser(user);
        Mockito.verify(userRepository,Mockito.times(1)).save(user);
        Mockito.verify(userRepository,Mockito.times(1)).flush();
    }
}