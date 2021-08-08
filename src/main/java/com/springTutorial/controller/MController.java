package com.springTutorial.controller;

import com.springTutorial.model.Converter;
import com.springTutorial.model.Number;
import com.springTutorial.model.ConversionData;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MController {

    @GetMapping("/")
    public String getIndexR(Model model) {
        model.addAttribute("number", new ConversionData());
        model.addAttribute("handledNotations", Converter.getHandledNotations());
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String getIndex(Model model) {
        model.addAttribute("number", new ConversionData());
        model.addAttribute("handledNotations", Converter.getHandledNotations());

        return "index";
    }

    @PostMapping("/index")
    public String postConverter(ConversionData conversionData, BindingResult bindingResult, Model model) {
        model.addAttribute("handledNotations", Converter.getHandledNotations());
        if (!bindingResult.hasErrors())
            model.addAttribute("noErrors", true);


        Converter converter = new Converter(conversionData.createNumber());
        try {
            Number number = converter.convert(conversionData.getNotationTo());
            model.addAttribute("number", number);
            System.out.println(number);
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }


        System.out.println(conversionData);
        return "index";
    }
}
