package org.suggs.katas.romannumerals;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.suggs.katas.romannumerals.ArabicNumber.anArabicValueOf;

public class ArabicNumeralTest {
    @Test
    public void canAccumulatePositiveNumbers() {
        assertThat(anArabicValueOf(5).include(anArabicValueOf(3))).isEqualTo(anArabicValueOf(8));
    }

    @Test
    public void canAccumulateNegativeNumbers(){
        assertThat(anArabicValueOf(5).include(anArabicValueOf(-2))).isEqualTo(anArabicValueOf(3));
    }

    @Test
    public void canBeComparedToOtherArabicNumerals(){
        assertThat(anArabicValueOf(5).isALargerValueThan(anArabicValueOf(3))).isTrue();
    }
}
