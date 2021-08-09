package com.springTutorial.model;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Number {
    static final String defaultNotation = "10";
    private String value;
    private String notation;

    public Number(String value) {
        this.value = value;
        this.notation = defaultNotation;
    }

    public Number copy() {
        return new Number(this.value, this.notation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return Objects.equals(value, number.value) && Objects.equals(notation, number.notation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, notation);
    }
}
