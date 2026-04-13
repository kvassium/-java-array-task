package com.epam.array.factory;

import com.epam.array.entity.NumberArray;
import java.util.List;

/**
 * Implementation of NumberArrayFactory.
 */
public class NumberArrayFactoryImpl implements NumberArrayFactory {

    @Override
    public NumberArray createArray(int[] elements) {
        return new NumberArray(elements);
    }

    @Override
    public NumberArray createArray(List<Integer> elements) {
        int[] array = new int[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            array[i] = elements.get(i);
        }
        return new NumberArray(array);
    }
}
