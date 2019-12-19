package pl.akotus.myHomePage.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.akotus.myHomePage.model.Contents;
import pl.akotus.myHomePage.model.Home;
import pl.akotus.myHomePage.repository.HomeRepository;

import java.util.ArrayList;
import java.util.List;

@Service("homeService")
public class HomeService {
    private HomeRepository homeRepository;

    public HomeService(@Qualifier("homeRepository") HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    public List<Home> getAll() {
        return (List<Home>) homeRepository.findAll();
    }

    public Home getById(Integer id) {
        return homeRepository.findById(id).get();
    }

    public void save(Home home) {
        List<Contents> contents = home.getContents();
        List<Contents> contentsNotEmpty = new ArrayList<>();
        for(Contents content : contents) {
            if(content.getText().length() > 0) {
                contentsNotEmpty.add(content);
            }
        }
        home.setContents(contentsNotEmpty);
        home.setEnabled(true);
        homeRepository.save(home);
    }

    public void delete(Home home) {
        home.setEnabled(false);
        homeRepository.save(home);
    }
}
