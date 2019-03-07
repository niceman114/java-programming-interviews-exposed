package com.wiley.javainterviewsexposed.chapter16.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SimpleController {

    @RequestMapping("/planets")
    public String createSimpleModel(final Model model) {

        model.addAttribute("now", new Date());

        final Map<String, String> diameters = new HashMap<>();
        diameters.put("Mercury", "3000 miles");
        diameters.put("Venus", "7500 miles");
        diameters.put("Earth", "8000 miles");

        model.addAttribute("diameters", diameters);

        return "diameters";
    }
}
