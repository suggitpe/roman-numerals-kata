package org.suggs.katas.romannumerals;

import static org.suggs.katas.romannumerals.RomanNumeral.convertRomanToANegativeArabic;
import static org.suggs.katas.romannumerals.RomanNumeral.convertRomanToArabic;

public class RomanNumber {

    private final char[] romanNumerals;

    public static RomanNumber aRomanNumberOf(String aRomanNumeral) {
        return new RomanNumber(aRomanNumeral);
    }

    private RomanNumber(String aRomanNumber) {
        romanNumerals = aRomanNumber.toCharArray();
    }

    public ArabicNumber convertToArabic() {
        ArabicNumber accumulatedValue = ArabicNumber.anArabicValueOf(0);
        for (int i = 0; i < romanNumerals.length; ++i) {
            accumulatedValue = accumulatedValue.include(calculateArabicValueOfNumeralAt(i));
        }
        return accumulatedValue;
    }

    private ArabicNumber calculateArabicValueOfNumeralAt(int locationInListOfNumerals) {
        if (theNextNumeralIsLargerThan(locationInListOfNumerals)) {
            return convertRomanToANegativeArabic(romanNumerals[locationInListOfNumerals]);
        }
        return convertRomanToArabic(romanNumerals[locationInListOfNumerals]);
    }

    private boolean theNextNumeralIsLargerThan(int locationInListOfNumerals) {
        if (thereAreMoreElementsInTheListAfter(locationInListOfNumerals)) {
            return aLargerNumberIsFoundAfter(locationInListOfNumerals);
        }
        return false;
    }

    private boolean thereAreMoreElementsInTheListAfter(int locationInListOfNumerals) {
        if (locationInListOfNumerals + 1 < romanNumerals.length) {
            return true;
        }
        return false;
    }

    private boolean aLargerNumberIsFoundAfter(int locationInListOfNumerals) {
        if (convertRomanToArabic(romanNumerals[locationInListOfNumerals + 1]).isALargerValueThan(convertRomanToArabic(romanNumerals[locationInListOfNumerals]))) {
            return true;
        }
        return false;
    }

}
