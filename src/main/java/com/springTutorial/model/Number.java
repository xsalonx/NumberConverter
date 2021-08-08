package com.springTutorial.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Number implements Cloneable{
    static final String defaultNotation = "10";
    private String value;
    private String notation;

    public Number(String value) {
        this.value = value;
        this.notation = defaultNotation;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
