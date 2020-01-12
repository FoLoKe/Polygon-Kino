package polygon.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class EmailServiceImplTest {

    @Autowired
    public EmailServiceImpl emailService;

    @MockBean
    public JavaMailSender emailSender;

    @Test
    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        String to = "df";
        String subject = "s";
        String text = "text";
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailService.sendSimpleMessage(to,subject,text);
        Mockito.verify(emailSender,Mockito.times(1)).send(message);
    }
}