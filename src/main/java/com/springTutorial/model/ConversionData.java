package com.springTutorial.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ConversionData {
    static final String defaultNotation = "10";

    private String value;
    private String notationFrom;
    private String notationTo;

    ConversionData(String value, String notationTo) {
        this.value = value;
        this.notationFrom = defaultNotation;
        this.notationTo = notationTo;
    }
    public Number createNumber() {
        return new Number(this.value, this.notationFrom != null ? this.notationFrom : "10");
    }
}
