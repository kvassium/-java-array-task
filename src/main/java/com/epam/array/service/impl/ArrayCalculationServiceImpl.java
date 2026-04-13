package com.epam.array.service.impl;

import com.epam.array.entity.NumberArray;
import com.epam.array.service.ArrayCalculationService;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Implementation of ArrayCalculationService.
 */
public class ArrayCalculationServiceImpl implements ArrayCalculationService {

    private static final Logger LOGGER = LogManager.getLogger(ArrayCalculationServiceImpl.class);

    @Override
    public OptionalInt calculateSum(NumberArray numberArray) {
        LOGGER.info("Calculating sum of array elements");
        int[] elements = numberArray.getElements();
        if (elements.length == 0) {
            LOGGER.warn("Array is empty, cannot calculate sum");
            return OptionalInt.empty();
        }
        int sum = 0;
        for (int element : elements) {
            sum += element;
        }
        LOGGER.info("Sum calculated: {}", sum);
        return OptionalInt.of(sum);
    }

    @Override
    public OptionalDouble calculateAverage(NumberArray numberArray) {
        LOGGER.info("Calculating average of array elements");
        int[] elements = numberArray.getElements();
        if (elements.length == 0) {
            LOGGER.warn("Array is empty, cannot calculate average");
            return OptionalDouble.empty();
        }
        int sum = 0;
        for (int element : elements) {
            sum += element;
        }
        double average = (double) sum / elements.length;
        LOGGER.info("Average calculated: {}", average);
        return OptionalDouble.of(average);
    }
}
