package org.numerals.RomanNumerals.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanNumeralConverterTests {
    @Test
    void negative() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.intToRomanNumeral(-1));
    }

    @Test
    void zero() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.intToRomanNumeral(0));
    }

    @Test
    void upperLimit() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.intToRomanNumeral(4000));
    }

    @Test
    void veryLarge() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.intToRomanNumeral(50000));
    }

    @Test
    void one() {
        assertEquals("I", RomanNumeralConverter.intToRomanNumeral(1));
    }

    @Test
    void two() {
        assertEquals("II", RomanNumeralConverter.intToRomanNumeral(2));
    }

    @Test
    void three() {
        assertEquals("III", RomanNumeralConverter.intToRomanNumeral(3));
    }

    @Test
    void four() {
        assertEquals("IV", RomanNumeralConverter.intToRomanNumeral(4));
    }

    @Test
    void five() {
        assertEquals("V", RomanNumeralConverter.intToRomanNumeral(5));
    }

    @Test
    void six() {
        assertEquals("VI", RomanNumeralConverter.intToRomanNumeral(6));
    }

    @Test
    void seven() {
        assertEquals("VII", RomanNumeralConverter.intToRomanNumeral(7));
    }

    @Test
    void eight() {
        assertEquals("VIII", RomanNumeralConverter.intToRomanNumeral(8));
    }

    @Test
    void nine() {
        assertEquals("IX", RomanNumeralConverter.intToRomanNumeral(9));
    }

    @Test
    void ten() {
        assertEquals("X", RomanNumeralConverter.intToRomanNumeral(10));
    }

    @Test
    void convert50() {
        assertEquals("L", RomanNumeralConverter.intToRomanNumeral(50));
    }

    @Test
    void convert3888() {
        assertEquals("MMMDCCCLXXXVIII", RomanNumeralConverter.intToRomanNumeral(3888));
    }

    @Test
    void convert3999() {
        assertEquals("MMMCMXCIX", RomanNumeralConverter.intToRomanNumeral(3999));
    }

    @Test
    void convert1754() {
        assertEquals("MDCCLIV", RomanNumeralConverter.intToRomanNumeral(1754));
    }

    @Test
    void convert819() {
        assertEquals("DCCCXIX", RomanNumeralConverter.intToRomanNumeral(819));
    }

    @Test
    void convert100() {
        assertEquals("C", RomanNumeralConverter.intToRomanNumeral(100));
    }

    @Test
    void convert500() {
        assertEquals("D", RomanNumeralConverter.intToRomanNumeral(500));
    }

    @Test
    void convert1000() {
        assertEquals("M", RomanNumeralConverter.intToRomanNumeral(1000));
    }

    @Test
    void convert109() {
        assertEquals("CIX", RomanNumeralConverter.intToRomanNumeral(109));
    }

    @Test
    void convert150() {
        assertEquals("CL", RomanNumeralConverter.intToRomanNumeral(150));
    }

    @Test
    void convert155() {
        assertEquals("CLV", RomanNumeralConverter.intToRomanNumeral(155));
    }

    @Test
    void convert145() {
        assertEquals("CXLV", RomanNumeralConverter.intToRomanNumeral(145));
    }

    @Test
    void convert144() {
        assertEquals("CXLIV", RomanNumeralConverter.intToRomanNumeral(144));
    }

    @Test
    void convert2701() {
        assertEquals("MMDCCI", RomanNumeralConverter.intToRomanNumeral(2701));
    }
}
