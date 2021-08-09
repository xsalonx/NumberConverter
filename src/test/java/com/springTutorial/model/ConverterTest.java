package com.springTutorial.model;


import com.springTutorial.servise.Converter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConverterTest {
    @Test
    void converterNotHandledNotation() {
        // given
        Number number = new Number("255", "12ss4fs");
        // then
        assertThrows(IllegalArgumentException.class, () -> new Converter(number));
    }
    @Test
    void convertFromDecimalToHandledNumericBase_16() {
        // given
        Number number = new Number("255", "10");
        Converter converter = new Converter(number);
        // when
        Number result = converter.convert("16");
        //then
        assertEquals(new Number("ff", "16"), result);
    }

    @Test
    void convertFromDecimalToHandledNumericBase_8() {
        // given
        Number number = new Number("255", "10");
        Converter converter = new Converter(number);
        // when
        Number result = converter.convert("8");
        //then
        assertEquals(new Number("377", "8"), result);
    }


    @Test
    void convertFromDecimalToRoman_0() {
        // given
        Number number = new Number("0", "10");
        Converter converter = new Converter(number);
        // when
        Number result = converter.convert("roman");
        //then
        assertEquals(new Number("nulla", "roman"), result);
    }
    @Test
    void convertFromDecimalToRoman_1() {
        // given
        Number number = new Number("1", "10");
        Converter converter = new Converter(number);
        // when
        Number result = converter.convert("roman");
        // then
        assertEquals(new Number("I", "roman"), result);
    }
    @Test
    void convertFromDecimalToRoman_2() {
        // given
        Number number = new Number("2", "10");
        Converter converter = new Converter(number);
        // when
        Number result = converter.convert("roman");
        // then
        assertEquals(new Number("II", "roman"), result);
    }
    @Test
    void convertFromDecimalToRoman_12() {
        // given
        Number number = new Number("12", "10");
        Converter converter = new Converter(number);
        // when
        Number result = converter.convert("roman");
        // then
        assertEquals(new Number("XII", "roman"), result);
    }
    @Test
    void convertFromDecimalToRoman_19() {
        // given
        Number number = new Number("19", "10");
        Converter converter = new Converter(number);
        // when
        Number result = converter.convert("roman");
        //then
        assertEquals(new Number("XIX", "roman"), result);
    }
    @Test
    void convertFromDecimalToRoman_499() {
        // given
        Number number = new Number("499", "10");
        Converter converter = new Converter(number);
        // when
        Number result = converter.convert("roman");
        // then
        assertEquals(new Number("CDXCIX", "roman"), result);
    }
    @Test
    void convertFromDecimalToRoman_888() {
        // given
        Number number = new Number("888", "10");
        Converter converter = new Converter(number);
        // when
        Number result = converter.convert("roman");
        // then
        assertEquals(new Number("DCCCLXXXVIII", "roman"), result);
    }
    @Test
    void convertFromDecimalToRoman_1434() {
        // given
        Number number = new Number("1434", "10");
        Converter converter = new Converter(number);
        // when
        Number result = converter.convert("roman");
        // then
        assertEquals(new Number("MCDXXXIV", "roman"), result);
    }
    @Test
    void convertFromDecimalToRoman_3675() {

        // given
        Number number = new Number("3675", "10");
        Converter converter = new Converter(number);
        // when
        Number result = converter.convert("roman");
        //then
        assertEquals(new Number("MMMDCLXXV", "roman"), result);
    }

    @Test
    void negativeNumbers() {
        // given
        Number number = new Number("-255", "10");
        Converter converter = new Converter(number);
        // when
        Number result = converter.convert("8");
        //then
        assertEquals(new Number("-377", "8"), result);
    }
}
