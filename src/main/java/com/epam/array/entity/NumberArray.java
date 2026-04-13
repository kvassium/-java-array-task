package com.epam.array.entity;

import java.util.Arrays;

/**
 * Entity class wrapping an array of integers.
 */
public class NumberArray {

    private int[] elements;

    /**
     * Constructs a NumberArray with the given elements.
     *
     * @param elements the array elements
     */
    public NumberArray(int[] elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
    }

    /**
     * Returns a copy of the array elements.
     *
     * @return copy of elements array
     */
    public int[] getElements() {
        return Arrays.copyOf(elements, elements.length);
    }

    /**
     * Sets the array elements.
     *
     * @param elements the new array elements
     */
    public void setElements(int[] elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
    }

    /**
     * Returns the length of the array.
     *
     * @return array length
     */
    public int length() {
        return elements.length;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        NumberArray that = (NumberArray) object;
        return Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

    @Override
    public String toString() {
        return "NumberArray{"
                + "elements=" + Arrays.toString(elements)
                + '}';
    }
}
