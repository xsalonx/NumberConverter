package com.springTutorial.model;

import javax.validation.constraints.NotEmpty;

public class Number {
    private String value;

    public Number toHex() {
        return new Number(Integer.toHexString(Integer.parseInt(this.value)));
    }


    public Number(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "StrNumberWithBase{" +
                "value='" + value + '\'' +
                '}';
    }

}
