package search;

import java.security.Key;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二分搜索树
 * @author yasin
 * @version v1.0
 * @date 2018/4/20
 */
public class BinarySearchTree<K extends Comparable<K>, V> {
    private Node root; // 二叉查找树的根节点

    private class Node {
        K key; // 键
        V value; // 值
        Node left, right; // 指向子树的链接
        int n; // 以该结点为根的子树中的结点总数。

        public Node(K key, V value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }
    }

    // 返回树中所有结点的数量。
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.n;
    }

    // 根据key查找value
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node x, K key) {
        // 如果找不到就返回null
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.value;
    }

    // 插入操作
    public void put(K key, V value) {
        put(root, key, value);
    }

    private Node put(Node x, K key, V value) {
        // 如果key存在于以x为根结点的子树中则更新它的值。
        // 否则将以key和val为键值对的新节点。插入到该子树中。
        if (x == null)
            return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    // 得到最小值
    public K min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    // 得到最大值
    public K max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }

    // 得到key的向下最小值
    public K floor(K key) {
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node floor(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    // 得到第k大的值
    public Node select(int k) {
        return select(root, k);
    }

    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k - t - 1);
        else return x;
    }

    // 得到key的排名
    public int rank(K key) {
        return rank(root, key);
    }

    private int rank(Node x, K key) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(x.left, key);
        else if (cmp > 0) return 1 + size(x.left) + rank(x.right, key);
        else return size(x.left);
    }

    // 删除最小值
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    // 删除以key为键的值
    public void delete(K key) {
        delete(root, key);
    }

    private Node delete(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    // 得到所有的key
    public Iterable<K> keys() {
        return keys(min(), max());
    }

    // 得到一定范围的key
    public Iterable<K> keys(K lo, K hi) {
        Queue<K> queue = new LinkedList<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<K> queue, K lo, K hi) {
        if (x == null) return;
        int cmpLo = lo.compareTo(x.key);
        int cmpHi = hi.compareTo(x.key);
        if (cmpLo < 0) keys(x.left, queue, lo, hi);
        if (cmpLo <= 0 && cmpHi >= 0) queue.offer(x.key);
        if (cmpHi > 0) keys(x.right, queue, lo, hi);
    }
}
