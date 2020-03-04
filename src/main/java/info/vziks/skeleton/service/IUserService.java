package info.vziks.skeleton.service;

import info.vziks.skeleton.entity.User;

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

    void updateUser(User account);

    User getUserByEmail(String email);
}
