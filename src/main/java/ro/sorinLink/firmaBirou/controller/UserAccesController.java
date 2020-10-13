package ro.sorinLink.firmaBirou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.sorinLink.firmaBirou.database.UserDAO;
import ro.sorinLink.firmaBirou.security.UserSession;
import ro.sorinLink.firmaBirou.service.Message;
import ro.sorinLink.firmaBirou.service.UserRoleService;
import ro.sorinLink.firmaBirou.service.UserService;

@Controller
public class UserAccesController {
    @Autowired
    UserDAO userDAO;

    @Autowired
    UserSession userSession;
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;

    @GetMapping("/useracces")
    public ModelAndView useracces() {
        return new ModelAndView("useracces");
    }


    @PostMapping("/user-acces")
    public ModelAndView useracces(@RequestParam("email") String email,
                                  @RequestParam("acces") String acces) {
        ModelAndView modelAndView = new ModelAndView("useracces");

        try {
            userRoleService.saveRole(acces, email);
        } catch (Message message) {
            modelAndView.addObject("message", message.getMessage());
            return modelAndView;

        } catch (Exception e) {
            e.printStackTrace();
        }
// de veriv
        return modelAndView;
    }


        //metoda nu este ok
//        if (!(userDAO.findByEmail(email).equals(email))) {
//            modelAndView.addObject("message", "email not be fond");
//            return modelAndView;
//        }else {
//            modelAndView.addObject("message", "Acces setat" + " "+ acces);
//            userRoleService.saveRole(acces,email);
//        }
//            return modelAndView;
//
//        }
    }
