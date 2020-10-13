package ro.sorinLink.firmaBirou.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.sorinLink.firmaBirou.database.Angajat;
import ro.sorinLink.firmaBirou.database.User;
import ro.sorinLink.firmaBirou.security.UserSession;
import ro.sorinLink.firmaBirou.service.AngajatService;
import ro.sorinLink.firmaBirou.service.UserService;

import java.util.List;

@Controller
public class AngajatController {
    @Autowired
    UserService userService;
    @Autowired
    UserSession userSession;
    @Autowired
    AngajatService angajatService;

    @GetMapping("/success")
    public ModelAndView Success() {
        return new ModelAndView("success");
    }

    @PostMapping("/add-angajat")
    public ModelAndView addAngajat(@RequestParam("email") String email,
                                       @RequestParam("functie") String functie,
                                       @RequestParam("name") String name,
                                       @RequestParam("lastName") String lastName,
                                       @RequestParam("cnp") String cnp) {

        ModelAndView modelAndView = new ModelAndView("addangajat");
        //email cu email from user
        List<Angajat> angajatList = angajatService.findAngajatByEmail(email);
        List<User> userList = userService.findByEmail(email);
        if (userList.size() == 0) {
            modelAndView.addObject("message", "Userul nu exista");
            return modelAndView;
        }
            if (userList.size() > 1) {
                modelAndView.addObject("message", "Exita mai multi useri");
                return modelAndView;

            } if (angajatList.size() > 1) {
          modelAndView.addObject("message", "Angajatul este deja salvat");
            return modelAndView;
        }if
              (userList.size() == 1) {
            User userFromDatabase = userList.get(0);
            userFromDatabase.equals(email);
                angajatService.saveAngajat(cnp, functie, name, lastName, userFromDatabase.getEmail());
                modelAndView = new ModelAndView("redirect:/success");
            }

            return modelAndView;

        }
    }