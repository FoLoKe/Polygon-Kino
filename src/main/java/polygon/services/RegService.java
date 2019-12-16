package polygon.services;

import polygon.models.User;

public interface RegService {
    User registerNewUserAccount(User user);
    boolean emailExists(String email);
    boolean validateEmail(String email);
    boolean userExists(String username);
}
