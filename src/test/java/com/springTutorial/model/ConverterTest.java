package com.springTutorial.model;


import com.springTutorial.servise.Converter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterTest {
    @Test
    void convertFromDecimalToNumericBase() {
        Number number = new Number("255", "10");
        Converter converter = new Converter(number);
        assertEquals(new Number("ff", "16"), converter.convert("16"));
        assertEquals(new Number("377", "8"), converter.convert("8"));
    }

    @Test
    void convertFromDecimalToRoman() {
        assertEquals(new Number("XII", "roman"),
                (new Converter(new Number("12", "10"))).convert("roman"));
        assertEquals(new Number("nulla", "roman"),
                (new Converter(new Number("0", "10"))).convert("roman"));
        assertEquals(new Number("I", "roman"),
                (new Converter(new Number("1", "10"))).convert("roman"));
        assertEquals(new Number("II", "roman"),
                (new Converter(new Number("2", "10"))).convert("roman"));
        assertEquals(new Number("MCDXXXIV", "roman"),
                (new Converter(new Number("1434", "10"))).convert("roman"));
        assertEquals(new Number("CDXCIX", "roman"),
                (new Converter(new Number("499", "10"))).convert("roman"));
        assertEquals(new Number("DCCCLXXXVIII", "roman"),
                (new Converter(new Number("888", "10"))).convert("roman"));
        assertEquals(new Number("XIX", "roman"),
                (new Converter(new Number("19", "10"))).convert("roman"));
        assertEquals(new Number("MMMDCLXXV", "roman"),
                (new Converter(new Number("3675", "10"))).convert("roman"));
    }
}
