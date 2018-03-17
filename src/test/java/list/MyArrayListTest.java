package list;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest {

    @Test
    public void test() throws Exception {
        IList<Integer> list = new MyArrayList<>(10);
        list.insert(0, 1);
        list.insert(0, 2);
        assertEquals((int)list.get(0), 2);
        assertEquals((int)list.get(1), 1);
        list.insert(2, 3);
        assertEquals((int)list.delete(0), 2);
        assertEquals(list.size(), 2);
    }
}