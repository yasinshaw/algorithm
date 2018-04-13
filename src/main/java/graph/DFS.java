package graph;

/**
 * 深度优先搜索
 * @author yasin
 * @version v1.0
 * @date 2018/4/13
 */
public class DFS {
    private boolean[] marked; // 标记顶点是否已经被访问
    private int count; // 遍历的顶点数
    private NonWeightGraph g; // 无权图

    public DFS(NonWeightGraph g, int s) {
        this.g = g;
        marked = new boolean[g.v()];
        dfs(s);
    }

    private void dfs(int v) {
        marked[v] = true;
        count++;
        for (int w : g.edgeAdj(v))
            if (!marked[w])
                dfs(w);
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}
