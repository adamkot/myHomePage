package pl.akotus.myHomePage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.akotus.myHomePage.model.Home;
import pl.akotus.myHomePage.service.HomeService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AddNewPageController {

    @Autowired
    HomeService homeService;

    @RequestMapping(value = "/addNewPage", method = RequestMethod.GET)
    public ModelAndView addNewPage() {
        ModelAndView modelAndView = new ModelAndView();
        Home home = new Home();
        modelAndView.addObject("home", home);
        modelAndView.setViewName("addNewPage");
        return modelAndView;
    }

    @RequestMapping(value = "/addNewPage", method = RequestMethod.POST)
    public ModelAndView newPage(@Valid Home home, BindingResult bindingResult, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(home);
        homeService.save(home);
        modelAndView.setViewName("redirect:addNewPage");
        return modelAndView;
    }
}
