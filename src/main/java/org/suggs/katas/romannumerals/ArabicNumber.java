package org.suggs.katas.romannumerals;

public class ArabicNumber {

    private final int arabicNumeral;

    private ArabicNumber(int anArabicNumeral) {
        arabicNumeral = anArabicNumeral;
    }

    public static ArabicNumber anArabicValueOf(int anArabicNumeral) {
        return new ArabicNumber(anArabicNumeral);
    }

    public ArabicNumber include(ArabicNumber otherArabicNumeral) {
        return anArabicValueOf(arabicNumeral + otherArabicNumeral.arabicNumeral);
    }

    public boolean isALargerValueThan(ArabicNumber otherArabicNumber) {
        if(otherArabicNumber.arabicNumeral < arabicNumeral){
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArabicNumber that = (ArabicNumber) o;

        if (arabicNumeral != that.arabicNumeral) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return arabicNumeral;
    }
}
