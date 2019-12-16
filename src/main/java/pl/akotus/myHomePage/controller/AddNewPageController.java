package pl.akotus.myHomePage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.akotus.myHomePage.model.Contents;
import pl.akotus.myHomePage.model.Home;
import pl.akotus.myHomePage.service.HomeService;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.AbstractDocument;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class AddNewPageController {

    @Autowired
    HomeService homeService;

    @RequestMapping(value = "/addNewPage", method = RequestMethod.GET)
    public ModelAndView addNewPage() {
        ModelAndView modelAndView = new ModelAndView();
        Home home = new Home();
        home.setContents(new ArrayList<Contents>());
        for(int i =0; i < 10; i++) {
            home.getContents().add(new Contents());
        }
        modelAndView.addObject("home", home);
        modelAndView.setViewName("addNewPage");
        return modelAndView;
    }

    @RequestMapping(value = "/addNewPage", method = RequestMethod.POST)
    public ModelAndView newPage(@Valid Home home, BindingResult bindingResult, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        home.setCreateDate(new Date());
        homeService.save(home);
        modelAndView.setViewName("redirect:addNewPage");
        return modelAndView;
    }
}
