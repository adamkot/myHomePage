package pl.akotus.myHomePage.service;

import org.springframework.stereotype.Service;
import pl.akotus.myHomePage.model.Home;
import pl.akotus.myHomePage.repository.HomeRepository;

import java.util.Iterator;
import java.util.List;

@Service("homeService")
public class HomeService {
    private HomeRepository homeRepository;

    public HomeService(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    public List<Home> getAll() {
        return (List<Home>) homeRepository.findAll();
    }

    public void save(Home home) {
        homeRepository.save(home);
    }
}
