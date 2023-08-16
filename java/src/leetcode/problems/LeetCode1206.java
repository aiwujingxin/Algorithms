package leetcode.problems;

import java.util.Random;
import java.util.Stack;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/26 22:17
 */
public class LeetCode1206 {
    class Skiplist {
        Node head = new Node(-1, null, null);
        Random rand = new Random();

        public Skiplist() {

        }

        public boolean search(int target) {
            Node cur = head;
            while (cur != null) {
                while (cur.next != null && cur.next.val < target) {
                    cur = cur.next;
                }
                if (cur.next != null && cur.next.val == target) return true;
                cur = cur.down;
            }
            return false;
        }

        public void add(int num) {
            Stack<Node> stack = new Stack<>();
            Node cur = head;
            while (cur != null) {
                while (cur.next != null && cur.next.val < num) {
                    cur = cur.next;
                }
                stack.push(cur);
                cur = cur.down;
            }
            boolean insert = true;
            Node down = null;
            while (insert && !stack.isEmpty()) {
                cur = stack.pop();
                cur.next = new Node(num, cur.next, down);
                down = cur.next;
                insert = rand.nextDouble() < 0.5;
            }
            if (insert) head = new Node(-1, null, head);
        }

        public boolean erase(int num) {
            Node cur = head;
            boolean found = false;
            while (cur != null) {
                while (cur.next != null && cur.next.val < num) {
                    cur = cur.next;
                }
                if (cur.next != null && cur.next.val == num) {
                    found = true;
                    cur.next = cur.next.next;
                }
                cur = cur.down;
            }
            return found;
        }

        class Node {
            int val;
            Node next, down;

            public Node(int val, Node next, Node down) {
                this.val = val;
                this.next = next;
                this.down = down;
            }
        }
    }

}
