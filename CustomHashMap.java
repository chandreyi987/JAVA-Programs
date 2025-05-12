import java.util.*;

public class CustomHashMap {
    class Entry {
        Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 16;
    private Entry[] table;

    public CustomHashMap() {
        table = new Entry[capacity];
    }

    public void put(Object key, Object value) {
        int index = Math.abs(key.hashCode() % capacity);
        Entry newEntry = new Entry(key, value);

        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry current = table[index];
            Entry prev = null;
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                prev = current;
                current = current.next;
            }
            prev.next = newEntry;
        }
    }

    public Object get(Object key) {
        int index = Math.abs(key.hashCode() % capacity);
        Entry current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        System.out.println("Value for key 'Two': " + map.get("Two"));
    }
}
