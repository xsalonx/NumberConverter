package com.springTutorial.controller;

import com.springTutorial.model.ConversionData;
import com.springTutorial.model.Number;
import com.springTutorial.service.Converter;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class RESTController {

    @RequestMapping(path="converter", method=RequestMethod.GET)
    public @ResponseBody Number postConverter(@RequestParam("value") String value,
                                              @RequestParam("notationFrom") String notationFrom,
                                              @RequestParam("notationTo") String notationTo) {

        System.out.println(value);
        System.out.println(notationFrom);
        System.out.println(notationTo);

        Number receivedNumber = new Number(value, notationFrom);
        if (receivedNumber.getValue() != null && !receivedNumber.getValue().equals("")) {
            Converter converter = new Converter(receivedNumber);
            try {
                Number number = converter.convert(notationTo);
                return number;
            } catch (NumberFormatException e) {
                return new Number(e.getMessage(), "");
            }
        }
        System.out.println(value);;
        return new Number("", "");
    }
}
