package com.epam.array.service;

import com.epam.array.entity.NumberArray;
import java.util.Optional;

/**
 * Service interface for searching operations in array.
 */
public interface ArraySearchService {

    /**
     * Finds the minimum value in the array.
     *
     * @param numberArray the array to search
     * @return Optional containing min value or empty if array is empty
     */
    Optional<Integer> findMin(NumberArray numberArray);

    /**
     * Finds the maximum value in the array.
     *
     * @param numberArray the array to search
     * @return Optional containing max value or empty if array is empty
     */
    Optional<Integer> findMax(NumberArray numberArray);
}
