package queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayQueueTest {

    @Test
    public void test() throws Exception {
        IQueue<Integer> queue = new MyArrayQueue<>(10);
        queue.offer(1);
        queue.offer(2);
        assertEquals(queue.size(), 2);
        assertTrue(queue.peek() == 1);
        assertTrue(queue.poll() == 1);
        assertTrue(queue.poll() == 2);
        assertTrue(queue.isEmpty());
    }
}