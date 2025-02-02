package org.numerals.RomanNumerals.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralConverterTests {
    @Test
    void negative() {
        assertEquals("", RomanNumeralConverter.intToRomanNumeral(-1));
    }

    @Test
    void zero() {
        assertEquals("", RomanNumeralConverter.intToRomanNumeral(0));
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
}
