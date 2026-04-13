package com.epam.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.epam.array.entity.NumberArray;
import com.epam.array.factory.NumberArrayBuilder;
import org.junit.jupiter.api.Test;

/**
 * Tests for NumberArrayBuilder.
 */
class NumberArrayBuilderTest {

    @Test
    void testBuildWithAdd() {
        // given
        NumberArrayBuilder builder = new NumberArrayBuilder();

        // when
        NumberArray result = builder
                .add(1)
                .add(2)
                .add(3)
                .build();

        // then
        assertNotNull(result);
        assertArrayEquals(new int[]{1, 2, 3}, result.getElements());
    }

    @Test
    void testBuildWithAddAll() {
        // given
        NumberArrayBuilder builder = new NumberArrayBuilder();
        int[] elements = {4, 5, 6};

        // when
        NumberArray result = builder
                .add(1)
                .addAll(elements)
                .build();

        // then
        assertNotNull(result);
        assertArrayEquals(new int[]{1, 4, 5, 6}, result.getElements());
    }

    @Test
    void testBuildEmpty() {
        // given
        NumberArrayBuilder builder = new NumberArrayBuilder();

        // when
        NumberArray result = builder.build();

        // then
        assertNotNull(result);
        assertArrayEquals(new int[]{}, result.getElements());
    }

    @Test
    void testReset() {
        // given
        NumberArrayBuilder builder = new NumberArrayBuilder();
        builder.add(1).add(2).add(3);

        // when
        NumberArray result = builder.reset().add(4).build();

        // then
        assertNotNull(result);
        assertArrayEquals(new int[]{4}, result.getElements());
    }

    @Test
    void testChaining() {
        // given
        NumberArrayBuilder builder = new NumberArrayBuilder();

        // when
        NumberArray result = builder
                .add(1)
                .add(2)
                .addAll(new int[]{3, 4})
                .add(5)
                .build();

        // then
        assertNotNull(result);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result.getElements());
    }

    @Test
    void testMultipleBuilds() {
        // given
        NumberArrayBuilder builder = new NumberArrayBuilder();

        // when
        NumberArray first = builder.add(1).add(2).build();
        NumberArray second = builder.reset().add(3).add(4).build();

        // then
        assertArrayEquals(new int[]{1, 2}, first.getElements());
        assertArrayEquals(new int[]{3, 4}, second.getElements());
    }

    @Test
    void testBuildWithNegativeNumbers() {
        // given
        NumberArrayBuilder builder = new NumberArrayBuilder();

        // when
        NumberArray result = builder
                .add(-5)
                .add(-10)
                .add(3)
                .build();

        // then
        assertNotNull(result);
        assertArrayEquals(new int[]{-5, -10, 3}, result.getElements());
    }
}
