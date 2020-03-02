package info.vziks.skeleton.service;

import info.vziks.skeleton.entity.Account;
import info.vziks.skeleton.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Class AccountService
 * Project web-spring
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    @Cacheable(value = "accounts-add")
    public List<Account> getAllAccounts() {
        List<Account> list = new ArrayList<>();
        accountRepository.findAll().forEach(list::add);
        return list;
    }


    @Cacheable(value = "account-single", key = "#accountId")
    @Override
    public Account getAccountById(long accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }

    @Cacheable(value = "account-single-email", key = "#email")
    @Override
    public Account getAccountByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public boolean addAccount(Account account) {
        List<Account> list = accountRepository.findByNameAndEmail(account.getName(), account.getEmail());
        if (list.size() > 0) {
            return false;
        } else {
            accountRepository.save(account);
            return true;
        }
    }

    @Override
    public void updateAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void deleteAccount(int accountId) {
        accountRepository.delete(getAccountById(accountId));
    }
}
