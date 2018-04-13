package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 带权图
 * @author yasin
 * @version v1.0
 * @date 2018/4/12
 */
public class WeightGraph {
    private final boolean directed; // 是否有向
    private final int v; // 顶点数
    private int e = 0; // 边数
    private List<Edge>[] adj;

    public WeightGraph(boolean directed, int v) {
        this.directed = directed;
        this.v = v;
        adj = new List[v];
        for (List vList : adj)
            vList = new LinkedList();
    }

    public int v() {
        return v;
    }

    public int e() {
        return e;
    }

    /**
     * 添加边
     * @param v 顶点v
     * @param w 顶点w
     * @param weight 权重
     */
    public void addEdge(int v, int w, double weight) {
        checkIndex(v);
        checkIndex(w);
        this.addEdge(new Edge(v, w, weight));
    }

    /**
     * 添加边
     * @param edge 边
     */
    public void addEdge(Edge edge) {
        int v = edge.getV();
        int w = edge.getW();
        checkIndex(v);
        checkIndex(w);
        adj[v].add(edge);
        // 这里 v != w 是为了防止闭环图
        if (v != w && !directed)
            adj[w].add(edge);
        this.e++;
    }

    /**
     * 顶点的邻边
     * @param v 顶点v
     * @return v的邻边
     */
    public List<Edge> edgeAdj(int v) {
        checkIndex(v);
        return adj[v];
    }

    /**
     * 返回图所有的边
     * @return 所有的边
     */
    public List<Edge> edges() {
        List<Edge> list = new LinkedList<>();
        for (int i = 0; i < v; i++)
            for (Edge e : adj[i])
                if (e.getW() > i)
                    list.add(e);
        return list;
    }

    /**
     * 判断两个顶点是否有边
     * @param v 顶点v
     * @param w 顶点w
     * @return true表示v到w有边
     */
    public boolean hasEdge(int v, int w) {
        checkIndex(v);
        checkIndex(w);
        return adj[v].stream().anyMatch(i -> i.getW() == w);
    }

    /**
     * 检查顶点的位置是否合法
     * @param v 顶点的索引
     */
    private void checkIndex(int v) {
        if (v < 0 || v > this.v)
            throw new RuntimeException("位置 " +  v + " 不合法");
    }
}
