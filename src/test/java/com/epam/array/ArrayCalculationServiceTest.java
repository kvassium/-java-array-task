package com.epam.array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.epam.array.entity.NumberArray;
import com.epam.array.service.ArrayCalculationService;
import com.epam.array.service.impl.ArrayCalculationServiceImpl;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import org.junit.jupiter.api.Test;

/**
 * Tests for ArrayCalculationService.
 */
class ArrayCalculationServiceTest {

    private static final int[] TEST_ARRAY = {1, 2, 3, 4, 5};
    private static final int EXPECTED_SUM = 15;
    private static final double EXPECTED_AVERAGE = 3.0;

    private final ArrayCalculationService calculationService = new ArrayCalculationServiceImpl();

    @Test
    void testCalculateSum() {
        // given
        NumberArray numberArray = new NumberArray(TEST_ARRAY);

        // when
        OptionalInt result = calculationService.calculateSum(numberArray);

        // then
        assertTrue(result.isPresent());
        assertEquals(EXPECTED_SUM, result.getAsInt());
    }

    @Test
    void testCalculateAverage() {
        // given
        NumberArray numberArray = new NumberArray(TEST_ARRAY);

        // when
        OptionalDouble result = calculationService.calculateAverage(numberArray);

        // then
        assertTrue(result.isPresent());
        assertEquals(EXPECTED_AVERAGE, result.getAsDouble(), 0.001);
    }

    @Test
    void testCalculateSumEmptyArray() {
        // given
        NumberArray emptyArray = new NumberArray(new int[]{});

        // when
        OptionalInt result = calculationService.calculateSum(emptyArray);

        // then
        assertFalse(result.isPresent());
    }

    @Test
    void testCalculateAverageEmptyArray() {
        // given
        NumberArray emptyArray = new NumberArray(new int[]{});

        // when
        OptionalDouble result = calculationService.calculateAverage(emptyArray);

        // then
        assertFalse(result.isPresent());
    }

    @Test
    void testCalculateSumSingleElement() {
        // given
        NumberArray singleElementArray = new NumberArray(new int[]{42});

        // when
        OptionalInt result = calculationService.calculateSum(singleElementArray);

        // then
        assertTrue(result.isPresent());
        assertEquals(42, result.getAsInt());
    }

    @Test
    void testCalculateAverageSingleElement() {
        // given
        NumberArray singleElementArray = new NumberArray(new int[]{42});

        // when
        OptionalDouble result = calculationService.calculateAverage(singleElementArray);

        // then
        assertTrue(result.isPresent());
        assertEquals(42.0, result.getAsDouble(), 0.001);
    }

    @Test
    void testCalculateSumNegativeNumbers() {
        // given
        NumberArray negativeArray = new NumberArray(new int[]{-5, -10, -15});

        // when
        OptionalInt result = calculationService.calculateSum(negativeArray);

        // then
        assertTrue(result.isPresent());
        assertEquals(-30, result.getAsInt());
    }

    @Test
    void testCalculateAverageNegativeNumbers() {
        // given
        NumberArray negativeArray = new NumberArray(new int[]{-5, -10, -15});

        // when
        OptionalDouble result = calculationService.calculateAverage(negativeArray);

        // then
        assertTrue(result.isPresent());
        assertEquals(-10.0, result.getAsDouble(), 0.001);
    }

    @Test
    void testCalculateSumMixedNumbers() {
        // given
        NumberArray mixedArray = new NumberArray(new int[]{-5, 10, -3, 8});

        // when
        OptionalInt result = calculationService.calculateSum(mixedArray);

        // then
        assertTrue(result.isPresent());
        assertEquals(10, result.getAsInt());
    }

    @Test
    void testCalculateAverageMixedNumbers() {
        // given
        NumberArray mixedArray = new NumberArray(new int[]{-5, 10, -3, 8});

        // when
        OptionalDouble result = calculationService.calculateAverage(mixedArray);

        // then
        assertTrue(result.isPresent());
        assertEquals(2.5, result.getAsDouble(), 0.001);
    }

    @Test
    void testCalculateAverageWithDecimal() {
        // given
        NumberArray array = new NumberArray(new int[]{1, 2, 3});

        // when
        OptionalDouble result = calculationService.calculateAverage(array);

        // then
        assertTrue(result.isPresent());
        assertEquals(2.0, result.getAsDouble(), 0.001);
    }
}
