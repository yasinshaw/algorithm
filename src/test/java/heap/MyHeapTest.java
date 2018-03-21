package heap;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class MyHeapTest {

    IHeap<Integer> heap;

    @Before
    public void setUp() throws Exception {
        Integer[] arr = { 4,7, 3, 2, 9};
        heap = new MyHeap<Integer>(arr, (a, b) -> a - b);
    }

    @Test
    public void constructorTest() throws Exception {
        heap = new MyHeap<Integer>(10, (a, b) -> a - b);
        heap.add(5);
        heap.add(8);
        heap.add(3);
        heap.add(11);
        assertTrue(heap.size() == 4);
        assertTrue(heap.peek() == 3);
    }

    @Test
    public void isEmpty() throws Exception {
        assertFalse(heap.isEmpty());
        for (int i = 0; i < 5; i++)
            heap.pop();
        assertTrue(heap.isEmpty());
    }

    @Test
    public void add() throws Exception {
        heap.pop();
        heap.add(1);
        assertTrue(heap.peek() == 1);
    }

    @Test
    public void pop() throws Exception {
        assertTrue(heap.pop() == 2);
    }

    @Test
    public void remove() throws Exception {
        assertTrue(heap.remove(1) == 2);
    }

    @Test
    public void peek() throws Exception {
        assertTrue(heap.peek() == 2);
    }

    @Test
    public void size() throws Exception {
        assertTrue(heap.size() == 5);
    }

}