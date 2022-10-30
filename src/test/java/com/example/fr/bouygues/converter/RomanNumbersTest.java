package com.example.fr.bouygues.converter;

import com.example.fr.bouygues.converter.roman.service.RomanToNumericConverter;
import com.example.fr.bouygues.converter.roman.service.impl.RomanToNumericConverterImpl;
import com.example.fr.bouygues.converter.roman.validation.RomanFormatValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanNumbersTest {

    private final RomanToNumericConverter romanToNumericConverter = new RomanToNumericConverterImpl();

    private final RomanFormatValidator validator = new RomanFormatValidator();

    @Test
    public void test() {

        // empty value
        Assertions.assertFalse(validator.isValid("", null), "Value is empty"); // should throw exception

        // null value
        Assertions.assertFalse(validator.isValid("", null), "Value is null"); // should be 10

        // single roman symbol
        testRomanNumber("X",  10);

        // ascendant only
        testRomanNumber("LXXXVI", 86);

        // subtractions as first symbol
        testRomanNumber("XCVIII", 98);

        // various subtractions positions
        testRomanNumber("DCCXCIX", 799);
        testRomanNumber("MMCDLXXV", 2475);

        // wrong format/pattern
        Assertions.assertFalse(validator.isValid("XXXXXXXCDLXXV", null));

        // wrong format/available content
        Assertions.assertFalse(validator.isValid("XPNCJHVDHCXXCDLXXV", null));


    }

    private void testRomanNumber(String romanNumber, int expectedNumericValue) {
        Assertions.assertTrue(validator.isValid(romanNumber, null), "Value is invalid");
        Assertions.assertEquals(expectedNumericValue, romanToNumericConverter.romanToNumeric(romanNumber), "Bad format");
    }


}
