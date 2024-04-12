public interface MyList<T> extends Iterable<T> {
    void add(T item);
    void add(int index, T item);
    void addFirst(T item);
    T get(int index);
    void remove(int index);
    void clear();
    int size();
}