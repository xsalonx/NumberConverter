package com.springTutorial.model;

import lombok.Getter;

import java.util.*;

@FunctionalInterface
interface Lambda {
    Number method(Converter converter);
}


@Getter
public class Converter {
    private static HashSet<String> numericBaseNotations;
    private static HashMap<String, Lambda> fromDecimalToOther;
    private static HashMap<String, Lambda> toDecimalLambda;

    static {
        numericBaseNotations = new HashSet<>();
        fromDecimalToOther = new HashMap<>();
        toDecimalLambda = new HashMap<>();

        numericBaseNotations.add("10");
        numericBaseNotations.add("16");

        toDecimalLambda.put("roman", Converter::romanToDecimal);
        fromDecimalToOther.put("roman", Converter::convertToRoman);
    }

// Roman digits
    private static HashMap<Integer, Character> numberToRomanDigits;
    private static HashMap<Character, Integer> romanDigitToNumber;
    static {
        numberToRomanDigits = new HashMap<>();
        romanDigitToNumber = new HashMap<>();
        numberToRomanDigits.put(1000, 'M');
        numberToRomanDigits.put(500, 'D');
        numberToRomanDigits.put(100, 'C');
        numberToRomanDigits.put(50, 'L');
        numberToRomanDigits.put(10, 'X');
        numberToRomanDigits.put(5, 'V');
        numberToRomanDigits.put(1, 'I');

        for (Map.Entry<Integer, Character> e : numberToRomanDigits.entrySet()) {
            romanDigitToNumber.put(e.getValue(), e.getKey());
        }
    }

    private Number number;

    public Converter(Number number) throws IllegalArgumentException{
        String notation = number.getNotation();
        if (! isNotationHandled(notation))
            throw new IllegalArgumentException("notation <" + notation + "> is not handled");
    }

    static public ArrayList<String> getHandledNotations() {
        ArrayList<String> res = new ArrayList<>(numericBaseNotations);
        res.addAll(fromDecimalToOther.keySet());
        return res;
    }

    static public boolean isNotationHandled(String notations) {
        return numericBaseNotations.contains(notations) || fromDecimalToOther.containsKey(notations);
    }

    public Number convert(String notation) throws CloneNotSupportedException {
        if (this.number.getNotation().equals(notation))
            return (Number) this.number.clone();

        if (numericBaseNotations.contains(notation)) {
            return (new Converter(this.toDecimal())).toStandardNotation(notation);
        } else if (fromDecimalToOther.containsKey(notation))
            return fromDecimalToOther.get(notation).method(new Converter(this.toDecimal()));
        else
            return new Number("null", "null");
    }

    private Number toDecimal() {
        String notation = this.number.getNotation();
        if (numericBaseNotations.contains(notation)) {
            return new Number(String.valueOf(
                    Integer.parseInt(this.number.getValue(), Integer.parseInt(this.number.getNotation()))
            )
            );
        } else if (toDecimalLambda.containsKey(notation))
            return toDecimalLambda.get(notation).method(this);
        else
            return new Number("null", "null");
    }

    private Number toStandardNotation(String notation) {
        int base = Integer.parseInt(notation);
        int value = Integer.parseInt(this.number.getValue(), Integer.parseInt(this.number.getNotation()));

        if (value == 0) {
            return new Number("0", notation);
        }
        StringBuilder numberStr = new StringBuilder();
        while (value > 0) {
            numberStr.insert(0, value % base);
            value /= base;
        }

        return new Number(numberStr.toString(), notation);
    }

    private Number romanToDecimal() {
        if (this.number.getValue().equals("nulla"))
            return new Number("0");
        String strValue = this.number.getValue();
        int value = 0, counter = 1, currCharacterValue, prevCharactersValue;
        char digit = strValue.charAt(0), currCharacter;
        for (int i = 1; i < strValue.length(); i++) {
            currCharacter = strValue.charAt(i);
            if (currCharacter == digit)
                counter++;
            else {
                prevCharactersValue = romanDigitToNumber.get(digit);
                currCharacterValue = romanDigitToNumber.get(currCharacter);
                if (currCharacterValue < prevCharactersValue) {
                    value += counter * prevCharactersValue;
                    digit = currCharacter;
                    counter = 1;
                } else {
                    value += (currCharacterValue - counter * prevCharactersValue); // counter always will be equal 1;
                    i++;
                    digit = strValue.charAt(i);
                    counter = 1;
                }
            }
        }

        return new Number(String.valueOf(value));
    }


    private Number convertToRoman() {
        int value = Integer.parseInt(this.number.getValue(), Integer.parseInt(this.number.getNotation()));
        if (value == 0)
            return new Number("nulla", "roman");

        List<Integer> values = new ArrayList<>(numberToRomanDigits.keySet());
        values.sort(Collections.reverseOrder());
        StringBuilder strValue = new StringBuilder();
        int v, u;
        for (int i = 0; i < values.size(); i++) {
            v = values.get(i);
            while (v <= value) {
                strValue.append(numberToRomanDigits.get(v));
                value -= v;
            }
            if (value > 0) {
                u = values.get(i + 1);
                if (value - (v - u) >= 0) {
                    strValue.append(numberToRomanDigits.get(u));
                    strValue.append(numberToRomanDigits.get(v));
                    value -= (v - u);
                }
            }

        }
        return new Number(strValue.toString(), "roman");
    }

}
