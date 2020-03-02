package info.vziks.skeleton.service;

import info.vziks.skeleton.entity.Account;

import java.util.List;

/**
 * Interface IAccountService
 * Project web-spring
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public interface IAccountService {
    List<Account> getAllAccounts();

    Account getAccountById(long accountId);

    boolean addAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(int accountId);

    Account getAccountByEmail(String email);
}
