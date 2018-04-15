package graph;

import heap.IHeap;
import heap.MyHeap;
import heap.MyIndexHeap;

import java.util.LinkedList;
import java.util.List;

/**
 * 优化的Prim算法
 * 复杂度为ElgV级别
 * @author yasin
 * @version v1.0
 * @date 2018/4/14
 */
public class PrimMST {
    private WeightGraph g;
    MyIndexHeap<Edge> heap; // 最小堆，充当优先队列
    Edge[] edgeTo; // 存放每个顶点的最小邻接边
    boolean[] marked; // 是否被划分到切分区
    List<Edge> mst; // 属于最小生成树的边

    public PrimMST(WeightGraph g) {
        this.g = g;
        heap = new MyIndexHeap<>(g.v(), (a, b) -> a.compareTo(b));
        marked = new boolean[g.v()];
        edgeTo = new Edge[g.v()];
        mst = new LinkedList<>();
        visit(0); // 先访问第一个顶点
        while (!heap.isEmpty()) {
            int v = heap.popMinIndex(); // 弹出最小的横切边对应的顶点
            mst.add(edgeTo[v]); // 这条边是横切边， 加入mst列表
            // 找到没访问过的那个端点
            visit(v);
        }
    }

    private void visit(int v) {
        if (!marked[v]) {
            marked[v] = true;
            g.edgeAdj(v).stream().forEach( x -> {
                // 如果这个邻接点没有被标记，说明找到了横切边。
                int w = x.getOther(v);
                if (!marked[w]) {
                    heap.insert(w, x);
                    edgeTo[w] = x;
                }
            });
        }
    }

    public List<Edge> getMst() {
        return mst;
    }
}
