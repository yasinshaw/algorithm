package search;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yasin
 * @version v1.0
 * @date 2018/4/27
 */
public class BinarySearchTreeTest {

    private BinarySearchTree<Integer, Integer> binarySearchTree;
    @Before
    public void setUp() throws Exception {
        binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.put(1, 1);
        binarySearchTree.put(2, 2);
        binarySearchTree.put(3, 3);
    }

    @Test
    public void size() {
        System.out.println(binarySearchTree.size());
        assertTrue(binarySearchTree.size() == 3);
    }

    @Test
    public void get() {
    }

    @Test
    public void put() {
    }

    @Test
    public void min() {
    }

    @Test
    public void max() {
    }

    @Test
    public void floor() {
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