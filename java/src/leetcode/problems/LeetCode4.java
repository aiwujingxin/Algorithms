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
            if (A.length > B.length) return findMedianSortedArrays(B, A);
            int m = A.length;
            int n = B.length;
            // 搜索空间 [0,m]
            int l = 0;
            int r = m;
            int leftTotal = (m + n + 1) / 2;
            int MIN = Integer.MIN_VALUE;
            int MAX = Integer.MAX_VALUE;
            while (l <= r) {
                int i = l + r >> 1;
                int j = leftTotal - i;
                int L1 = i == 0 ? MIN : A[i - 1];
                int R1 = i == m ? MAX : A[i];
                int L2 = j == 0 ? MIN : B[j - 1];
                int R2 = j == n ? MAX : B[j];
                if (L1 <= R2 && L2 <= R1) {
                    if ((m + n) % 2 == 1) return Math.max(L1, L2);
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                } else if (L1 > R2) r = i - 1;
                else l = i + 1;
            }
            return -1;
        }
    }
}
