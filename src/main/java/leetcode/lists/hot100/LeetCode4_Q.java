package leetcode.lists.hot100;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/13 01:26
 */
public class LeetCode4_Q {
    PriorityQueue<Integer> q1;
    PriorityQueue<Integer> q2;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        q1 = new PriorityQueue<>();
        q2 = new PriorityQueue<>((x1, x2) -> x2 - x1);
        for (int i : nums1) {
            q1.add(i);
            q2.add(q1.poll());
            if (q1.size() + 1 < q2.size()) {
                q1.add(q2.poll());
            }
        }
        for (int i : nums2) {
            q1.add(i);
            q2.add(q1.poll());
            if (q1.size() + 1 < q2.size()) {
                q1.add(q2.poll());
            }
        }
        if (q1.size() == q2.size()) {
            return (q1.peek() + q2.peek()) / 2.0;
        } else {
            return q2.peek();
        }
    }
}
