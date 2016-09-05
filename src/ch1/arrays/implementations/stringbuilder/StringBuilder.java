package ch1.arrays.implementations.stringbuilder;

public class StringBuilder {
    
    private int size;
    private String[] elements;

    private static final int DEFAULT_CAPACITY = 100;
    private static final int SIZING_FACTOR = 2;

    public StringBuilder() {
        this(DEFAULT_CAPACITY);
    }

    public StringBuilder(int capacity) {
        elements = new String[capacity];
        size = 0;
    }

    public void append(String element) {
        if(size == elements.length) {
            expand();
        }
        elements[size++] = element;
    }
    
    public String toString() {
        String ret = "";
        for(String s : elements) {
            if(s != null) {
                ret += s;
            }
        }
        return ret;
    }

    private void expand() {
        String[] newArray = new String[size * SIZING_FACTOR];
        for (int i = 0; i < size; i++) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }

}
