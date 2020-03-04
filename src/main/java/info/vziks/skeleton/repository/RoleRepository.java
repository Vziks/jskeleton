package info.vziks.skeleton.repository;

import info.vziks.skeleton.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Interface RoleRepository
 * Project web-spring
 *
 * @author Anton Prokhorov <vziks@live.ru>§
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
