package pl.akotus.myHomePage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.akotus.myHomePage.model.Statistic;
import pl.akotus.myHomePage.service.StatisticService;

import java.util.List;

@Controller
public class StatisticPageController {

    @Autowired
    private StatisticService statisticService;

    @RequestMapping(value = "/statisticPage", method = RequestMethod.GET)
    public ModelAndView statisticPage() {
        ModelAndView modelAndView = new ModelAndView();
        List<Statistic> statisticList = statisticService.getAll();
        modelAndView.addObject("statisticList", statisticList);
        modelAndView.setViewName("statisticPage");
        return modelAndView;
    }
}
