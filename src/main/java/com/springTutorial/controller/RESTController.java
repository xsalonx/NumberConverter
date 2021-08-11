package com.springTutorial.controller;

import com.springTutorial.model.Number;
import com.springTutorial.service.Converter;
import org.springframework.web.bind.annotation.*;

// TODO use Converter as singleton

@RestController
public class RESTController {

    @RequestMapping(value ="converter", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody Number postConverter(@RequestParam("value") String value,
                                              @RequestParam("notationFrom") String notationFrom,
                                              @RequestParam("notationTo") String notationTo) {

        Number receivedNumber = new Number(value, notationFrom);
        if (receivedNumber.getValue() != null && !receivedNumber.getValue().equals("")) {
            Converter converter = new Converter(receivedNumber);
            try {
                return converter.convert(notationTo);
            } catch (NumberFormatException e) {
                return new Number(e.getMessage(), "");
            }
        }
        System.out.println(value);
        return new Number("", "");
    }
}
