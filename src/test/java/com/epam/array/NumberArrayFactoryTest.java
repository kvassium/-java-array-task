package com.epam.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.epam.array.entity.NumberArray;
import com.epam.array.factory.NumberArrayFactory;
import com.epam.array.factory.NumberArrayFactoryImpl;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Tests for NumberArrayFactory.
 */
class NumberArrayFactoryTest {

    private final NumberArrayFactory factory = new NumberArrayFactoryImpl();

    @Test
    void testCreateArrayFromIntArray() {
        // given
        int[] elements = {1, 2, 3, 4, 5};

        // when
        NumberArray result = factory.createArray(elements);

        // then
        assertNotNull(result);
        assertArrayEquals(elements, result.getElements());
    }

    @Test
    void testCreateArrayFromList() {
        // given
        List<Integer> elements = Arrays.asList(1, 2, 3, 4, 5);

        // when
        NumberArray result = factory.createArray(elements);

        // then
        assertNotNull(result);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result.getElements());
    }

    @Test
    void testCreateArrayEmptyIntArray() {
        // given
        int[] elements = {};

        // when
        NumberArray result = factory.createArray(elements);

        // then
        assertNotNull(result);
        assertArrayEquals(new int[]{}, result.getElements());
    }

    @Test
    void testCreateArrayEmptyList() {
        // given
        List<Integer> elements = Arrays.asList();

        // when
        NumberArray result = factory.createArray(elements);

        // then
        assertNotNull(result);
        assertArrayEquals(new int[]{}, result.getElements());
    }

    @Test
    void testCreateArraySingleElement() {
        // given
        int[] elements = {42};

        // when
        NumberArray result = factory.createArray(elements);

        // then
        assertNotNull(result);
        assertArrayEquals(new int[]{42}, result.getElements());
    }

    @Test
    void testCreateArrayNegativeNumbers() {
        // given
        int[] elements = {-5, -10, -3};

        // when
        NumberArray result = factory.createArray(elements);

        // then
        assertNotNull(result);
        assertArrayEquals(elements, result.getElements());
    }
}
