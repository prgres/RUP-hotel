package dino.one.ruphotel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Serve React Frontend on the '/' route

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "redirect:/index.html";
    }

}
