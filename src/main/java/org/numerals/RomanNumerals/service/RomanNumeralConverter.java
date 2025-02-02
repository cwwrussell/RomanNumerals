package org.numerals.RomanNumerals.service;

import java.util.Map;

import static java.util.Map.entry;

public final class RomanNumeralConverter {
    private static final Map<Integer, String> PRIMARY_NUMERALS = Map.ofEntries(
        entry(1, "I"),
        entry(10, "X"),
        entry(100, "C"),
        entry(1000, "M")
    );

    private static final Map<Integer, String> MEDIAN_NUMERALS = Map.ofEntries(
        entry(5, "V"),
        entry(50, "L"),
        entry(500, "D")
    );

    private RomanNumeralConverter() {
        throw new UnsupportedOperationException("RomanNumeralConverter is a service class, instantiation not allowed.");
    }

    public static String intToRomanNumeral(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value must be an integer between 1 and 3999");
        }

        if (PRIMARY_NUMERALS.containsKey(value)) {
            return PRIMARY_NUMERALS.get(value);
        }

        if (MEDIAN_NUMERALS.containsKey(value)) {
            return MEDIAN_NUMERALS.get(value);
        }

        return convertToNumeral(value);
    }

    private static String convertToNumeral(int value) {
        return "TODO";
    }
}
