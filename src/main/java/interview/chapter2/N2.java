package interview.chapter2;

/**
 * 在单链表和双链表中删除倒数第K个节点
 */
public class N2 {
    public Node removeLastKthNode(Node head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            return cur;
        }
        if (lastKth < 0) {
            cur = head;
            while (lastKth != -1) {
                lastKth++;
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
