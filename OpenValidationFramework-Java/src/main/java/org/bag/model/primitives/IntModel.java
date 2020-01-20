package org.bag.model.primitives;

import java.util.ArrayList;
import java.util.List;

public class IntModel {
    private Integer[] IntArray;
    private int[] ints;
    private int value;
    private List<Integer> intList = new ArrayList<>();

    public int[] getInts() {
        return ints;
    }

    public void setInts(int[] ints) {
        this.ints = ints;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Integer> getIntList() {
        return intList;
    }

    public void setIntList(List<Integer> intList) {
        this.intList = intList;
    }

    public Integer[] getIntArray() {
        return IntArray;
    }

    public void setIntArray(Integer[] intArray) {
        IntArray = intArray;
    }
}
