package com.epam.array.service.impl;

import com.epam.array.entity.NumberArray;
import com.epam.array.service.ArraySortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Implementation of ArraySortService.
 */
public class ArraySortServiceImpl implements ArraySortService {

    private static final Logger LOGGER = LogManager.getLogger(ArraySortServiceImpl.class);

    @Override
    public void bubbleSort(NumberArray numberArray) {
        LOGGER.info("Starting bubble sort");
        int[] elements = numberArray.getElements();
        int length = elements.length;
        boolean swapped;
        for (int i = 0; i < length - 1; i++) {
            swapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (elements[j] > elements[j + 1]) {
                    int temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        numberArray.setElements(elements);
        LOGGER.info("Bubble sort completed");
    }

    @Override
    public void quickSort(NumberArray numberArray) {
        LOGGER.info("Starting quick sort");
        int[] elements = numberArray.getElements();
        if (elements.length > 0) {
            quickSortRecursive(elements, 0, elements.length - 1);
        }
        numberArray.setElements(elements);
        LOGGER.info("Quick sort completed");
    }

    /**
     * Recursive helper method for quick sort.
     *
     * @param arr  the array to sort
     * @param low  the starting index
     * @param high the ending index
     */
    private void quickSortRecursive(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSortRecursive(arr, low, partitionIndex - 1);
            quickSortRecursive(arr, partitionIndex + 1, high);
        }
    }

    /**
     * Partition method for quick sort.
     *
     * @param arr  the array
     * @param low  the starting index
     * @param high the ending index
     * @return the partition index
     */
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
