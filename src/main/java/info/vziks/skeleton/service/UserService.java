package info.vziks.skeleton.service;

import info.vziks.skeleton.entity.Role;
import info.vziks.skeleton.entity.User;
import info.vziks.skeleton.repository.RoleRepository;
import info.vziks.skeleton.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService implements UserDetailsService, IUserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return user;
    }

    public User getAccountById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(int accountId) {
        userRepository.delete(getAccountById(accountId));
    }

    @Override
    @Cacheable(value = "accounts-all")
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().forEach(list::add);
        return list;
    }

    @Cacheable(value = "account-single", key = "#accountId")
    @Override
    public User getUserById(int accountId) {
        return userRepository.findById(accountId).orElse(null);
    }

    @Cacheable(value = "account-single-email", key = "#email")
    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByUsername(email);
    }

    @Override
    public void updateUser(@AuthenticationPrincipal User currentUser, User account) {
        User user = userRepository.findByUsername(account.getUsername());
        if (!user.getUsername().equals(currentUser.getUsername())) {
            throw new IllegalArgumentException("You can save only your data");
        }
        user.setPassword(encoder.encode(account.getPassword()));
        userRepository.save(user);
    }

    @Override
    public boolean addUser(User account) {
        User user = userRepository.findByUsername(account.getUsername());
        if (!Objects.isNull(user)) {
            return false;
        } else {
            Role role = roleRepository.findByName("ROLE_USER");
            account.getRoles().add(role);
            account.setPassword(encoder.encode(account.getPassword()));
            role.getUsers().add(account);

            userRepository.save(account);
            return true;
        }
    }
}
