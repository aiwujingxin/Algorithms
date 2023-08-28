package common;

import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-07-08 1:06 上午
 */
public class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node random;
    public Node parent;
    public List<Node> children;

    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
