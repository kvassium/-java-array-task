package com.epam.array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.epam.array.entity.NumberArray;
import com.epam.array.service.ArraySearchService;
import com.epam.array.service.impl.ArraySearchServiceImpl;
import java.util.Optional;
import org.junit.jupiter.api.Test;

/**
 * Tests for ArraySearchService.
 */
class ArraySearchServiceTest {

    private static final int[] TEST_ARRAY = {5, 2, 8, 1, 9, 3};
    private static final int EXPECTED_MIN = 1;
    private static final int EXPECTED_MAX = 9;

    private final ArraySearchService searchService = new ArraySearchServiceImpl();

    @Test
    void testFindMin() {
        // given
        NumberArray numberArray = new NumberArray(TEST_ARRAY);

        // when
        Optional<Integer> result = searchService.findMin(numberArray);

        // then
        assertTrue(result.isPresent());
        assertEquals(EXPECTED_MIN, result.get());
    }

    @Test
    void testFindMax() {
        // given
        NumberArray numberArray = new NumberArray(TEST_ARRAY);

        // when
        Optional<Integer> result = searchService.findMax(numberArray);

        // then
        assertTrue(result.isPresent());
        assertEquals(EXPECTED_MAX, result.get());
    }

    @Test
    void testFindMinEmptyArray() {
        // given
        NumberArray emptyArray = new NumberArray(new int[]{});

        // when
        Optional<Integer> result = searchService.findMin(emptyArray);

        // then
        assertFalse(result.isPresent());
    }

    @Test
    void testFindMaxEmptyArray() {
        // given
        NumberArray emptyArray = new NumberArray(new int[]{});

        // when
        Optional<Integer> result = searchService.findMax(emptyArray);

        // then
        assertFalse(result.isPresent());
    }

    @Test
    void testFindMinSingleElement() {
        // given
        NumberArray singleElementArray = new NumberArray(new int[]{42});

        // when
        Optional<Integer> result = searchService.findMin(singleElementArray);

        // then
        assertTrue(result.isPresent());
        assertEquals(42, result.get());
    }

    @Test
    void testFindMaxSingleElement() {
        // given
        NumberArray singleElementArray = new NumberArray(new int[]{42});

        // when
        Optional<Integer> result = searchService.findMax(singleElementArray);

        // then
        assertTrue(result.isPresent());
        assertEquals(42, result.get());
    }

    @Test
    void testFindMinNegativeNumbers() {
        // given
        NumberArray negativeArray = new NumberArray(new int[]{-5, -10, -3, -1});

        // when
        Optional<Integer> result = searchService.findMin(negativeArray);

        // then
        assertTrue(result.isPresent());
        assertEquals(-10, result.get());
    }

    @Test
    void testFindMaxNegativeNumbers() {
        // given
        NumberArray negativeArray = new NumberArray(new int[]{-5, -10, -3, -1});

        // when
        Optional<Integer> result = searchService.findMax(negativeArray);

        // then
        assertTrue(result.isPresent());
        assertEquals(-1, result.get());
    }

    @Test
    void testFindMinWithDuplicates() {
        // given
        NumberArray duplicateArray = new NumberArray(new int[]{5, 2, 2, 8, 1, 1});

        // when
        Optional<Integer> result = searchService.findMin(duplicateArray);

        // then
        assertTrue(result.isPresent());
        assertEquals(1, result.get());
    }

    @Test
    void testFindMaxWithDuplicates() {
        // given
        NumberArray duplicateArray = new NumberArray(new int[]{5, 8, 8, 2, 1});

        // when
        Optional<Integer> result = searchService.findMax(duplicateArray);

        // then
        assertTrue(result.isPresent());
        assertEquals(8, result.get());
    }
}
