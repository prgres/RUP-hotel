package dino.one.ruphotel.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Redirects to index.html when user goes to the unknown route

@Controller
public class UnknownController implements ErrorController {
    @RequestMapping("/error")
    public String error() {
        return "redirect:/index.html";
    }

    @Override
    public String getErrorPath() {
        return "redirect:/index.html";
    }
}
