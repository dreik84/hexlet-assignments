package exercise;

import java.util.Arrays;

class SafetyList {
    // BEGIN
    private static final int DEFAULT_CAPACITY = 10;
    private int[] elementData;
    private int size;

    public SafetyList() {
        this.elementData = new int[DEFAULT_CAPACITY];
    }

    public synchronized void add(int num) {
        if (size == elementData.length) {
            elementData = grow();
        }

        elementData[size] = num;
        size++;
    }

    private int[] grow() {
        return elementData = Arrays.copyOf(elementData, elementData.length * 2);
    }

    public int get(int index) {
        return elementData[index];
    }

    public int getSize() {
        return size;
    }
    // END
}
