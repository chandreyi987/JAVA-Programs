import java.util.*;

public class CustomArrayList {
    private Object[] data;
    private int size = 0;
    private static final int INITIAL_CAPACITY = 10;

    public CustomArrayList() {
        data = new Object[INITIAL_CAPACITY];
    }

    public void add(Object element) {
        if (size == data.length) {
            grow();
        }
        data[size++] = element;
    }

    private void grow() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    public Object get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return data[index];
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Element at index 1: " + list.get(1));
        System.out.println("Size of list: " + list.size());
    }
}
