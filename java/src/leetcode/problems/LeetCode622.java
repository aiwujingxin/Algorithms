package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/22 21:20
 * @description 多留一个空间 区分满和空的判断
 */
public class LeetCode622 {

    class MyCircularQueue {
        int[] q;
        int h, t, n;

        public MyCircularQueue(int k) {
            n = k + 1;
            q = new int[n];
        }

        public boolean enQueue(int val) {
            if (isFull()) return false;
            q[t] = val;
            t = (t + 1) % n;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            h = (h + 1) % n;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : q[h];
        }

        public int Rear() {
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
