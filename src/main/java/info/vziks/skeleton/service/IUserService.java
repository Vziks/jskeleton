package info.vziks.skeleton.service;

import info.vziks.skeleton.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.List;

/**
 * Interface IUserService
 * Project skeleton
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public interface IUserService {
    void deleteUser(int accountId);

    List<User> getAllUsers();

    User getUserById(int accountId);

    boolean addUser(User account);

    void updateUser(@AuthenticationPrincipal User currentUser, User account);

    User getUserByEmail(String email);
}
