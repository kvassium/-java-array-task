package com.epam.array.service;

import com.epam.array.entity.NumberArray;

/**
 * Service interface for sorting operations in array.
 */
public interface ArraySortService {

    /**
     * Sorts array using bubble sort algorithm.
     *
     * @param numberArray the array to sort
     */
    void bubbleSort(NumberArray numberArray);

    /**
     * Sorts array using quick sort algorithm.
     *
     * @param numberArray the array to sort
     */
    void quickSort(NumberArray numberArray);
}
