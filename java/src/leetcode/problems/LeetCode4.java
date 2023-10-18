package leetcode.problems;

import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 11:28
 */
public class LeetCode4 {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(10);
        System.out.println(queue.poll());
    }

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
        return ((double) q1.peek() + (double) q2.peek()) / 2;
    }

    private void add(int[] nums) {
        for (int num : nums) {
            //确保有序
            if (q1.isEmpty() || num <= q1.peek()) {
                q1.add(num);
                //确保平分
                if (q2.size() + 1 < q1.size()) {
                    q2.add(q1.poll());
                }
            } else {
                q2.add(num);
                if (q1.size() < q2.size()) {
                    q1.add(q2.poll());
                }
            }
        }
    }
}
