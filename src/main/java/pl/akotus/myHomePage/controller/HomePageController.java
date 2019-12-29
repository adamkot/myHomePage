package pl.akotus.myHomePage.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pl.akotus.myHomePage.model.Attachment;
import pl.akotus.myHomePage.model.Home;
import pl.akotus.myHomePage.model.User;
import pl.akotus.myHomePage.service.AttachmentService;
import pl.akotus.myHomePage.service.HomeService;
import pl.akotus.myHomePage.service.StatisticService;
import pl.akotus.myHomePage.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import static org.springframework.util.StreamUtils.BUFFER_SIZE;

@Controller
public class HomePageController {

    @Autowired
    private HomeService homeService;

    @Autowired
    private UserService userService;

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private StatisticService statisticService;

    @RequestMapping(value = { "/", "/home"}, method = RequestMethod.GET)
    public ModelAndView homePageGet(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user != null) {
            modelAndView.addObject("loginUser", true);
        } else {
            statisticService.save(new Date(), request.getRemoteAddr());
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

    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public void getImage(@RequestParam Integer id, HttpServletResponse response) throws IOException {
        Attachment attachment = attachmentService.getById(id);
        response.setContentType(attachment.getContentType());
        response.setContentLength(attachment.getSizeOfFile().intValue());
        String headerValue = String.format("attachment; filename=\"%s\"", attachment.getOriginalFileName());
        response.setHeader("Content-Disposition", headerValue);
        OutputStream outStream;
        String dataDirectory = ("images/" + attachment.getFileName());
        try (FileInputStream inputStream = new FileInputStream(dataDirectory)) {
            outStream = response.getOutputStream();
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
        }
        outStream.close();
    }
}
