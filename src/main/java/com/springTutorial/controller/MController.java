package com.springTutorial.controller;
import com.springTutorial.model.Number;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MController {

    @GetMapping("/")
    public String getIndexR(Model model) {
        return "redirect:/index";
    }
    @GetMapping("/index")
    public String getIndex(Model model) {
        return "index";
    }

    @GetMapping("/converter")
    public String getConverter(Model model) {
        model.addAttribute("number", new Number("0"));
        return "converter";
    }

    @PostMapping("/converter")
    public String postConverter(Number number, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors())
            model.addAttribute("noErrors", true);

        model.addAttribute("number", number);

        System.out.println(number);
        return "converter";
    }
}
