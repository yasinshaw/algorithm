package interview.chapter2;

/**
 * 反转部分单向链表
 */
public class N5 {
    public Node reversePart(Node head, int from, int to) {
        int len = 0;
        Node cur = head;
        Node fPre = null;
        Node tPos = null;
        while (cur != null) {
            len++;
            fPre = len == from - 1 ? cur : fPre;
            tPos = len == to + 1 ? cur : tPos;
            cur = cur.next;
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }
        Node pre = fPre == null ? head : fPre.next;
        cur = pre.next;
        pre.next = tPos;
        Node next;
        while (cur != tPos) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (fPre != null) {
            fPre.next = pre;
            return head;
        }
        return pre;
    }
}
