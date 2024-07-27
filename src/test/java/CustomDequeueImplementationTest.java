import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomDequeueImplementationTest {
    CustomDequeueImplementation<String> stringDequeue;
    CustomDequeueImplementation<Integer> integerDequeue;

    @BeforeEach
    void setup() {
        stringDequeue = new CustomDequeueImplementation<>();
        stringDequeue.addFirst("one");
        stringDequeue.addFirst("two");
        integerDequeue = new CustomDequeueImplementation<>();
        integerDequeue.addFirst(1);
        integerDequeue.addFirst(2);
        integerDequeue.addFirst(3);
    }

    @Test
    void testAddFirstEmptyDequeue() {
        CustomDequeueImplementation<String> dequeue = new CustomDequeueImplementation<>();
        assertEquals(0, dequeue.size());
        dequeue.addFirst("one");
        assertEquals(1, dequeue.size());
        assertEquals("one", dequeue.getFirst());
        dequeue.addFirst("two");
        assertEquals(2, dequeue.size());
        assertEquals("two", dequeue.getFirst());
    }

    @Test
    void testAddFirstIncreaseCapacity() {
        assertEquals(3, integerDequeue.size());
        integerDequeue.addFirst(4);
        assertEquals(4, integerDequeue.size());
        assertEquals(4, integerDequeue.getFirst());
        integerDequeue.addFirst(5);
        assertEquals(5, integerDequeue.size());
        assertEquals(5, integerDequeue.getFirst());
    }

    @Test
    void testGetFirstIndexOutOfBoundsException() {
        CustomDequeueImplementation<Integer> dequeue = new CustomDequeueImplementation<>();
        IndexOutOfBoundsException ioobe = assertThrows(IndexOutOfBoundsException.class, () -> dequeue.getFirst());
        assertEquals("There are no elements in the dequeue", ioobe.getMessage());
    }

    @Test
    void testGetFirstMultiElementDequeue() {
        assertEquals(2, stringDequeue.size());
        assertEquals("two", stringDequeue.getFirst());
        stringDequeue.addFirst("three");
        assertEquals("three", stringDequeue.getFirst());
    }

    @Test
    void testRemoveFirstIndexOutOfBoundsException() {
        CustomDequeueImplementation<Double> dequeue = new CustomDequeueImplementation<>();
        IndexOutOfBoundsException ioobe = assertThrows(IndexOutOfBoundsException.class, () -> dequeue.removeFirst());
        assertEquals("There are no elements in the dequeue", ioobe.getMessage());
    }

    @Test
    void testRemoveFirstMultiElementStringDequeue() {
        assertEquals(2, stringDequeue.size());
        assertEquals("two", stringDequeue.removeFirst());
        assertEquals(1, stringDequeue.size());
        assertEquals("one", stringDequeue.removeFirst());
        assertEquals(0, stringDequeue.size());
        assertThrows(IndexOutOfBoundsException.class, () -> stringDequeue.removeFirst());
    }

    @Test
    void testRemoveFirstMultiElementIntegerDequeue() {
        assertEquals(3, integerDequeue.size());
        assertEquals(3, integerDequeue.removeFirst());
        assertEquals(2, integerDequeue.size());
        assertEquals(2, integerDequeue.removeFirst());
        assertEquals(1, integerDequeue.size());
        assertEquals(1, integerDequeue.removeFirst());
        assertEquals(0, integerDequeue.size());
        assertThrows(IndexOutOfBoundsException.class, () -> integerDequeue.removeFirst());
    }

    @Test
    void testAddLastEmptyDequeue() {
        CustomDequeueImplementation<String> dequeue = new CustomDequeueImplementation<>();
        assertEquals(0, dequeue.size());
        dequeue.addLast("one");
        assertEquals(1, dequeue.size());
        assertEquals("one", dequeue.getLast());
        assertEquals("one", dequeue.getFirst());
        dequeue.addLast("two");
        assertEquals(2, dequeue.size());
        assertEquals("two", dequeue.getLast());
        assertEquals("one", dequeue.getFirst());
    }

    @Test
    void testAddLastIncreaseCapacity() {
        assertEquals(3, integerDequeue.size());
        assertEquals(1, integerDequeue.getLast());
        integerDequeue.addLast(4);
        integerDequeue.addLast(5);
        assertEquals(5, integerDequeue.size());
        assertEquals(5, integerDequeue.getLast());
    }

    @Test
    void testGetLastIndexOutOfBoundsException() {
        CustomDequeueImplementation<Double> dequeue = new CustomDequeueImplementation<>();
        IndexOutOfBoundsException ioobe = assertThrows(IndexOutOfBoundsException.class, () -> dequeue.getLast());
        assertEquals("There are no elements in the dequeue", ioobe.getMessage());
    }

    @Test
    void testGetLastMultiElementDequeue() {
        assertEquals(2, stringDequeue.size());
        assertEquals("one", stringDequeue.getLast());
        assertEquals(3, integerDequeue.size());
        assertEquals(1, integerDequeue.getLast());
    }

    @Test
    void testRemoveLastIndexOutOfBoundsException() {
        CustomDequeueImplementation<Double> dequeue = new CustomDequeueImplementation<>();
        IndexOutOfBoundsException ioobe = assertThrows(IndexOutOfBoundsException.class, () -> dequeue.removeLast());
        assertEquals("There are no elements in the dequeue", ioobe.getMessage());
    }

    @Test
    void testRemoveLastMultiElementStringDequeue() {
        assertEquals(2, stringDequeue.size());
        assertEquals("one", stringDequeue.removeLast());
        assertEquals(1, stringDequeue.size());
        assertEquals("two", stringDequeue.removeLast());
        assertEquals(0, stringDequeue.size());
        assertThrows(IndexOutOfBoundsException.class, () -> stringDequeue.removeLast());
    }

    @Test
    void testRemoveLastMultiElementIntegerDequeue() {
        assertEquals(3, integerDequeue.size());
        assertEquals(1, integerDequeue.removeLast());
        assertEquals(2, integerDequeue.size());
        assertEquals(2, integerDequeue.removeLast());
        assertEquals(1, integerDequeue.size());
        assertEquals(3, integerDequeue.removeLast());
        assertEquals(0, integerDequeue.size());
        assertThrows(IndexOutOfBoundsException.class, () -> integerDequeue.removeLast());
    }

    @Test
    void testRemoveFirstAndLast() {
        assertEquals(3, integerDequeue.size());
        assertEquals(1, integerDequeue.removeLast());
        assertEquals(3, integerDequeue.removeFirst());
        assertEquals(1, integerDequeue.size());
        assertEquals(2, integerDequeue.getFirst());
        assertEquals(2, integerDequeue.getLast());
    }
    @Test
    void testToStringEmptyDequeue(){
        CustomDequeueImplementation<String> dequeue = new CustomDequeueImplementation<>();
        assertEquals("[]", dequeue.toString());
    }
    @Test
    void testToStringMultiElementDequeue(){
        assertEquals("[3, 2, 1]", integerDequeue.toString());
        assertEquals("[two, one]", stringDequeue.toString());
    }


}