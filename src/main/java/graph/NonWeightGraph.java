package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 带权图
 * @author yasin
 * @version v1.0
 * @date 2018/4/12
 */
public class NonWeightGraph {
    private final boolean directed; // 是否有向
    private final int v; // 顶点数
    private int e = 0; // 边数
    private List<Integer>[] adj;

    public NonWeightGraph(boolean directed, int v) {
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
     */
    public void addEdge(int v, int w) {
        checkIndex(v);
        checkIndex(w);
        adj[v].add(w);
        // 这里 v != w 是为了防止闭环图
        if (v != w && !directed)
            adj[w].add(v);
        this.e++;
    }

    /**
     * 返回某个顶点的邻边
     * @param v 顶点v
     * @return 顶点v的邻边
     */
    public List<Integer> edgeAdj(int v) {
        checkIndex(v);
        return adj[v];
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
        return adj[v].stream().anyMatch(i -> i == w);
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
