package pl.akotus.myHomePage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.akotus.myHomePage.model.User;
import pl.akotus.myHomePage.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView newUser(@Valid User user, BindingResult bindingResult, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult.rejectValue("email", "error.user", "istnieje osoba pod tym adresem email!");
            modelAndView.addObject("user", user);
            modelAndView.setViewName("registration");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("user", user);
            modelAndView.setViewName("registration");
        } else {
            user.setEnabled(false);
            user.setCreateDate(new Date());
            userService.saveUser(user);
            modelAndView.addObject("successMessage","poprawnie zapisano!");
            User nextUser = new User();
            modelAndView.addObject("user", nextUser);
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }
}
