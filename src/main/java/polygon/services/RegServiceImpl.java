package polygon.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.User;
import polygon.repos.UserRepository;
import polygon.services.interfaces.RegService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegServiceImpl implements RegService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public RegServiceImpl(UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public void registerNewUserAccount(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setBalance(0);
        userRepository.save(user);
        userRepository.flush();
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

    public boolean validateEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
