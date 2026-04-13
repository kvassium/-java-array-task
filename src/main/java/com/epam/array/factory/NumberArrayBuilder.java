package com.epam.array.factory;

import com.epam.array.entity.NumberArray;
import java.util.ArrayList;
import java.util.List;

/**
 * Builder for creating NumberArray instances.
 */
public class NumberArrayBuilder {

    private final List<Integer> elements;

    /**
     * Constructs a new NumberArrayBuilder.
     */
    public NumberArrayBuilder() {
        this.elements = new ArrayList<>();
    }

    /**
     * Adds an element to the builder.
     *
     * @param element the element to add
     * @return this builder
     */
    public NumberArrayBuilder add(int element) {
        elements.add(element);
        return this;
    }

    /**
     * Adds multiple elements to the builder.
     *
     * @param elements the elements to add
     * @return this builder
     */
    public NumberArrayBuilder addAll(int[] elements) {
        for (int element : elements) {
            this.elements.add(element);
        }
        return this;
    }

    /**
     * Builds and returns a NumberArray.
     *
     * @return a new NumberArray instance
     */
    public NumberArray build() {
        int[] array = new int[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            array[i] = elements.get(i);
        }
        return new NumberArray(array);
    }

    /**
     * Resets the builder to empty state.
     *
     * @return this builder
     */
    public NumberArrayBuilder reset() {
        elements.clear();
        return this;
    }
}
