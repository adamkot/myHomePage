package pl.akotus.myHomePage.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.akotus.myHomePage.model.User;

import java.util.List;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.enabled = TRUE ORDER BY u.lastName")
    public List<User> findAll();
}
