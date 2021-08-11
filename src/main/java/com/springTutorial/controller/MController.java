package com.springTutorial.controller;

import com.springTutorial.service.Converter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MController {

    private static final String CONVERSION_DATA_ATTR_NAME = "conversionData";

    @GetMapping("/")
    public String getIndexR(Model model) {
        model.addAttribute("handledNotations", Converter.getHandledNotations());
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String getIndex(Model model) {
        model.addAttribute("handledNotations", Converter.getHandledNotations());

        return "index";
    }


}



