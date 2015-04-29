package org.suggs.katas.romannumerals

import spock.lang.Specification
import spock.lang.Unroll

import static org.suggs.katas.romannumerals.ArabicNumber.anArabicValueOf
import static org.suggs.katas.romannumerals.RomanNumber.aRomanNumberOf

class RomanNumeralsSpecification extends Specification{

    @Unroll
    def "The arabic conversion of #roman is #arabic"(){
        expect:
            anArabicValueOf(arabic) == aRomanNumberOf(roman).convertToArabic()
        where:
            roman   | arabic
            "I"     | 1
            "VI"    | 6
            "IV"    | 4
            "VIII"  | 8
            "XIV"   | 14
            "LII"   | 52
            "MMX"   | 2010
            "MMXV"  | 2015
    }
}