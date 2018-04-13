package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author yasin
 * @version v1.0
 * @date 2018/4/13
 */
public class DFSPaths implements Paths {

    private boolean[] marked;
    private int[] edgeTo; // 从起点到一个顶点的已知路径上的最后一个顶点
    private NonWeightGraph g;
    private int s; // 起点

    public DFSPaths(NonWeightGraph g, int s) {
        this.g = g;
        this.s = s;
        marked = new boolean[g.v()];
        edgeTo = new int[g.v()];
        dfs(s);
    }

    private void dfs(int v) {
        marked[v] = true;
        for (int w : g.edgeAdj(v))
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(w);
            }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public List<Integer> pathTo(int v) {
        if (!hasPathTo(v))
            return null;
        LinkedList<Integer> path = new LinkedList<>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
}
