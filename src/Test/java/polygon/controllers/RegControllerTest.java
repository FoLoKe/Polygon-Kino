package polygon.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import polygon.models.User;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void registrationConnection() throws Exception{
        User user = new User();
        this.mockMvc.perform(get("/registration"))
                .andDo(print())
                .andExpect(status().isOk());
//                .andExpect(model().size(3))
//                .andExpect(model().attribute("polygon.models.User@3152d449",user));
    }

    @Test
    public void showRegistrationForm() {
    }

    @Test
    public void correctLoginTest() throws Exception {
        this.mockMvc.perform(formLogin().user("user").password("user"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void registerUserAccount() {

    }
}