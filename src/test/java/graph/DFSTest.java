package graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yasin
 * @version v1.0
 * @date 2018/4/13
 */
public class DFSTest {

    private DFS dfs;

    @Before
    public void setUp() throws Exception {
        NonWeightGraph g = new NonWeightGraph(false, 5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        dfs = new DFS(g, 0);
    }

    @Test
    public void marked() {
        assertTrue(dfs.marked(1));
        assertFalse(dfs.marked(4));
        assertTrue(dfs.marked(3));
    }

    @Test
    public void count() {
        assertEquals(dfs.count(), 4);
    }
}