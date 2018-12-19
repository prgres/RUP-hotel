package dino.one.ruphotel.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

//Redirects to index.html when user goes to the unknown route

//Serve React Frontend on the '/' route
@CrossOrigin
@Controller
public class UnknownController implements ErrorController {

    @RequestMapping("/error")
    public String error() {
        return null;
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
