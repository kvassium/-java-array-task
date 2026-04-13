package com.epam.array;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.epam.array.validation.ArrayDataValidator;
import org.junit.jupiter.api.Test;

/**
 * Tests for ArrayDataValidator.
 */
class ArrayDataValidatorTest {

    private final ArrayDataValidator validator = new ArrayDataValidator();

    @Test
    void testIsValidLineWithSemicolons() {
        // given
        String line = "1; 2; 3";

        // when & then
        assertTrue(validator.isValidLine(line));
    }

    @Test
    void testIsValidLineWithCommas() {
        // given
        String line = "1, 2, 3";

        // when & then
        assertTrue(validator.isValidLine(line));
    }

    @Test
    void testIsValidLineWithSpaces() {
        // given
        String line = "1 2 3";

        // when & then
        assertTrue(validator.isValidLine(line));
    }

    @Test
    void testIsValidLineWithDashes() {
        // given
        String line = "1- 2 - 3";

        // when & then
        assertTrue(validator.isValidLine(line));
    }

    @Test
    void testIsValidLineWithNegativeNumbers() {
        // given
        String line = "-5; -10; -3";

        // when & then
        assertTrue(validator.isValidLine(line));
    }

    @Test
    void testIsValidLineEmpty() {
        // given
        String line = "";

        // when & then
        assertFalse(validator.isValidLine(line));
    }

    @Test
    void testIsValidLineNull() {
        // given
        String line = null;

        // when & then
        assertFalse(validator.isValidLine(line));
    }

    @Test
    void testIsValidLineWithInvalidCharacters() {
        // given
        String line = "1y1 21 32";

        // when & then
        assertFalse(validator.isValidLine(line));
    }

    @Test
    void testCanParseAsIntArrayValid() {
        // given
        String line = "1; 2; 3";

        // when & then
        assertTrue(validator.canParseAsIntArray(line));
    }

    @Test
    void testCanParseAsIntArrayWithCommas() {
        // given
        String line = "1, 2, 3, 4";

        // when & then
        assertTrue(validator.canParseAsIntArray(line));
    }

    @Test
    void testCanParseAsIntArrayWithSpaces() {
        // given
        String line = "5 10 15";

        // when & then
        assertTrue(validator.canParseAsIntArray(line));
    }

    @Test
    void testCanParseAsIntArrayWithNegativeNumbers() {
        // given
        String line = "-5; -10; -15";

        // when & then
        assertTrue(validator.canParseAsIntArray(line));
    }

    @Test
    void testCanParseAsIntArrayEmpty() {
        // given
        String line = "";

        // when & then
        assertFalse(validator.canParseAsIntArray(line));
    }

    @Test
    void testCanParseAsIntArrayWithInvalidCharacters() {
        // given
        String line = "1, 2, x3, 6..5, 77";

        // when & then
        assertFalse(validator.canParseAsIntArray(line));
    }

    @Test
    void testCanParseAsIntArrayWithLetters() {
        // given
        String line = "1y1 21 32";

        // when & then
        assertFalse(validator.canParseAsIntArray(line));
    }

    @Test
    void testCanParseAsIntArrayWithDoubleDots() {
        // given
        String line = "6..5";

        // when & then
        assertFalse(validator.canParseAsIntArray(line));
    }

    @Test
    void testCanParseAsIntArraySingleNumber() {
        // given
        String line = "42";

        // when & then
        assertTrue(validator.canParseAsIntArray(line));
    }

    @Test
    void testCanParseAsIntArrayMixedDelimiters() {
        // given
        String line = "1; 2, 3 4";

        // when & then
        assertTrue(validator.canParseAsIntArray(line));
    }
}
