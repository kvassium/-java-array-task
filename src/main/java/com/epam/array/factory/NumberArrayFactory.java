package com.epam.array.factory;

import com.epam.array.entity.NumberArray;

/**
 * Factory for creating NumberArray instances.
 */
public interface NumberArrayFactory {

    /**
     * Creates a NumberArray from an int array.
     *
     * @param elements the array elements
     * @return a new NumberArray instance
     */
    NumberArray createArray(int[] elements);

    /**
     * Creates a NumberArray from a list of integers.
     *
     * @param elements the list of integers
     * @return a new NumberArray instance
     */
    NumberArray createArray(java.util.List<Integer> elements);
}
