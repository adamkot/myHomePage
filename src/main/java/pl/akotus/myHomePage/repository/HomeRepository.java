package pl.akotus.myHomePage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.akotus.myHomePage.model.Home;

@Repository("homeRepository")
public interface HomeRepository extends CrudRepository<Home, Integer> {

}
