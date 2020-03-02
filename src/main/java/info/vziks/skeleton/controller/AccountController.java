package info.vziks.skeleton.controller;

import info.vziks.skeleton.entity.Account;
import info.vziks.skeleton.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Objects;

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
    private IAccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") Integer id) {
        Account account = accountService.getAccountById(id);
        if (!Objects.isNull(account)) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "/add2")
    public ResponseEntity<Void> addNewUser(@RequestParam String name, @RequestParam String email, UriComponentsBuilder builder) {
        Account user;
        user = new Account();
        user.setEmail(email);
        user.setName(name);

        return getVoidResponseEntity(builder, user);
    }

    private ResponseEntity<Void> getVoidResponseEntity(UriComponentsBuilder builder, Account user) {
        boolean flag = accountService.addAccount(user);
        if (!flag) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/account/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> list = accountService.getAllAccounts();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addAccount(@RequestBody Account account, UriComponentsBuilder builder) {
        return getVoidResponseEntity(builder, account);
    }

    @PutMapping("/put")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
        accountService.updateAccount(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("id") Integer id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
