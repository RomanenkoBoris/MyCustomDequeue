public interface CustomDequeue<T> {
    void addFirst(T t);

    T getFirst() throws IndexOutOfBoundsException;

    T removeFirst() throws IndexOutOfBoundsException;

    void addLast(T t);

    T getLast() throws IndexOutOfBoundsException;

    T removeLast() throws IndexOutOfBoundsException;

    int size();
}
