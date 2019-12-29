package pl.akotus.myHomePage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.akotus.myHomePage.model.Statistic;

@Repository("statisticRepository")
public interface StatisticRepository extends CrudRepository<Statistic, Integer> {
}
