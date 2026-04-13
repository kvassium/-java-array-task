package com.epam.array.reader;

import com.epam.array.exception.ArrayValidationException;
import com.epam.array.validation.ArrayDataValidator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Reader for array data from file.
 */
public class ArrayFileReader {

    private static final Logger LOGGER = LogManager.getLogger(ArrayFileReader.class);
    private static final String DELIMITER_REGEX = "[;,.\\s]+";

    private final ArrayDataValidator validator;

    /**
     * Constructs a new ArrayFileReader with the given validator.
     *
     * @param validator the validator to use
     */
    public ArrayFileReader(ArrayDataValidator validator) {
        this.validator = validator;
    }

    /**
     * Reads valid integer arrays from file.
     *
     * @param filePath the path to the file
     * @return list of integer arrays
     * @throws ArrayValidationException if file cannot be read
     */
    public List<int[]> readArraysFromFile(String filePath) throws ArrayValidationException {
        LOGGER.info("Reading arrays from file: {}", filePath);
        Path path = Paths.get(filePath);
        List<int[]> result = new ArrayList<>();
        try (Stream<String> lines = Files.lines(path)) {
            List<String> validLines = lines
                    .filter(validator::canParseAsIntArray)
                    .collect(Collectors.toList());
            for (String line : validLines) {
                int[] array = parseLineToArray(line);
                if (array.length > 0) {
                    result.add(array);
                }
            }
        } catch (IOException exception) {
            LOGGER.error("Failed to read file: {}", filePath, exception);
            throw new ArrayValidationException("Failed to read file: " + filePath, exception);
        }
        LOGGER.info("Successfully read {} valid arrays from file", result.size());
        return result;
    }

    /**
     * Parses a line into an integer array.
     *
     * @param line the line to parse
     * @return the integer array
     */
    private int[] parseLineToArray(String line) {
        LOGGER.debug("Parsing line: {}", line);
        String[] parts = line.split(DELIMITER_REGEX);
        List<Integer> numbers = new ArrayList<>();
        for (String part : parts) {
            String trimmed = part.trim();
            if (!trimmed.isEmpty()) {
                try {
                    numbers.add(Integer.parseInt(trimmed));
                } catch (NumberFormatException exception) {
                    LOGGER.warn("Skipping invalid number: {}", trimmed);
                }
            }
        }
        int[] result = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            result[i] = numbers.get(i);
        }
        return result;
    }
}
