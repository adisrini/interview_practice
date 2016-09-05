package ch1.arrays.implementations.arraylist;

public class ArrayList<T> {

    private int size;
    private Object[] elements;

    private static final int DEFAULT_CAPACITY = 100;
    private static final int SIZING_FACTOR = 2;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        elements = new Object[capacity];
        size = 0;
    }

    public void add(T element) {
        if(size == elements.length) {
            expand();
        }
        elements[size++] = (Object) element;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) elements[index];
    }

    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    public int size() {
        return size;
    }

    private void expand() {
        Object[] newArray = new Object[size * SIZING_FACTOR];
        for (int i = 0; i < size; i++) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }

}
