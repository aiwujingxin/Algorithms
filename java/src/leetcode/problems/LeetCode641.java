package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/22 21:25
 */
public class LeetCode641 {

    class MyCircularDeque {

        int[] nums;
        int head, tail, size, total;

        public MyCircularDeque(int _k) {
            total = _k;
            nums = new int[total];
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            head = (head + total - 1) % total;
            nums[head] = value;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            nums[tail++] = value;
            size++;
            tail %= total;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            head = (head + 1) % total;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            tail = (tail + total - 1) % total;
            size--;
            return true;
        }

        public int getFront() {
            return isEmpty() ? -1 : nums[head];
        }

        public int getRear() {
            return isEmpty() ? -1 : nums[(tail + total - 1) % total];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == total;
        }
    }
}
