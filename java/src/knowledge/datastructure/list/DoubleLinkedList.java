package knowledge.datastructure.list;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/1 11:46
 * @see leetcode.problems.LeetCode146 LRU
 * @see leetcode.problems.LeetCode432 全O(1)
 * @see leetcode.problems.LeetCode460 LFU
 */
public class DoubleLinkedList {

    public Node head;
    public Node tail;
    public int size;

    public DoubleLinkedList() {
        this.head = new Node();
        this.tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node node) {
        Node next = head.next;

        head.next = node;
        node.prev = head;

        node.next = next;
        next.prev = node;
        size++;
    }

    public void addLast(Node node) {
        Node pre = tail.prev;
        tail.prev = node;
        node.next = tail;
        pre.next = node;
        node.prev = pre;
        size++;
    }

    public Node removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node ele = head.next;
        head = head.next;
        head.prev = tail;
        size--;
        return ele;
    }

    public Node removeLast() {
        Node node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        size--;
        return node;
    }

    public Node getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.next;
    }

    public Node getLast() {
        if (isEmpty()) {
            return null;
        }
        return tail.prev;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public void addFront(Node cur, Node node) {
        node.next = cur;
        node.prev = cur.prev;

        cur.prev.next = node;
        cur.prev = node;
        size++;
    }

    public void addBack(Node cur, Node node) {
        node.next = cur.next;
        node.prev = cur;

        cur.next.prev = node;
        cur.next = node;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public String toString() {
        Node cur = head.next;
        StringBuilder sb = new StringBuilder();
        while (cur != tail) {
            sb.append(cur.val);
            sb.append(",");
            cur = cur.next;
        }
        if (sb.isEmpty()) {
            return "";
        }
        return "[" + sb.substring(0, sb.length() - 1) + "]";
    }
}


