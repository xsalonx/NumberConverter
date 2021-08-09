package com.springTutorial.controller;

import com.springTutorial.servise.Converter;
import com.springTutorial.model.Number;
import com.springTutorial.model.ConversionData;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MController {

    private static final String CONVERSION_DATA_ATTR_NAME = "conversionData";

    @GetMapping("/")
    public String getIndexR(Model model) {
        model.addAttribute(CONVERSION_DATA_ATTR_NAME, new ConversionData());
        model.addAttribute("handledNotations", Converter.getHandledNotations());
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String getIndex(Model model) {
        model.addAttribute(CONVERSION_DATA_ATTR_NAME, new ConversionData());
        model.addAttribute("handledNotations", Converter.getHandledNotations());

        return "index";
    }

    @PostMapping("/index")
    public String postConverter(ConversionData conversionData, BindingResult bindingResult, Model model) {
//        model.addAttribute(CONVERSION_DATA_ATTR_NAME, conversionData);
        model.addAttribute("handledNotations", Converter.getHandledNotations());
        if (!bindingResult.hasErrors())
            model.addAttribute("noErrors", true);

        System.out.println(conversionData);

        Number receivedNumber = conversionData.createNumber();
        Converter converter = new Converter(receivedNumber);

        try {
            Number number = converter.convert(conversionData.getNotationTo());
            model.addAttribute("number", number);
            System.out.println(number);
        } catch (NumberFormatException e) {
            model.addAttribute("number", new Number("incorrect format or too big number", receivedNumber.getNotation()));
        }


        System.out.println(conversionData);
        return "index";
    }
}
