package leetcode;

import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/15 22:51
 */
public class LeetCode4 {

    PriorityQueue<Integer> q1;
    PriorityQueue<Integer> q2;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        q1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
        q2 = new PriorityQueue<>();
        add(nums1);
        add(nums2);
        if (q1.size() > q2.size()) {
            return q1.peek();
        }
        return ((double) q1.peek() + q2.peek()) / 2;
    }

    private void add(int[] nums) {
        for (int num : nums) {
            if (q1.isEmpty() || num <= q1.peek()) {
                q1.offer(num);
                if (q2.size() + 1 < q1.size()) {
                    q2.offer(q1.poll());
                }
            } else {
                q2.offer(num);
                if (q1.size() < q2.size()) {
                    q1.offer(q2.poll());
                }
            }
        }
    }
}
