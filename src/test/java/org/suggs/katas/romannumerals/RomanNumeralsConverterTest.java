package org.suggs.katas.romannumerals;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.suggs.katas.romannumerals.ArabicNumber.anArabicValueOf;
import static org.suggs.katas.romannumerals.RomanNumber.aRomanNumberOf;

public class RomanNumeralsConverterTest {

    @Test
    public void convertsSingleNumeralsToDecimal() {
        assertThat(aRomanNumberOf("I").convertToArabic()).isEqualTo(anArabicValueOf(1));
    }

    @Test
    public void convertsAddativeMultipleNumeralsToDecimal() {
        assertThat(aRomanNumberOf("VIII").convertToArabic()).isEqualTo(anArabicValueOf(8));
    }

    @Test
    public void convertsReductiveMultipleNumeralsToDecimal() {
        assertThat(aRomanNumberOf("IV").convertToArabic()).isEqualTo(anArabicValueOf(4));
    }
}
