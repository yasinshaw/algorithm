package interview.chapter2;

/**
 * 删除链表的中间节点和a/b处的节点
 */
public class N3 {
    public Node removeMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public Node removeByRatio(Node head, int a, int b) {
        if (a < 1 || a > b) {
            return head;
        }
        int n = 0;
        Node cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        int index = (a * n) / b + 1;
        cur = head;
        n = 1;
        while (n < index) {
            cur = cur.next;
            n++;
        }
        cur.next = cur.next.next;
        return head;
    }
}
