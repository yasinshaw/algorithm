package search;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
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
        assertTrue(binarySearchTree.size() == 3);
    }

    @Test
    public void get() {
        assertThat(binarySearchTree.get(2), is(2));
    }

    @Test
    public void put() {
        binarySearchTree.put(4, 4);
        assertThat(binarySearchTree.size(), is(4));
    }

    @Test
    public void min() {
        assertThat(binarySearchTree.min(), is(1));
    }

    @Test
    public void max() {
        assertThat(binarySearchTree.max(), is(3));
    }

    @Test
    public void floor() {
        assertThat(binarySearchTree.floor(2), is(2));
    }

    @Test
    public void select() {
        assertThat(binarySearchTree.select(2), is(2));
    }

    @Test
    public void rank() {
        assertThat(binarySearchTree.rank(2), is(2));
    }

    @Test
    public void deleteMin() {
        binarySearchTree.deleteMin();
        assertThat(binarySearchTree.min(), is(2));
    }

    @Test
    public void delete() {
        binarySearchTree.delete(2);
        assertThat(binarySearchTree.size(), is(2));
        assertNull(binarySearchTree.get(2));
    }

    @Test
    public void keys() {
        Iterator<Integer> integerIterator = binarySearchTree.keys().iterator();
        assertThat(integerIterator.next(), is(1));
        assertThat(integerIterator.next(), is(2));
    }
}