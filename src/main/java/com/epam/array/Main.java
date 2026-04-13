package com.epam.array;

import com.epam.array.entity.NumberArray;
import com.epam.array.exception.ArrayValidationException;
import com.epam.array.factory.NumberArrayBuilder;
import com.epam.array.factory.NumberArrayFactory;
import com.epam.array.factory.NumberArrayFactoryImpl;
import com.epam.array.reader.ArrayFileReader;
import com.epam.array.service.ArrayCalculationService;
import com.epam.array.service.ArraySearchService;
import com.epam.array.service.ArraySortService;
import com.epam.array.service.impl.ArrayCalculationServiceImpl;
import com.epam.array.service.impl.ArraySearchServiceImpl;
import com.epam.array.service.impl.ArraySortServiceImpl;
import com.epam.array.validation.ArrayDataValidator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main application class.
 */
public final class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final String DATA_FILE_PATH = "data/array_data.txt";

    private Main() {
        // Utility class
    }

    /**
     * Main entry point.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        LOGGER.info("Starting Array Task Application");

        // Initialize services
        ArraySearchService searchService = new ArraySearchServiceImpl();
        ArrayCalculationService calculationService = new ArrayCalculationServiceImpl();
        ArraySortService sortService = new ArraySortServiceImpl();

        // Initialize factory and builder
        NumberArrayFactory factory = new NumberArrayFactoryImpl();
        NumberArrayBuilder builder = new NumberArrayBuilder();

        // Create array using builder
        NumberArray arrayFromBuilder = builder
                .add(5)
                .add(2)
                .add(8)
                .add(1)
                .add(9)
                .build();
        LOGGER.info("Array created with builder: {}", arrayFromBuilder);

        // Create array using factory
        int[] elements = {64, 34, 25, 12, 22, 11, 90};
        NumberArray arrayFromFactory = factory.createArray(elements);
        LOGGER.info("Array created with factory: {}", arrayFromFactory);

        // Demonstrate search service
        demonstrateSearchService(searchService, arrayFromFactory);

        // Demonstrate calculation service
        demonstrateCalculationService(calculationService, arrayFromFactory);

        // Demonstrate sort service
        demonstrateSortService(sortService, arrayFromFactory);

        // Read arrays from file
        readArraysFromFile(factory);

        LOGGER.info("Array Task Application completed");
    }

    /**
     * Demonstrates search service functionality.
     *
     * @param searchService the search service
     * @param numberArray   the array to search
     */
    private static void demonstrateSearchService(
            ArraySearchService searchService,
            NumberArray numberArray
    ) {
        LOGGER.info("=== Search Service Demo ===");
        Optional<Integer> min = searchService.findMin(numberArray);
        Optional<Integer> max = searchService.findMax(numberArray);
        min.ifPresent(value -> LOGGER.info("Minimum value: {}", value));
        max.ifPresent(value -> LOGGER.info("Maximum value: {}", value));
    }

    /**
     * Demonstrates calculation service functionality.
     *
     * @param calculationService the calculation service
     * @param numberArray        the array to calculate
     */
    private static void demonstrateCalculationService(
            ArrayCalculationService calculationService,
            NumberArray numberArray
    ) {
        LOGGER.info("=== Calculation Service Demo ===");
        OptionalInt sum = calculationService.calculateSum(numberArray);
        OptionalDouble average = calculationService.calculateAverage(numberArray);
        sum.ifPresent(value -> LOGGER.info("Sum: {}", value));
        average.ifPresent(value -> LOGGER.info("Average: {}", value));
    }

    /**
     * Demonstrates sort service functionality.
     *
     * @param sortService the sort service
     * @param numberArray the array to sort
     */
    private static void demonstrateSortService(
            ArraySortService sortService,
            NumberArray numberArray
    ) {
        LOGGER.info("=== Sort Service Demo ===");
        NumberArray bubbleSortArray = new NumberArray(numberArray.getElements());
        sortService.bubbleSort(bubbleSortArray);
        LOGGER.info("After bubble sort: {}", bubbleSortArray);

        NumberArray quickSortArray = new NumberArray(numberArray.getElements());
        sortService.quickSort(quickSortArray);
        LOGGER.info("After quick sort: {}", quickSortArray);
    }

    /**
     * Reads arrays from file and logs them.
     *
     * @param factory the factory to create arrays
     */
    private static void readArraysFromFile(NumberArrayFactory factory) {
        LOGGER.info("=== Reading Arrays from File ===");
        ArrayDataValidator validator = new ArrayDataValidator();
        ArrayFileReader reader = new ArrayFileReader(validator);
        try {
            List<int[]> arrays = reader.readArraysFromFile(DATA_FILE_PATH);
            for (int i = 0; i < arrays.size(); i++) {
                NumberArray numberArray = factory.createArray(arrays.get(i));
                LOGGER.info("Array {} from file: {}", i + 1, numberArray);
            }
        } catch (ArrayValidationException exception) {
            LOGGER.error("Error reading arrays from file", exception);
        }
    }
}
