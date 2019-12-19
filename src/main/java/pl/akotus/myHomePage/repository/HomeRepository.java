package pl.akotus.myHomePage.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.akotus.myHomePage.model.Home;

import java.util.List;

@Repository("homeRepository")
public interface HomeRepository extends CrudRepository<Home, Integer> {

    @Query("SELECT h FROM Home h WHERE h.enabled = TRUE ORDER BY h.createDate")
    public List<Home> findAll();
}
