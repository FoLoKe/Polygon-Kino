package polygon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    private final Environment environment;

    public MailConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", environment.getProperty("MAIL_PROTOCOL"));
        props.put("mail.smtp.auth", environment.getProperty("MAIL_SMTP_AUTH"));
        props.put("mail.smtp.starttls.enable", environment.getProperty("MAIL_START_TLS"));
        props.put("mail.debug", environment.getProperty("MAIL_DEBUG"));

        mailSender.setJavaMailProperties(props);
        mailSender.setHost(environment.getRequiredProperty("MAIL_HOST"));
        mailSender.setPort(Integer.parseInt(environment.getRequiredProperty("MAIL_PORT")));
        mailSender.setUsername(environment.getProperty("MAIL_USERNAME"));
        mailSender.setPassword(environment.getProperty("MAIL_PASSWORD"));

        return mailSender;
    }
}
