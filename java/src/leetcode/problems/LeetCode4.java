package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/6 17:25
 */
public class LeetCode4 {

    Queue<Integer> minQ = new PriorityQueue<>();
    Queue<Integer> maxQ = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        add(nums1);
        add(nums2);
        if (maxQ.size() > minQ.size()) {
            return (double) maxQ.peek();
        }
        return ((double) maxQ.peek() + minQ.peek()) / 2;
    }

    public void add(int[] nums) {
        for (int num : nums) {
            if (maxQ.isEmpty() || maxQ.peek() >= num) {
                maxQ.add(num);
            } else {
                minQ.add(num);
            }
            if (maxQ.size() < minQ.size()) {
                maxQ.add(minQ.poll());
            } else if (minQ.size() + 1 < maxQ.size()) {
                minQ.add(maxQ.poll());
            }
        }
    }
}
