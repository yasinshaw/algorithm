package stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayStackTest {

    @Test
    public void test() {
        IStack<Integer> stack = new MyLinkedStack<>();
        stack.push(1);
        stack.push(2);
        assertEquals(stack.size(), 2);
        assertTrue(stack.peek() == 2);
        assertTrue(stack.pop() == 2);
        assertTrue(stack.peek() == 1);
        assertTrue(stack.pop() == 1);
        assertTrue(stack.isEmpty());
    }
}