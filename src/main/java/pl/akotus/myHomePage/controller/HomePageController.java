package pl.akotus.myHomePage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.akotus.myHomePage.model.Home;
import pl.akotus.myHomePage.model.User;
import pl.akotus.myHomePage.service.HomeService;
import pl.akotus.myHomePage.service.UserService;

@Controller
public class HomePageController {

    @Autowired
    private HomeService homeService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = { "/", "/home"}, method = RequestMethod.GET)
    public ModelAndView homePageGet() {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user != null) {
            modelAndView.addObject("loginUser", true);
        }
        modelAndView.addObject("homeList", homeService.getAll());
        modelAndView.addObject("itHomePage", true);
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ModelAndView pageGet(@RequestParam(required = false) Integer id, @RequestParam(required = false)Integer delete) {
        ModelAndView modelAndView = new ModelAndView();
        if (id != null) {
            Home home = homeService.getById(id);
            modelAndView.addObject("home", home);
            modelAndView.addObject("itPage", true);
            modelAndView.setViewName("home");
        } else if (delete != null) {
            Home home = homeService.getById(delete);
            homeService.delete(home);
            modelAndView.setViewName("redirect:home");
        }
        return modelAndView;
    }
}
