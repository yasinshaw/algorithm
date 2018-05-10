package search;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author yasin
 * @version v1.0
 */
public class BinarySearchTreeTest {

    private BinarySearchTree<Integer, Integer> binarySearchTree;
    @Before
    public void setUp() {
        binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.put(1, 1);
        binarySearchTree.put(2, 2);
        binarySearchTree.put(3, 3);
    }

    @Test
    public void size() {
        assertEquals(3, binarySearchTree.size());
    }

    @Test
    public void get() {
        assertEquals(2, (int)binarySearchTree.get(2));
    }

    @Test
    public void put() {
        binarySearchTree.put(4, 4);
        assertEquals(4, (int)binarySearchTree.size());
    }

    @Test
    public void min() {
        assertEquals(1, (int)binarySearchTree.min());
    }

    @Test
    public void max() {
        assertEquals(3, (int)binarySearchTree.max());
    }

    @Test
    public void floor() {
        assertEquals(2, (int)binarySearchTree.floor(2));
    }

    @Test
    public void select() {
        assertEquals(2, (int)binarySearchTree.select(2));
    }

    @Test
    public void rank() {
        assertEquals(2, binarySearchTree.rank(2));
    }

    @Test
    public void deleteMin() {
        binarySearchTree.deleteMin();
        assertEquals(2, (int)binarySearchTree.min());
    }

    @Test
    public void delete() {
        binarySearchTree.delete(2);
        assertEquals(2, (int)binarySearchTree.size());
        assertNull(binarySearchTree.get(2));
    }

    @Test
    public void keys() {
        Iterator<Integer> integerIterator = binarySearchTree.keys().iterator();
        assertEquals(1, (int)integerIterator.next());
        assertEquals(2, (int)integerIterator.next());
    }
}