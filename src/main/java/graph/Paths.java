package graph;

import java.util.List;

/**
 * 寻找路径接口
 * @author yasin
 * @version v1.0
 * @date 2018/4/13
 */
public interface Paths {
    boolean hasPathTo(int v);
    List<Integer> pathTo(int v);
}
