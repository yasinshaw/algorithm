package graph;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yasin
 * @version v1.0
 * @date 2018/4/14
 */
public class LazyPrimMSTTest {

    @Test
    public void getMst() {
        WeightGraph g = new WeightGraph(false, 8);
        g.addEdge(0, 2, 0.26);
        g.addEdge(0, 4, 0.38);
        g.addEdge(0, 6, 0.58);
        g.addEdge(0, 7, 0.16);
        g.addEdge(1, 2, 0.36);
        g.addEdge(1, 3, 0.29);
        g.addEdge(1, 5, 0.32);
        g.addEdge(1, 7, 0.19);
        g.addEdge(2, 3, 0.17);
        g.addEdge(2, 6, 0.40);
        g.addEdge(2, 7, 0.34);
        g.addEdge(3, 6, 0.52);
        g.addEdge(4, 5, 0.35);
        g.addEdge(4, 6, 0.93);
        g.addEdge(4, 7, 0.37);
        g.addEdge(5, 7, 0.28);

        LazyPrimMST lazyPrimMST = new LazyPrimMST(g);
        List<Edge> mst = lazyPrimMST.mst;
//        mst.forEach( x -> {
//            System.out.println(String.format("%d-%d: %.2f", x.getV(), x.getW(), x.getWeight()));
//        });
        assertTrue(mst.size() == 7);
        assertTrue(mst.get(0).getWeight() == 0.16);
        assertTrue(mst.get(1).getWeight() == 0.19);
        assertTrue(mst.get(2).getWeight() == 0.26);
    }
}