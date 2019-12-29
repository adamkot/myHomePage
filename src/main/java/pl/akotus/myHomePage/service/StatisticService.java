package pl.akotus.myHomePage.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.akotus.myHomePage.model.Statistic;
import pl.akotus.myHomePage.repository.StatisticRepository;

import java.util.Date;
import java.util.List;

@Service("statisticService")
public class StatisticService {

    private StatisticRepository statisticRepository;

    public StatisticService(@Qualifier("statisticRepository") StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    public List<Statistic> getAll() {
        return (List<Statistic>) statisticRepository.findAll();
    }

    public void save(Statistic statistic) {
        statisticRepository.save(statistic);
    }

    public void save(Date date, String address) {
        Statistic statistic = new Statistic();
        statistic.setEntryDate(date);
        statistic.setIpAddress(address);
        statisticRepository.save(statistic);
    }
}
