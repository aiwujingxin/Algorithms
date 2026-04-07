package leetcode.problems;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/6 17:25
 */
public class LeetCode4 {

    Queue<Integer> L = new PriorityQueue<>((a, b) -> b - a);
    Queue<Integer> R = new PriorityQueue<>();

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        add(nums1);
        add(nums2);
        return (L.size() > R.size()) ? L.peek() : (L.peek() + R.peek()) / 2.0;
    }

    public void add(int[] nums) {
        for (int num : nums) {
            if (L.size() == R.size()) {
                R.add(num);
                L.add(R.poll());
            } else {
                L.add(num);
                R.add(L.poll());
            }
        }
    }

    class Solution_bs {

        public double findMedianSortedArrays(int[] A, int[] B) {
            int m = A.length;
            int n = B.length;
            if (n < m) {
                return findMedianSortedArrays(B, A);
            }
            int totalLen = m + n;
            int half = (m + n) / 2;
            int l = 0;
            int r = m;
            while (l <= r) {
                int c1 = l + r >> 1;
                int c2 = half - c1;
                int L1 = c1 == 0 ? Integer.MIN_VALUE : A[c1 - 1];
                int R1 = c1 == m ? Integer.MAX_VALUE : A[c1];
                int L2 = c2 == 0 ? Integer.MIN_VALUE : B[c2 - 1];
                int R2 = c2 == n ? Integer.MAX_VALUE : B[c2];
                if (L1 <= R2 && L2 <= R1) {
                    if (totalLen % 2 == 0) {
                        return ((double) Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                    }
                    return Math.min(R1, R2);
                } else if (L1 > R2) {
                    r = c1 - 1;
                } else {
                    l = c1 + 1;
                }
            }
            return -1;
        }
    }
}
