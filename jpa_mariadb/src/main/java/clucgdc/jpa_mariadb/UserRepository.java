package clucgdc.jpa_mariadb;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Cam Luc
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findByNameStartingWith(String name);

    List<User> findByEmailEndingWith(String email);
}
