package org.suggs.katas.romannumerals;

import static org.suggs.katas.romannumerals.ArabicNumber.anArabicValueOf;
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
        ArabicNumber accumulatedValue = anArabicValueOf(0);
        for (int i = 0; i < romanNumerals.length; ++i) {
            accumulatedValue = accumulatedValue.include(calculateArabicValueOfNumeralAt(i));
        }
        return accumulatedValue;
    }

    private ArabicNumber calculateArabicValueOfNumeralAt(int locationInListOfNumerals) {
        if (theNextNumeralIsLargerThan(locationInListOfNumerals)) {
            return theNegativeValueOfTheNumeralAt(locationInListOfNumerals);
        }
        return thePositiveValueOfTheNumeralAt(locationInListOfNumerals);
    }

    private boolean theNextNumeralIsLargerThan(int locationInListOfNumerals) {
        return thereAreMoreElementsInTheListAfter(locationInListOfNumerals) &&
                aLargerNumberIsFoundAfter(locationInListOfNumerals);
    }

    private boolean thereAreMoreElementsInTheListAfter(int locationInListOfNumerals) {
        return locationInListOfNumerals + 1 < romanNumerals.length;
    }

    private boolean aLargerNumberIsFoundAfter(int locationInListOfNumerals) {
        return theValueOfTheNextNumeralFrom(locationInListOfNumerals)
                .isALargerValueThan(thePositiveValueOfTheNumeralAt(locationInListOfNumerals));
    }

    private ArabicNumber thePositiveValueOfTheNumeralAt(int currentNumeral) {
        return convertRomanToArabic(romanNumerals[currentNumeral]);
    }

    private ArabicNumber theNegativeValueOfTheNumeralAt(int currentNumeral) {
        return convertRomanToANegativeArabic(romanNumerals[currentNumeral]);
    }

    private ArabicNumber theValueOfTheNextNumeralFrom(int currentNumeral) {
        return thePositiveValueOfTheNumeralAt(currentNumeral + 1);
    }

}
