package dino.one.ruphotel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by prgres on 2018-12-17.
 */

@CrossOrigin
@Controller
public class DefaultController {

    @RequestMapping(value = "/")
    public String index() {
        return "redirect:/index.html";
    }

}
