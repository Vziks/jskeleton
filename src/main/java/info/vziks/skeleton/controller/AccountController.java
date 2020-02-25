package info.vziks.skeleton.controller;

import info.vziks.skeleton.entity.Account;
import info.vziks.skeleton.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Class AccountController
 * Project web-spring
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewUser(@RequestParam String name, @RequestParam String email) {

        Account user;
        user = accountRepository.findByEmail(email);
        if (user != null) {
            return user.toString();
        }

        user = new Account();
        user.setEmail(email);
        user.setName(name);
        accountRepository.save(user);
        return user.toString();
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Account> getAllUsers() {
        return accountRepository.findAll();
    }

    @GetMapping("/map")
    public String map(Map<String, Object> model) {
        model.put("map1", 111);
        model.put("map2", 222);
        return "map";
    }
}
