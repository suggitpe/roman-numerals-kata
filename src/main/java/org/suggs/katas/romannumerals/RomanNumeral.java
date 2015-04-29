package org.suggs.katas.romannumerals;

import java.util.HashMap;
import java.util.Map;

import static org.suggs.katas.romannumerals.ArabicNumber.anArabicValueOf;

public class RomanNumeral {

    private static final Map<Character, Integer> numerals = new HashMap<>();

    static {
        numerals.put('I', 1);
        numerals.put('V', 5);
        numerals.put('X', 10);
        numerals.put('L', 50);
        numerals.put('C', 100);
        numerals.put('D', 500);
        numerals.put('M', 1000);
    }

    public static ArabicNumber convertRomanToArabic(char numeral) {
        return anArabicValueOf(numerals.get(numeral));
    }

    public static ArabicNumber convertRomanToANegativeArabic(char numeral) {
        return anArabicValueOf(numerals.get(numeral) * -1);
    }
}
