package pl.akotus.myHomePage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.akotus.myHomePage.service.HomeService;

@Controller
public class HomePageController {

    @Autowired
    HomeService homeService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView homePageGet() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("homeList", homeService.getAll());
        modelAndView.addObject("itHomePage", true);
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ModelAndView pageGet(@RequestParam Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("text", "załadowano strone: " + id);
        modelAndView.addObject("itPage", true);
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
