package com.epam.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.epam.array.entity.NumberArray;
import com.epam.array.service.ArraySortService;
import com.epam.array.service.impl.ArraySortServiceImpl;
import org.junit.jupiter.api.Test;

/**
 * Tests for ArraySortService.
 */
class ArraySortServiceTest {

    private static final int[] UNSORTED_ARRAY = {64, 34, 25, 12, 22, 11, 90};
    private static final int[] SORTED_ARRAY = {11, 12, 22, 25, 34, 64, 90};
    private static final int[] SINGLE_ELEMENT = {42};
    private static final int[] EMPTY_ARRAY = {};
    private static final int[] ALREADY_SORTED = {1, 2, 3, 4, 5};
    private static final int[] REVERSE_SORTED = {5, 4, 3, 2, 1};

    private final ArraySortService sortService = new ArraySortServiceImpl();

    @Test
    void testBubbleSort() {
        // given
        NumberArray numberArray = new NumberArray(UNSORTED_ARRAY.clone());

        // when
        sortService.bubbleSort(numberArray);

        // then
        assertArrayEquals(SORTED_ARRAY, numberArray.getElements());
    }

    @Test
    void testQuickSort() {
        // given
        NumberArray numberArray = new NumberArray(UNSORTED_ARRAY.clone());

        // when
        sortService.quickSort(numberArray);

        // then
        assertArrayEquals(SORTED_ARRAY, numberArray.getElements());
    }

    @Test
    void testBubbleSortEmptyArray() {
        // given
        NumberArray emptyArray = new NumberArray(EMPTY_ARRAY.clone());

        // when
        sortService.bubbleSort(emptyArray);

        // then
        assertArrayEquals(EMPTY_ARRAY, emptyArray.getElements());
    }

    @Test
    void testQuickSortEmptyArray() {
        // given
        NumberArray emptyArray = new NumberArray(EMPTY_ARRAY.clone());

        // when
        sortService.quickSort(emptyArray);

        // then
        assertArrayEquals(EMPTY_ARRAY, emptyArray.getElements());
    }

    @Test
    void testBubbleSortSingleElement() {
        // given
        NumberArray singleElementArray = new NumberArray(SINGLE_ELEMENT.clone());

        // when
        sortService.bubbleSort(singleElementArray);

        // then
        assertArrayEquals(SINGLE_ELEMENT, singleElementArray.getElements());
    }

    @Test
    void testQuickSortSingleElement() {
        // given
        NumberArray singleElementArray = new NumberArray(SINGLE_ELEMENT.clone());

        // when
        sortService.quickSort(singleElementArray);

        // then
        assertArrayEquals(SINGLE_ELEMENT, singleElementArray.getElements());
    }

    @Test
    void testBubbleSortAlreadySorted() {
        // given
        NumberArray sortedArray = new NumberArray(ALREADY_SORTED.clone());

        // when
        sortService.bubbleSort(sortedArray);

        // then
        assertArrayEquals(ALREADY_SORTED, sortedArray.getElements());
    }

    @Test
    void testQuickSortAlreadySorted() {
        // given
        NumberArray sortedArray = new NumberArray(ALREADY_SORTED.clone());

        // when
        sortService.quickSort(sortedArray);

        // then
        assertArrayEquals(ALREADY_SORTED, sortedArray.getElements());
    }

    @Test
    void testBubbleSortReverseSorted() {
        // given
        NumberArray reverseArray = new NumberArray(REVERSE_SORTED.clone());

        // when
        sortService.bubbleSort(reverseArray);

        // then
        assertArrayEquals(ALREADY_SORTED, reverseArray.getElements());
    }

    @Test
    void testQuickSortReverseSorted() {
        // given
        NumberArray reverseArray = new NumberArray(REVERSE_SORTED.clone());

        // when
        sortService.quickSort(reverseArray);

        // then
        assertArrayEquals(ALREADY_SORTED, reverseArray.getElements());
    }

    @Test
    void testBubbleSortWithDuplicates() {
        // given
        int[] withDuplicates = {3, 1, 4, 1, 5, 9, 2, 6};
        int[] expectedSorted = {1, 1, 2, 3, 4, 5, 6, 9};
        NumberArray numberArray = new NumberArray(withDuplicates.clone());

        // when
        sortService.bubbleSort(numberArray);

        // then
        assertArrayEquals(expectedSorted, numberArray.getElements());
    }

    @Test
    void testQuickSortWithDuplicates() {
        // given
        int[] withDuplicates = {3, 1, 4, 1, 5, 9, 2, 6};
        int[] expectedSorted = {1, 1, 2, 3, 4, 5, 6, 9};
        NumberArray numberArray = new NumberArray(withDuplicates.clone());

        // when
        sortService.quickSort(numberArray);

        // then
        assertArrayEquals(expectedSorted, numberArray.getElements());
    }

    @Test
    void testBubbleSortNegativeNumbers() {
        // given
        int[] negativeNumbers = {-5, 3, -10, 0, 8, -2};
        int[] expectedSorted = {-10, -5, -2, 0, 3, 8};
        NumberArray numberArray = new NumberArray(negativeNumbers.clone());

        // when
        sortService.bubbleSort(numberArray);

        // then
        assertArrayEquals(expectedSorted, numberArray.getElements());
    }

    @Test
    void testQuickSortNegativeNumbers() {
        // given
        int[] negativeNumbers = {-5, 3, -10, 0, 8, -2};
        int[] expectedSorted = {-10, -5, -2, 0, 3, 8};
        NumberArray numberArray = new NumberArray(negativeNumbers.clone());

        // when
        sortService.quickSort(numberArray);

        // then
        assertArrayEquals(expectedSorted, numberArray.getElements());
    }
}
