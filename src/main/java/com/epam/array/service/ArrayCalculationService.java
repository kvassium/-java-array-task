package com.epam.array.service;

import com.epam.array.entity.NumberArray;
import java.util.OptionalDouble;
import java.util.OptionalInt;

/**
 * Service interface for calculation operations in array.
 */
public interface ArrayCalculationService {

    /**
     * Calculates the sum of all elements in the array.
     *
     * @param numberArray the array to calculate sum
     * @return Optional containing sum or empty if array is empty
     */
    OptionalInt calculateSum(NumberArray numberArray);

    /**
     * Calculates the average value of array elements.
     *
     * @param numberArray the array to calculate average
     * @return Optional containing average or empty if array is empty
     */
    OptionalDouble calculateAverage(NumberArray numberArray);
}
