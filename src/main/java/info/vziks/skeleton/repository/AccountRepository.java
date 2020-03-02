package info.vziks.skeleton.repository;

import info.vziks.skeleton.entity.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Interface AccountRepository
 * Project web-spring
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findByName(String username);

    Account findByEmail(String email);

    List<Account> findByNameAndEmail(String name, String email);


    @Query("SELECT a FROM Account a WHERE a.name=:name and a.email=:email")
    List<Account> fetchAccounts(@Param("name") String name, @Param("email") String email);
}