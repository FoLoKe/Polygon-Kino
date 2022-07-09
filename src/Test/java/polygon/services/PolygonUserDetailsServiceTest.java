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

import java.util.List;
import java.util.Optional;

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
        String username = "TestUser";
        user.setUsername(username);
//        UserRepository userRepositoryMock = mock(UserRepository.class);
        Mockito.when(userRepository.findByUsername(username)).thenReturn(user);
        polygonUserDetailsService.loadUserByUsername(username);
        Mockito.verify(userRepository,Mockito.times(1)).findByUsername(username);
    }

    @Test
    public void getUserByUsername() {
        User user = new User();
        String username = "TestUser";
        user.setUsername(username);
//        UserRepository userRepositoryMock = mock(UserRepository.class);
        Mockito.when(userRepository.findByUsername(username)).thenReturn(user);
        User expected = polygonUserDetailsService.getUserByUsername(username);
//        Mockito.verify(userRepository,Mockito.times(1)).findByUsername(username);
        Assert.assertEquals("TestUser",expected.getUsername());
    }

    @Test
    public void saveUser() {
        User user = new User();
        polygonUserDetailsService.saveUser(user);
        Mockito.verify(userRepository,Mockito.times(1)).save(user);
        Mockito.verify(userRepository,Mockito.times(1)).flush();
    }

    @Test
    public void allUsers() {
        User user = new User();
        user.setId(1);
        List<User> users = List.of(user);
        Mockito.when(userRepository.findAll()).thenReturn(users);
        List<User> expected=polygonUserDetailsService.allUsers();
        Assert.assertNotNull(expected);
        Assert.assertEquals(1,expected.size());
    }

    @Test
    public void findById() {
        User user = new User();
        user.setId(1);
        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user));
        User expected=polygonUserDetailsService.findById(1);
        Assert.assertNotNull(expected);
    }

    @Test
    public void delete() {
        User user = new User();
        user.setId(1);
        userRepository.save(user);
        boolean expected = polygonUserDetailsService.delete(1);
        Assert.assertTrue(expected);
        Mockito.verify(userRepository,Mockito.times(1)).deleteById(1);
    }

    @Test
    public void save() {
        User user = new User();
        user.setId(1);
        polygonUserDetailsService.save(user);
        Mockito.verify(userRepository,Mockito.times(1)).saveAndFlush(user);
    }

}