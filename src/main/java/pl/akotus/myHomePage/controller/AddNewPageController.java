package pl.akotus.myHomePage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pl.akotus.myHomePage.model.Attachment;
import pl.akotus.myHomePage.model.Contents;
import pl.akotus.myHomePage.model.Home;
import pl.akotus.myHomePage.service.AttachmentService;
import pl.akotus.myHomePage.service.HomeService;

import javax.validation.Valid;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Controller
public class AddNewPageController {

    @Autowired
    HomeService homeService;

    @Autowired
    AttachmentService attachmentService;

    @RequestMapping(value = "/addNewPage", method = RequestMethod.GET)
    public ModelAndView addNewPage() {
        ModelAndView modelAndView = new ModelAndView();
        Home home = new Home();
        home.setContents(new ArrayList<Contents>());
        for (int i = 0; i < 10; i++) {
            home.getContents().add(new Contents());
        }
        modelAndView.addObject("home", home);
        modelAndView.setViewName("addNewPage");
        return modelAndView;
    }

    @RequestMapping(value = "/addNewPage", method = RequestMethod.POST)
    public ModelAndView newPage(@Valid Home home, @RequestParam(value = "file") MultipartFile[] file)
            throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        home.setCreateDate(new Date());
        if (file.length > 0) {
            for (int i = 0; i < file.length; i++) {
                MultipartFile files = file[i];
                if (file != null && files.getSize() > 10) {
                    if (files.getSize() > 1100000) {
                        break;
                    }
                    UUID uuid = UUID.randomUUID();
                    Attachment attachement = new Attachment(uuid.toString(), files.getOriginalFilename(),
                            (double) files.getSize(), files.getContentType());
                    attachmentService.save(attachement);
                    home.getContents().get(i).setImage(attachmentService.getByFileName(attachement.getFileName()));
                    byte[] bytes = files.getBytes();
                    File fsFile = new File("images/" + attachement.getFileName());
                    fsFile.createNewFile();
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fsFile));
                    stream.write(bytes);
                    stream.close();
                }
            }
        }
        //System.out.println("##################### " + home);
        homeService.save(home);
        modelAndView.setViewName("redirect:addNewPage");
        return modelAndView;
    }
}
