package heap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyIndexHeapTest {

    MyIndexHeap<Integer> heap;

    @Before
    public void setUp() throws Exception {
        heap = new MyIndexHeap<Integer>(10, (a, b) -> a - b);
        heap.insert(0, 5);
        heap.insert(1, 8);
        heap.insert(2, 3);
        heap.insert(3, 11);
    }

    @Test
    public void constructorTest() throws Exception {
        assertTrue(heap.size() == 4);
        assertTrue(heap.peek() == 3);
    }

    @Test
    public void isEmpty() throws Exception {
        assertFalse(heap.isEmpty());
        for (int i = 0; i < 4; i++)
            heap.pop();
        assertTrue(heap.isEmpty());
    }

    @Test
    public void add() throws Exception {
        heap.add(1);
        assertTrue(heap.peek() == 1);
        assertTrue(heap.size() == 5);

    }

    @Test
    public void pop() throws Exception {
        assertTrue(heap.pop() == 3);
    }

    @Test
    public void remove() throws Exception {
        assertTrue(heap.remove(1) == 8);
        assertTrue(heap.size() == 3);

    }

    @Test
    public void peek() throws Exception {
        assertTrue(heap.peek() == 3);
    }

    @Test
    public void size() throws Exception {
        assertTrue(heap.size() == 4);

    }


    @Test
    public void popMinIndex() {
        assertTrue(heap.popMinIndex() == 2);
        assertTrue(heap.size() == 3);

    }


    @Test
    public void insert() {
        heap.insert(6, 1);
        assertTrue(heap.peek() == 1);
        assertTrue(heap.size() == 5);
//        assertTrue(heap.popMinIndex() == 6);
    }
}