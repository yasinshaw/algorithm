package graph;

import heap.IHeap;
import heap.MyHeap;

import java.util.LinkedList;
import java.util.List;

/**
 * LazyPrim最小生成树算法
 * @author yasin
 * @version v1.0
 * @date 2018/4/14
 */
public class LazyPrimMST {
    private WeightGraph g;
    IHeap<Edge> heap; // 最小堆，充当优先队列
    boolean[] marked; // 是否被划分到切分区
    List<Edge> mst; // 属于最小生成树的边

    public LazyPrimMST(WeightGraph g) {
        this.g = g;
        heap = new MyHeap<>(g.e(), (a, b) -> a.compareTo(b));
        marked = new boolean[g.v()];
        mst = new LinkedList<>();
        visit(0); // 先访问第一个顶点
        while (!heap.isEmpty()) {
            Edge edge = heap.pop(); // 弹出最小的横切边
            // 如果两个顶点都已经被访问过，就下一次循环
            if (marked[edge.getW()] && marked[edge.getV()])
                continue;
            mst.add(edge); // 不然这条边就是横切边， 加入mst列表
            // 找到没访问过的那个端点
            if (!marked[edge.getV()])
                visit(edge.getV());
            else visit(edge.getW());
        }
    }

    /**
     * 访问结点
     * @param v 要访问的结点
     */
    private void visit(int v) {
        // 如果还没有访问过
        if (!marked[v]) {
            marked[v] = true; // 标记为已访问
            // 遍历v的每一个邻接点
            g.edgeAdj(v).stream().forEach( x -> {
                // 如果这个邻接点没有被标记，说明找到了横切边。
                if (!marked[x.getOther(v)])
                    heap.add(x); // 横切边入堆
            });
        }
    }

    public List<Edge> getMst() {
        return mst;
    }
}
