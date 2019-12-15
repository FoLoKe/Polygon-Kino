package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.User;
import polygon.repos.UserRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegServiceImpl implements RegService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    @Override
    public User registerNewUserAccount(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setBalance(0);
        return userRepository.save(user);
    }

    @Override
    public boolean emailExists(String email) {
        User user = userRepository.findByEmail(email);
        return user != null;
    }

    @Override
    public boolean userExists(String username) {
        User user = userRepository.findByUsername(username);
        return user != null;
    }

    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";

    public boolean validateEmail(String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
