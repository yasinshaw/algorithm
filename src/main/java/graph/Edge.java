package graph;

/**
 * 带权图的边
 * @author yasin
 * @version v1.0
 * @date 2018/4/12
 */
public class Edge implements Comparable<Edge>{
    private int v; // 一个顶点
    private int w; // 另一个顶点
    private double weight; // 边的权重

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }

    /**
     * 得到这条边上的另一个顶点
     * @param vertex 输入的顶点
     * @return 这条边上的另一个顶点
     */
    public int getOther( int vertex) {
        if (vertex == v)
            return w;
        else if (vertex == w)
            return v;
        else throw new RuntimeException("请输入正确的顶点！");
    }

    @Override
    public int compareTo(Edge o) {
        return (int) (this.weight - o.weight);
    }

    @Override
    public String toString() {
        return String.format("%d-%d, %.2f", v, w, weight);
    }
}
