package leetcode.lists.LCR;

import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/24 22:34
 */
public class LCR59 {

    class KthLargest {
        int k;
        PriorityQueue<Integer> queue;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.queue = new PriorityQueue<>();
            for (int num : nums) {
                queue.add(num);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }

        public int add(int val) {

            queue.add(val);
            if (queue.size() > k) {
                queue.poll();
            }
            return queue.size() >= k ? queue.peek() : -1;
        }
    }
}
