package graph;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yasin
 * @version v1.0
 * @date 2018/4/15
 */
public class DijkstraTest {

    private Dijkstra dijkstra;

    @Before
    public void setUp() throws Exception {
        WeightGraph g = new WeightGraph(true, 5);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(1, 4, 1);
        g.addEdge(2, 1, 1);
        g.addEdge(2, 4, 5);
        g.addEdge(2, 3, 3);
        g.addEdge(3, 4, 2);
        dijkstra = new Dijkstra(g, 0);
    }

    @Test
    public void shortestPathTo() {
        assertTrue(dijkstra.shortestPathTo(2) == 2.0);
        assertTrue(dijkstra.shortestPathTo(3) == 5.0);
        assertTrue(dijkstra.shortestPathTo(4) == 4.0);
    }

    @Test
    public void hasPathTo() {
        assertTrue(dijkstra.hasPathTo(1));
        assertTrue(dijkstra.hasPathTo(2));
        assertTrue(dijkstra.hasPathTo(3));
        assertTrue(dijkstra.hasPathTo(4));
    }

    @Test
    public void pathTo() {
        List<Edge> path = dijkstra.pathTo(4);
        path.stream().forEach(System.out::println);
        assertTrue(path.size() == 3);
    }
}