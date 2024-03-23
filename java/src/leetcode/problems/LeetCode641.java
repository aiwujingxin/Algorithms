package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/22 21:25
 */
public class LeetCode641 {

    class MyCircularDeque {

        int head, tail, size, capacity;
        int[] nums;

        public MyCircularDeque(int k) {
            this.capacity = k;
            this.nums = new int[capacity];
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            nums[tail++] = value;
            tail %= capacity;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            head = (head + 1) % capacity;
            size--;
            return true;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            head = (head + capacity - 1) % capacity;
            nums[head] = value;
            size++;
            return true;
        }


        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            tail = (tail - 1 + capacity) % capacity;
            size--;
            return true;
        }

        public int getFront() {
            return isEmpty() ? -1 : nums[head];
        }

        public int getRear() {
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
