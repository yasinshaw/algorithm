package graph;

import heap.MyIndexHeap;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * dijkstra单源最短路径算法
 * 时间复杂度：ElogV
 * 局限：图中不能有负权边
 * @author yasin
 * @version v1.0
 * @date 2018/4/15
 */
public class Dijkstra {
    private WeightGraph g;
    private int s; // 起点
    private double[] distTo; // 起点到某个顶点的最短距离
    private boolean[] marked; // 标记顶点是否已访问
    private Edge[] edgeTo; // 路径
    private MyIndexHeap<Double> heap;

    public Dijkstra(WeightGraph g, int s) {
        this.g = g;
        this.s = s;
        distTo = new double[g.v()];
        marked = new boolean[g.v()];
        edgeTo = new Edge[g.v()];
        heap = new MyIndexHeap<>(g.v(), (a, b) -> a.compareTo(b));

        distTo[s] = 0;
        marked[s] = true;
        heap.insert(s, distTo[s]);

        while (!heap.isEmpty()) {
            int v = heap.popMinIndex();

            // distTo[v] 就是s到v的最短距离
            marked[v] = true;

            g.edgeAdj(v).stream().forEach( edge -> {
                int w = edge.getOther(v);
                if (!marked[w]) {
                    // 判断是否需要松弛操作
                    if (edgeTo[w] == null || distTo[v] + edge.getWeight() < distTo[w]) {
                        distTo[w] = distTo[v] + edge.getWeight();
                        edgeTo[w] = edge;
                        heap.insert(w, distTo[w]);
                    }
                }
            });
        }
    }

    public double shortestPathTo(int w) {
        return distTo[w];
    }

    public boolean hasPathTo(int w) {
        return marked[w];
    }

    public List<Edge> pathTo(int w) {
        LinkedList<Edge> path = new LinkedList<>();
        if (hasPathTo(w)) {
            while (w != s) {
                Edge edge = edgeTo[w];
                path.push(edge);
                w = edge.getOther(w);
            }
        }
        return path;
    }
}
