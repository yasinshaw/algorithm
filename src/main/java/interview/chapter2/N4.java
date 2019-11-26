package interview.chapter2;

/**
 * 反转链表
 */
public class N4 {
    public Node reverseList(Node head) {
        Node pre = null;
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
