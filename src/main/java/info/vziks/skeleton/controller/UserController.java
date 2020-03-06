package info.vziks.skeleton.controller;

import info.vziks.skeleton.entity.User;
import info.vziks.skeleton.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * Class UserController
 * Project skeleton
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String currentUser(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);

        return "profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String saveUser(
            @AuthenticationPrincipal User currentUser,
            @ModelAttribute("user") @Valid User user,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "profile";
        }

        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            model.addAttribute("confirmError", "Пароли не совпадают");
            return "profile";
        }

        userService.updateUser(currentUser, user);
        return "redirect:/user/profile";
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getAccountById(@PathVariable("id") Integer id) {
        User account = userService.getUserById(id);
        if (!Objects.isNull(account)) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<Void> getVoidResponseEntity(UriComponentsBuilder builder, User user) {
        boolean flag = userService.addUser(user);
        if (!flag) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/account/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllAccounts() {
        List<User> list = userService.getAllUsers();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addAccount(@RequestBody User account, UriComponentsBuilder builder) {
        return getVoidResponseEntity(builder, account);
    }

    @PutMapping("/put")
    public ResponseEntity<User> updateAccount(@AuthenticationPrincipal User currentUser, @RequestBody User account) {
        userService.updateUser(currentUser, account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
