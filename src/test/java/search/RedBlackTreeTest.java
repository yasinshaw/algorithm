package search;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author yasin
 * @version v1.0
 */
public class RedBlackTreeTest {

    private RedBlackTree<Integer, Integer> binarySearchTree;
    @Before
    public void setUp() throws Exception {
        binarySearchTree = new RedBlackTree<>();
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
        assertEquals(2, (int) binarySearchTree.get(2));
    }

    @Test
    public void put() {
        binarySearchTree.put(3, 777);
        assertEquals(777, (int) binarySearchTree.get(3));
    }

    @Test
    public void min() {
        assertEquals(1, (int) binarySearchTree.min());
    }

    @Test
    public void max() {
        assertEquals(3, (int) binarySearchTree.max());
    }

    @Test
    public void floor() {
        assertEquals(2, (int) binarySearchTree.floor(2));
    }

    @Test
    public void select() {
    }

    @Test
    public void rank() {
    }

    @Test
    public void deleteMin() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void keys() {
    }

    @Test
    public void keys1() {
    }
}