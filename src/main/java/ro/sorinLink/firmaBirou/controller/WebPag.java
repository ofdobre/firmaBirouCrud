package ro.sorinLink.firmaBirou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebPag {

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }
    @GetMapping("/admin")
    public ModelAndView admin() {
        return new ModelAndView("admin");
    }
    @GetMapping("/addangajat")
    public  ModelAndView addAng(){return new ModelAndView("addabgajat");}
    @GetMapping("/test")
    public ModelAndView test() {
        return new ModelAndView("test");
    }
    @GetMapping("/test1")
    public ModelAndView test1() {
        return new ModelAndView("test1");
    }
    @GetMapping(name = "/butfac")
    public ModelAndView butfac() { return new ModelAndView("redirect:/test");}



}
