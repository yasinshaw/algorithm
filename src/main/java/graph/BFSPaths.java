package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先搜索
 * @author yasin
 * @version v1.0
 * @date 2018/4/13
 */
public class BFSPaths implements Paths {

    private boolean[] marked;
    private int[] edgeTo; // 从起点到一个顶点的已知路径上的最后一个顶点
    private NonWeightGraph g;
    private int s; // 起点

    public BFSPaths(NonWeightGraph g, int s) {
        this.g = g;
        this.s = s;
        marked = new boolean[g.v()];
        edgeTo = new int[g.v()];
        bfs(s);
    }

    private void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true;
        queue.offer(s); // 顶点s入队
        while (!queue.isEmpty()) {
            int v = queue.poll(); // 弹出队首元素
            for (int w : g.edgeAdj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.offer(w); // w 入队
                }
            }
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
