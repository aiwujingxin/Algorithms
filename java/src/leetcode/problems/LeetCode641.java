package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/22 21:25
 */
public class LeetCode641 {

    class MyCircularDeque {
        int[] q;
        int h, t, n;

        public MyCircularDeque(int k) {
            n = k + 1;
            q = new int[n];
        }

        public boolean insertFront(int val) {
            if (isFull()) return false;
            h = (h - 1 + n) % n;
            q[h] = val;
            return true;
        }

        public boolean insertLast(int val) {
            if (isFull()) return false;
            q[t] = val;
            t = (t + 1) % n;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) return false;
            h = (h + 1) % n;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) return false;
            t = (t - 1 + n) % n;
            return true;
        }

        public int getFront() {
            return isEmpty() ? -1 : q[h];
        }

        public int getRear() {
            return isEmpty() ? -1 : q[(t - 1 + n) % n];
        }

        public boolean isEmpty() {
            return h == t;
        }

        public boolean isFull() {
            return (t + 1) % n == h;
        }
    }
}
