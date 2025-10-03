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
        return (maxQ.size() > minQ.size()) ? maxQ.peek() : (maxQ.peek() + minQ.peek()) / 2.0;
    }

    public void add(int[] nums) {
        for (int num : nums) {
            if (maxQ.isEmpty() || num <= maxQ.peek()) {
                maxQ.add(num);
            } else {
                minQ.add(num);
            }
            if (maxQ.size() < minQ.size()) {
                maxQ.add(minQ.poll());
            }
            if (maxQ.size() > minQ.size() + 1) {
                minQ.add(maxQ.poll());
            }
        }
    }

    public double findMedianSortedArrays_bs(int[] A, int[] B) {
        if (A.length > B.length) return findMedianSortedArrays_bs(B, A);
        int m = A.length, n = B.length, h = (m + n + 1) / 2;
        int l = 0, r = m;
        while (l <= r) {
            int i = (l + r) / 2, j = h - i;
            int al = i == 0 ? Integer.MIN_VALUE : A[i - 1];
            int ar = i == m ? Integer.MAX_VALUE : A[i];
            int bl = j == 0 ? Integer.MIN_VALUE : B[j - 1];
            int br = j == n ? Integer.MAX_VALUE : B[j];
            if (al <= br && bl <= ar) {
                return ((m + n) % 2 == 1) ? Math.max(al, bl) : (Math.max(al, bl) + Math.min(ar, br)) / 2.0;
            } else if (al > br) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        return -1;
    }
}
