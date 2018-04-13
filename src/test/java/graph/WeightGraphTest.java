package graph;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yasin
 * @version v1.0
 * @date 2018/4/13
 */
public class WeightGraphTest {

    private WeightGraph g;

    @Before
    public void setUp() throws Exception {
        g = new WeightGraph(true, 5);
        g.addEdge(0, 1, 1.0);
        g.addEdge(0, 2, 2.0);
        g.addEdge(0, 3, 3.0);
        g.addEdge(1, 3, 4.0);
        g.addEdge(1, 4, 5.0);
    }

    @Test
    public void v() {
        assertEquals(g.v(), 5);
    }

    @Test
    public void e() {
        assertEquals(g.e(), 5);
    }

    @Test
    public void addEdge() {
        g.addEdge(4, 1, 5.0);
        assertEquals(g.e(), 6);
        assertTrue(g.hasEdge(4, 1));

    }

    @Test
    public void edgeAdj() {
        List<Edge> adj = g.edgeAdj(0);
        assertTrue(adj.get(0).getV() == 0);
        assertTrue(adj.get(1).getW() == 2);
        assertTrue(adj.get(2).getWeight() == 3.0);
    }

    @Test
    public void edges() {
        assertEquals(g.edges().size(), 5);
    }

    @Test
    public void hasEdge() {
        assertTrue(g.hasEdge(0, 1));
        assertFalse(g.hasEdge(1, 2));
        assertFalse(g.hasEdge(1, 0));
    }
}