package com.springTutorial.controller;

import com.springTutorial.service.Converter;
import com.springTutorial.model.Number;
import com.springTutorial.model.ConversionData;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


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



