package info.vziks.skeleton.repository;

import info.vziks.skeleton.entity.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface AccountRepository
 * Project web-spring
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByName(String username);
    Account findByEmail(String email);
}