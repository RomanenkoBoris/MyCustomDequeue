public class CustomDequeueImplementation<T> implements CustomDequeue<T> {
    private T[] source;
    private int size = 0;
    private int firstElementIndex = 0;
    private static final int initialCapacity = 4;

    public CustomDequeueImplementation() {
        source = (T[]) new Object[initialCapacity];
    }


    @Override
    public void addFirst(T t) {
        if (size() == source.length) {
            increaseCapacity();
        }
        if (size() == 0) {
            firstElementIndex = 0;
            source[firstElementIndex] = t;
            size++;
            return;
        }
        firstElementIndex = (firstElementIndex - 1 + source.length) % source.length;
        source[firstElementIndex] = t;
        size++;
    }

    @Override
    public T getFirst() throws IndexOutOfBoundsException {
        throwIOOBException();
        return source[firstElementIndex];
    }

    @Override
    public T removeFirst() throws IndexOutOfBoundsException {
        throwIOOBException();
        T firstElement = source[firstElementIndex];
        firstElementIndex = (firstElementIndex + 1) % source.length;
        size--;
        return firstElement;
    }

    @Override
    public void addLast(T t) {
        if (size() == source.length)
            increaseCapacity();
        source[(firstElementIndex + size()) % source.length] = t;
        size++;

    }

    @Override
    public T getLast() throws IndexOutOfBoundsException {
        throwIOOBException();
        return source[(firstElementIndex + size() - 1) % source.length];
    }

    @Override
    public T removeLast() throws IndexOutOfBoundsException {
        throwIOOBException();
        return source[(firstElementIndex + size-- - 1) % source.length];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size(); i++) {
            stringBuilder.append(source[(firstElementIndex + i) % source.length]);
            if (i != size() - 1)
                stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private void increaseCapacity() {
        T[] tmp = (T[]) new Object[source.length * 2];
        for (int i = 0; i < size(); i++) {
            tmp[i] = source[(firstElementIndex + i) % source.length];
        }
        source = tmp;
        firstElementIndex = 0;
    }

    private void throwIOOBException() {
        if (size() == 0) {
            firstElementIndex = 0;
            throw new IndexOutOfBoundsException("There are no elements in the dequeue");
        }
    }

}
