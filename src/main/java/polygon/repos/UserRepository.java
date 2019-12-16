package polygon.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import polygon.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findByUsername(String username);
}
