package org.numerals.RomanNumerals.service;

/**
 * Class to convert integers to roman numerals
 * *******************************************
 * breaks a number down into four terms, converts each term
 * into a roman numeral and concatenates the results
 * to form the final roman representation
 * ex: 1754
 * 1754 = 1000 + 700 + 50 + 4
 * 1000 = M
 * 700 = DCC
 * 50 = L
 * 4 = IV
 * 1754 = MDCCLIV
 */
public final class RomanNumeralConverter {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 3999;
    private static final int I = 1;
    private static final int X = 10;
    private static final int C = 100;
    private static final int M = 1000;

    private RomanNumeralConverter() {
        throw new UnsupportedOperationException("RomanNumeralConverter is a service class, instantiation not allowed.");
    }

    public static String intToRomanNumeral(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("Value must be an integer between 1 and 3999");
        }

        return convertToRoman(value, M);
    }

    /**
     * converts a number to a roman numeral
     *
     * @param value            - integer value to convert
     * @param baseValueDivisor - the 'base' value of the term currently being converted;
     *                         the algorithm converts each term in descending order and will
     *                         operate recursively until reaching the smallest possible
     *                         term value of 1 (1000s -> 100s -> 10s -> 1s)
     * @return - roman numeral representation of the input value
     */
    private static String convertToRoman(int value, int baseValueDivisor) {
        int term = value / baseValueDivisor;
        int remainder = value % baseValueDivisor;

        int baseInteger = getValueBaseInteger(value);
        String numeralValue = buildTermNumeral(
            term,
            getBaseNumeral(baseInteger),
            getMedianNumeral(baseInteger),
            getUpperNumeral(baseInteger)
        );
        if (baseValueDivisor == 1) {
            return numeralValue;
        }

        return numeralValue + convertToRoman(remainder, baseValueDivisor / 10);
    }

    /**
     * uses the different numerals associated with the current term to construct the
     * final roman numeral representation
     * example: buildTermNumeral(7, "I", "V", "X") -> "VII"
     *
     * @param term          - the term currently being converted to a roman numeral
     * @param baseNumeral   - base numeral for the current term
     * @param medianNumeral - median numeral for the current term
     * @param upperNumeral  - the upper numeral for the current term
     * @return constructed roman numeral
     */
    private static String buildTermNumeral(int term, String baseNumeral, String medianNumeral, String upperNumeral) {
        return switch (term) {
            case 1 -> baseNumeral;
            case 2 -> baseNumeral + baseNumeral;
            case 3 -> baseNumeral + baseNumeral + baseNumeral;
            case 4 -> baseNumeral + medianNumeral;
            case 5 -> medianNumeral;
            case 6 -> medianNumeral + baseNumeral;
            case 7 -> medianNumeral + baseNumeral + baseNumeral;
            case 8 -> medianNumeral + baseNumeral + baseNumeral + baseNumeral;
            case 9 -> baseNumeral + upperNumeral;
            default -> "";
        };
    }

    /**
     * returns the numeral that represents the current operating term's base integer
     *
     * @param baseInteger - base integer for the term on which
     *                    the algorithm is currently operating
     * @return roman numeral representation of the base integer
     */
    private static String getBaseNumeral(int baseInteger) {
        return switch (baseInteger) {
            case I -> "I";
            case X -> "X";
            case C -> "C";
            case M -> "M";
            default -> throw new IllegalStateException("Unexpected value: " + baseInteger);
        };
    }

    /**
     * returns the 'median numeral' for a given base integer; the median numeral
     * represents the median single character numeral for a given term
     * EXAMPLE: getUpperNumeral(100) -> D (500)
     *
     * @param baseInteger - base integer for the term on which
     *                    the algorithm is currently operating
     * @return upper numeral of the current term
     */
    private static String getMedianNumeral(int baseInteger) {
        return switch (baseInteger) {
            case I -> "V";
            case X -> "L";
            case C -> "D";
            default -> "";
        };
    }

    /**
     * returns the 'upper numeral' for a given base integer; the upper numeral
     * represents the largest single character numeral represented in a term
     * EXAMPLE: getUpperNumeral(100) -> M (1000)
     *
     * @param baseInteger - base integer for the term on which
     *                    the algorithm is currently operating
     * @return upper numeral of the current term
     */
    private static String getUpperNumeral(int baseInteger) {
        return switch (baseInteger) {
            case I -> "X";
            case X -> "C";
            case C -> "M";
            default -> "";
        };
    }

    /**
     * Returns the 'base' integer value for the current operating term
     * (the smallest possible integer value that can be represented by
     * a single distinct roman numeral)
     * EXAMPLE: getValueBaseInteger(42) -> 10
     * EXAMPLE: getValueBaseInteger(157) -> 100
     *
     * @param value - value of the term currently being converted
     * @return base integer of the current term
     */
    private static Integer getValueBaseInteger(int value) {
        if (value < X) {
            return I;
        }

        if (value < C) {
            return X;
        }

        if (value < M) {
            return C;
        }

        return M;
    }
}
