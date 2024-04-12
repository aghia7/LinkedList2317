import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] arr; // contiguous memory
    private int length;
    private final static int DEFAULT_CAPACITY = 5;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int initialCapacity) {
        arr = new Object[initialCapacity];
    }

    private void increaseCapacity() { // O(N)
        Object[] newArr = new Object[2 * arr.length];

        System.arraycopy(arr, 0, newArr, 0, arr.length);

        arr = newArr;
    }

    // Average O(1), Worst-Case O(N)
    @Override
    public void add(T item) {
        if (length >= arr.length){
            increaseCapacity();
        }

        arr[length++] = item;
    }

    // 1 2 3 4 5 6 7 0 0
    @Override
    public void add(int index, T item) {
        validateIndex(index, length + 1);

        if (length >= arr.length){
            increaseCapacity();
        }

        for (int i = length; i > index; i--) {
            arr[i] = arr[i - 1];
        }

        arr[index] = item;
        length++;
    }


    // Complexity O(N)
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    private static void validateIndex(int index, int limit) {
        if (index >= limit) {
            throw new IndexOutOfBoundsException("index out of range");
        }
    }

    // complexity O(1)
    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        validateIndex(index, length);

        return (T)arr[index];
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public void clear() {
        arr = new Object[DEFAULT_CAPACITY];
        length = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index;

            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public T next() {
                return get(index++);
            }
        };
    }
}
