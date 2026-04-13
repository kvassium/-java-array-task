package com.epam.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.epam.array.entity.NumberArray;
import org.junit.jupiter.api.Test;

/**
 * Tests for NumberArray class.
 */
class NumberArrayTest {

    private static final int[] TEST_ARRAY = {1, 2, 3, 4, 5};
    private static final int[] ANOTHER_ARRAY = {5, 4, 3, 2, 1};

    @Test
    void testConstructorAndGetElements() {
        // given
        int[] elements = TEST_ARRAY;

        // when
        NumberArray numberArray = new NumberArray(elements);

        // then
        assertNotNull(numberArray);
        assertArrayEquals(elements, numberArray.getElements());
    }

    @Test
    void testSetElements() {
        // given
        NumberArray numberArray = new NumberArray(TEST_ARRAY);
        int[] newElements = ANOTHER_ARRAY;

        // when
        numberArray.setElements(newElements);

        // then
        assertArrayEquals(newElements, numberArray.getElements());
    }

    @Test
    void testLength() {
        // given
        NumberArray numberArray = new NumberArray(TEST_ARRAY);

        // when
        int length = numberArray.length();

        // then
        assertEquals(TEST_ARRAY.length, length);
    }

    @Test
    void testEqualsSameObject() {
        // given
        NumberArray numberArray = new NumberArray(TEST_ARRAY);

        // when & then
        assertEquals(numberArray, numberArray);
    }

    @Test
    void testEqualsEqualObjects() {
        // given
        NumberArray array1 = new NumberArray(TEST_ARRAY);
        NumberArray array2 = new NumberArray(TEST_ARRAY);

        // when & then
        assertEquals(array1, array2);
    }

    @Test
    void testNotEqualsDifferentObjects() {
        // given
        NumberArray array1 = new NumberArray(TEST_ARRAY);
        NumberArray array2 = new NumberArray(ANOTHER_ARRAY);

        // when & then
        assertNotEquals(array1, array2);
    }

    @Test
    void testNotEqualsNull() {
        // given
        NumberArray numberArray = new NumberArray(TEST_ARRAY);

        // when & then
        assertNotEquals(null, numberArray);
    }

    @Test
    void testNotEqualsDifferentClass() {
        // given
        NumberArray numberArray = new NumberArray(TEST_ARRAY);

        // when & then
        assertNotEquals("not an array", numberArray);
    }

    @Test
    void testHashCodeEqualObjects() {
        // given
        NumberArray array1 = new NumberArray(TEST_ARRAY);
        NumberArray array2 = new NumberArray(TEST_ARRAY);

        // when & then
        assertEquals(array1.hashCode(), array2.hashCode());
    }

    @Test
    void testToString() {
        // given
        NumberArray numberArray = new NumberArray(TEST_ARRAY);

        // when
        String result = numberArray.toString();

        // then
        assertNotNull(result);
        assertEquals("NumberArray{elements=[1, 2, 3, 4, 5]}", result);
    }

    @Test
    void testDefensiveCopyOnGetElements() {
        // given
        NumberArray numberArray = new NumberArray(TEST_ARRAY);
        int[] returnedElements = numberArray.getElements();

        // when
        returnedElements[0] = 999;

        // then
        assertEquals(1, numberArray.getElements()[0]);
    }

    @Test
    void testDefensiveCopyOnSetElements() {
        // given
        int[] original = {1, 2, 3};
        NumberArray numberArray = new NumberArray(original);

        // when
        original[0] = 999;

        // then
        assertEquals(1, numberArray.getElements()[0]);
    }
}
