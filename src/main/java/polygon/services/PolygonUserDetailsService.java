package polygon.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.User;
import polygon.repos.UserRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class PolygonUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public PolygonUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public PolyUser loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new PolyUser(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void saveUser(User user) {
        userRepository.save(user);
        userRepository.flush();
    }

    @Transactional
    public List<User> allUsers(){
        return userRepository.findAll();
    }

    @Transactional
    public User findById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Transactional
    public boolean delete(int userId) {
        try {
            userRepository.deleteById(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void save(User user) {
        userRepository.saveAndFlush(user);
    }

    public User getUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        User user = null;

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        if(username != null && !username.isEmpty() && !(username.equals("anonymousUser"))) {
            user = getUserByUsername(username);
        }

        return user;
    }

    public static class PolyUser implements UserDetails {
        private final User user;

        public PolyUser(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
            return authorities;
        }

        @Override
        public String getPassword() {
            return user.getPassword();
        }

        @Override
        public String getUsername() {
            return user.getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
