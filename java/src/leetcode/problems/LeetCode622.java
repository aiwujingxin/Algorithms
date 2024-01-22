package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/22 21:20
 */
public class LeetCode622 {

    class MyCircularQueue {

        int k, head, tail;
        int[] nums;

        public MyCircularQueue(int _k) {
            k = _k;
            nums = new int[k];
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            nums[tail % k] = value;
            return ++tail >= 0;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            return ++head >= 0;
        }

        public int Front() {
            return isEmpty() ? -1 : nums[head % k];
        }

        public int Rear() {
            return isEmpty() ? -1 : nums[(tail - 1) % k];
        }

        public boolean isEmpty() {
            return head == tail;
        }

        public boolean isFull() {
            return tail - head == k;
        }
    }
}
