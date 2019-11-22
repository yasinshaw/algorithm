package interview.chapter1;

import java.util.HashMap;
import java.util.Stack;

/**
 * 构造数组的MaxTree
 */
public class N8 {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int val) {
            this.value = val;
        }
    }

    public static Node getMaxTree(int[] arr) {
        Node[] nArr = new Node[arr.length];  //生成树的结构,数组中的每一个值都代表一个结点
        for (int i = 0; i < arr.length; i++) {
            nArr[i] = new Node(arr[i]);
        }

        Stack<Node> stack = new Stack<>();
        HashMap<Node, Node> lMap = new HashMap<>();
        HashMap<Node, Node> rMap = new HashMap<>();

        //找每一个数左边离它最近的大的
        for (Node cur : nArr) {
            while (!stack.isEmpty() && stack.peek().value < cur.value) {
                popStackSetValue(stack, lMap);
            }
            stack.push(cur);
        }
        while (!stack.isEmpty()) {
            popStackSetValue(stack, lMap);
        }

        //找每一个数右边比它最近的大的
        for (int i = nArr.length - 1; i >= 0; i--) {
            Node cur = nArr[i];
            while (!stack.isEmpty() && stack.peek().value < cur.value) {
                popStackSetValue(stack, rMap);
            }
            stack.push(cur);
        }
        while (!stack.isEmpty()) {
            popStackSetValue(stack, rMap);
        }

        //开始构造这棵树
        Node head = null;
        for (Node cur : nArr) {
            Node L = lMap.get(cur); //左边离cur最近的
            Node R = rMap.get(cur); //右边离cur最近的

            if (L == null && R == null) {
                head = cur;
            } else if (L == null) {
                if (R.left == null) R.left = cur;
                else R.right = cur;
            } else if (R == null) {
                if (L.left == null) L.left = cur;
                else L.right = cur;
            } else {
                Node minNode = L.value < R.value ? L : R;
                if (minNode.left == null) minNode.left = cur;
                else minNode.right = cur;
            }
        }
        return head;
    }

    //弹出来一个数，并且得到它左/右边边最近的比他大的数
    private static void popStackSetValue(Stack<Node> stack, HashMap<Node, Node> map) {
        Node top = stack.pop();
        if (stack.isEmpty()) {
            map.put(top, null);
        } else {
            map.put(top, stack.peek());
        }
    }
}
