package ro.sorinLink.firmaBirou.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.sorinLink.firmaBirou.database.User;
import ro.sorinLink.firmaBirou.security.UserSession;
import ro.sorinLink.firmaBirou.service.Message;
import ro.sorinLink.firmaBirou.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserSession userSession;


    @PostMapping("/register-form")
    public ModelAndView registerAction(@RequestParam("email") String email,
                                       @RequestParam("password") String password,
                                       @RequestParam("password-again") String password2) {
        ModelAndView modelAndView = new ModelAndView("register");

            try {
                userService.save(email, password, password2);
            } catch (Message message) {
                String messageException = message.getMessage();
                modelAndView.addObject("message", messageException);
                return modelAndView;

            }
        //redirectionam user-ul catre pagina index.html daca este totul ok
        return new ModelAndView("redirect:/index.html");
    }



    @PostMapping("/login")
    public ModelAndView login(@RequestParam("email") String email,
                              @RequestParam("password") String password,
                              HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("index");

            List<User> userList = userService.getUserByEmail(email);
            if (userList.size() == 0) {
                modelAndView.addObject("message", "Email or password wrong!1");
            }
            if (userList.size() > 1) {
                modelAndView.addObject("message", "Email or password wrong!2");
            }
            if (userList.size() == 1) {
                User userFromDatabase = userList.get(0);
                if (!userFromDatabase.getPassword().equals(DigestUtils.md5Hex(password))) {
                    modelAndView.addObject("message", "Email or password wrong!3");
                } else {
                    userSession.setUserId(userFromDatabase.getId());
                    modelAndView = new ModelAndView("redirect:/dashboard");
                }
            }

            return modelAndView;
        }

        @GetMapping("dashboard")
        public ModelAndView dashboard () {
            ModelAndView modelAndView = new ModelAndView("addangajat");
            return modelAndView;
        }
    }
