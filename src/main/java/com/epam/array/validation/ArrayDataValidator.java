package com.epam.array.validation;

import java.util.regex.Pattern;

/**
 * Validator for array data from file.
 */
public class ArrayDataValidator {

    private static final Pattern VALID_PATTERN = Pattern.compile(
            "^[\\d\\s;,.-]+$"
    );

    /**
     * Validates if the line contains only valid characters for array data.
     *
     * @param line the line to validate
     * @return true if valid, false otherwise
     */
    public boolean isValidLine(String line) {
        if (line == null || line.trim().isEmpty()) {
            return false;
        }
        return VALID_PATTERN.matcher(line).matches();
    }

    /**
     * Checks if the line can be parsed as array of integers.
     *
     * @param line the line to check
     * @return true if can be parsed, false otherwise
     */
    public boolean canParseAsIntArray(String line) {
        if (!isValidLine(line)) {
            return false;
        }
        String normalized = line.replaceAll("[;,.]", " ")
                .replaceAll("\\s+", " ")
                .trim();
        if (normalized.isEmpty()) {
            return false;
        }
        // Check for consecutive dots or other invalid patterns
        if (line.contains("..") || line.contains(",,") || line.contains(";;")) {
            return false;
        }
        String[] parts = normalized.split(" ");
        for (String part : parts) {
            if (!isValidInteger(part)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the string is a valid integer.
     *
     * @param value the string to check
     * @return true if valid integer, false otherwise
     */
    private boolean isValidInteger(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
