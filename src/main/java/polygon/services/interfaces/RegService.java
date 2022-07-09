package polygon.services.interfaces;

import polygon.models.User;

public interface RegService {
    void registerNewUserAccount(User user);
    boolean emailExists(String email);
    boolean validateEmail(String email);
    boolean userExists(String username);
}
