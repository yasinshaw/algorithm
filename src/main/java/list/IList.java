package list;

public interface IList<T> {
    /**
     * 插入
     * @param i 位置
     * @param data 要插入的数据
     */
    void insert(int i, T data);

    /**
     * 获取
     * @param i 位置
     * @return i 位置上的元素
     */
    T get(int i);

    /**
     * 删除
     * @param i 位置
     * @return 被删除的元素
     */
    T delete(int i);

    /**
     * 列表内元素的数量
     * @return 数量
     */
    int size();

    /**
     * 列表是否为空
     * @return
     */
    boolean isEmpty();
}
