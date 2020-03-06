package info.vziks.skeleton.controller;

import info.vziks.skeleton.entity.User;
import info.vziks.skeleton.service.AuthenticationSystem;
import info.vziks.skeleton.service.IUserService;
import info.vziks.skeleton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Class AuthController
 * Project skeleton
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Controller
@RequestMapping("/auth")
public class AuthController {
    private IUserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationForm(User user) {
        return "registration";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm() {

        if (!AuthenticationSystem.isLogged()) return "login"; // or some logic
        return "redirect:/";

    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String regUser(
            @ModelAttribute("user") @Valid User user,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            model.addAttribute("confirmError", "Пароли не совпадают");
            return "registration";
        }

        if (!userService.addUser(user)) {
            model.addAttribute("usernameError",
                    "Пользователь с данным логином уже существует");
            return "registration";
        }
        return "redirect:/auth/login";
    }
}
