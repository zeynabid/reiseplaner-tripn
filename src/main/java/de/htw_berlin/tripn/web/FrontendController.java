package de.htw_berlin.tripn.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

    // Alle Routen die nicht /api sind → Vue Router übernimmt
    @GetMapping(value = { "/", "/{path:[^\\.]*}", "/**/{path:[^\\.]*}" })
    public String index() {
        return "forward:/index.html";
    }
}
