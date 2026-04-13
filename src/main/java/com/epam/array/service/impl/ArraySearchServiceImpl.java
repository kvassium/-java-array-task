package com.epam.array.service.impl;

import com.epam.array.entity.NumberArray;
import com.epam.array.service.ArraySearchService;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Implementation of ArraySearchService.
 */
public class ArraySearchServiceImpl implements ArraySearchService {

    private static final Logger LOGGER = LogManager.getLogger(ArraySearchServiceImpl.class);

    @Override
    public Optional<Integer> findMin(NumberArray numberArray) {
        LOGGER.info("Finding minimum value in array");
        int[] elements = numberArray.getElements();
        if (elements.length == 0) {
            LOGGER.warn("Array is empty, cannot find minimum");
            return Optional.empty();
        }
        int min = elements[0];
        for (int element : elements) {
            if (element < min) {
                min = element;
            }
        }
        LOGGER.info("Minimum value found: {}", min);
        return Optional.of(min);
    }

    @Override
    public Optional<Integer> findMax(NumberArray numberArray) {
        LOGGER.info("Finding maximum value in array");
        int[] elements = numberArray.getElements();
        if (elements.length == 0) {
            LOGGER.warn("Array is empty, cannot find maximum");
            return Optional.empty();
        }
        int max = elements[0];
        for (int element : elements) {
            if (element > max) {
                max = element;
            }
        }
        LOGGER.info("Maximum value found: {}", max);
        return Optional.of(max);
    }
}
