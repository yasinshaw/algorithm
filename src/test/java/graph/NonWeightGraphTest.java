package graph;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yasin
 * @version v1.0
 * @date 2018/4/13
 */
public class NonWeightGraphTest {

    private NonWeightGraph g;

    @Before
    public void setUp() throws Exception {
        g = new NonWeightGraph(false, 5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(3, 4);
    }

    @Test
    public void v() {
        assertEquals(g.v(), 5);
    }

    @Test
    public void e() {
        assertEquals(g.e(), 6);
    }

    @Test
    public void addEdge() {
        g.addEdge(3, 2);
        assertEquals(g.e(), 7);
    }

    @Test
    public void edgeAdj() {
        List<Integer> adj = g.edgeAdj(0);
        List<Integer> testAdj = new LinkedList<>();
        testAdj.add(1);
        testAdj.add(2);
        testAdj.add(3);
        assertEquals(adj, testAdj);
    }

    @Test
    public void hasEdge() {
        assertTrue(g.hasEdge(1, 3));
        assertFalse(g.hasEdge(1, 2));
    }
}