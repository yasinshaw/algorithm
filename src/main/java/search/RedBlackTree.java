package search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二分搜索树
 * @author yasin
 * @version v1.0
 * @date 2018/4/20
 */
public class RedBlackTree<K extends Comparable<K>, V> {
    private Node root; // 二叉查找树的根节点
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        K key; // 键
        V value; // 值
        Node left, right; // 指向子树的链接
        int n; // 以该结点为根的子树中的结点总数。
        boolean color;

        Node(K key, V value, int n, boolean color) {
            this.key = key;
            this.value = value;
            this.n = n;
            this.color = color;
        }

        boolean isRed() {
            return this.color == RED;
        }

        boolean isBlack() {
            return this.color = BLACK;
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
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node x, K key, V value) {
        // 如果key存在于以x为根结点的子树中则更新它的值。
        // 否则将以key和val为键值对的新节点。插入到该子树中。
        if (x == null)
            return new Node(key, value, 1, RED);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        return balance(x);
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
        if (root.left.isBlack() && root.right.isBlack())
            root.color = RED;
        root = deleteMin(root);
        if (root != null)
            root.color = BLACK;
    }

    private Node deleteMin(Node x) {
        if (x.left == null)
            return null;
        if (x.left.isBlack() && x.left.left.isBlack())
            x = moveRedLeft(x);
        x.left = deleteMin(x.left);
        return balance(x);
    }

    // 删除以key为键的值
    public void delete(K key) {
        if (root.left.isBlack() && root.right.isBlack())
            root.color = RED;
        root = delete(root, key);
        if (root != null)
            root.color = BLACK;
    }

    private Node delete(Node x, K key) {
        if (key.compareTo(x.key) < 0) {
            if (x.left.isBlack() && x.left.left.isBlack())
                x = moveRedLeft(x);
            x.left = delete(x.left, key);
        } else {
            if (x.left.isRed())
                x = rotateRight(x);
            if (key.compareTo(x.key) == 0 && x.right == null)
                return null;
            if (x.right.isBlack() && x.right.left.isBlack())
                x = moveRedRight(x);
            if (key.compareTo(x.key) == 0) {
                x.value = get(x.right, min(x.right).key);
                x.key = min(x.right).key;
                x.right = deleteMin(x.right);
            } else {
                x.right = delete(x.right, key);
            }
        }
        return balance(x);
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

    private Node rotateLeft(Node head) {
        Node x = head.right;
        head.right = x.left;
        x.left = head;
        x.color = head.color;
        head.color = RED;
        x.n = head.n;
        head.n = 1 + size(head.left) + size(head.right);
        return x;
    }

    private Node rotateRight(Node head) {
        Node x = head.left;
        head.left = x.right;
        x.right = head;
        x.color = head.color;
        head.color = RED;
        x.n = head.n;
        head.n = 1 + size(head.left) + size(head.right);
        return x;
    }

    private void flipColors(Node head) {
        head.color = RED;
        head.left.color = BLACK;
        head.right.color = BLACK;
    }

    // 保持平衡
    private Node balance(Node x) {
        // 旋转操作
        if (x.right.isRed() && x.left.isBlack())
            x = rotateLeft(x);
        if (x.left.isRed() && x.left.left.isRed())
            x = rotateRight(x);
        if (x.left.isRed() && x.right.isRed())
            flipColors(x);

        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    private Node moveRedLeft(Node head) {
        flipColors(head);
        if (head.right.left.isRed()) {
            head.right = rotateRight(head.right);
            head = rotateLeft(head);
        }
        return head;
    }

    private Node moveRedRight(Node head) {
        flipColors(head);
        if (head.left.left.isBlack()) {
            head = rotateRight(head);
        }
        return head;
    }
}
