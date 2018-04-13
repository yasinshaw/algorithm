package graph;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yasin
 * @version v1.0
 * @date 2018/4/14
 */
public class BFSPathsTest {

    private BFSPaths bfsPaths;

    @Before
    public void setUp() throws Exception {
        NonWeightGraph g = new NonWeightGraph(false, 5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        bfsPaths = new BFSPaths(g, 0);
    }

    @Test
    public void hasPathTo() {
        assertTrue(bfsPaths.hasPathTo(3));
        assertFalse(bfsPaths.hasPathTo(4));
    }

    @Test
    public void pathTo() {
        List<Integer> paths = bfsPaths.pathTo(3);
        assertEquals(paths.size(), 3);
        assertTrue(paths.get(0) == 0);
        assertTrue(paths.get(1) == 1);
        assertTrue(paths.get(2) == 3);
    }
}