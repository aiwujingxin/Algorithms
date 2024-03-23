package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/22 21:20
 */
public class LeetCode622 {

    class MyCircularQueue {

        int capacity, head, size, tail;
        int[] nums;

        public MyCircularQueue(int k) {
            this.capacity = k;
            this.nums = new int[capacity];
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            nums[tail++] = value;
            tail %= capacity;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            head = (head + 1) % capacity;
            size--;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : nums[head];
        }

        public int Rear() {
            return isEmpty() ? -1 : nums[(tail - 1 + capacity) % capacity];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }
}
