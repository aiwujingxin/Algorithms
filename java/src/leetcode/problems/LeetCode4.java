package leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/6 17:25
 */
public class LeetCode4 {

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        queue1 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        queue2 = new PriorityQueue<>();

        add(nums1);
        add(nums2);

        if ((nums1.length + nums2.length) % 2 == 1) {
            return queue1.peek();
        }
        return ((double) queue1.peek() + (double) queue2.peek()) / 2;
    }

    private void add(int[] nums) {
        for (int num : nums) {
            if (queue1.isEmpty() || queue1.peek() >= num) {
                queue1.add(num);
            } else {
                queue2.add(num);
            }

            if (queue1.size() > queue2.size() + 1) {
                queue2.add(queue1.poll());
            } else if (queue2.size() > queue1.size()) {
                queue1.add(queue2.poll());
            }
        }
    }
}
