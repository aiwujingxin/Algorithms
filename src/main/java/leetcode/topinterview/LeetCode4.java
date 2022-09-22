package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/21 01:40
 */
public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int n1 = nums1.length;
        final int n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int l = 0;
        int r = n1;
        while (l <= r) {
            int cutA = (l + r) / 2;
            int cutB = (n1 + n2 + 1) / 2 - cutA;
            final int L1 = cutA == 0 ? Integer.MIN_VALUE : nums1[cutA - 1];
            final int L2 = cutB == 0 ? Integer.MIN_VALUE : nums2[cutB - 1];
            final int R1 = cutA == n1 ? Integer.MAX_VALUE : nums1[cutA];
            final int R2 = cutB == n2 ? Integer.MAX_VALUE : nums2[cutB];
            if (L1 > R2) {
                r = cutA - 1;
            } else if (L2 > R1) {
                l = cutA + 1;
            } else {
                return (n1 + n2) % 2 == 0 ? (Math.max(L1, L2) + Math.min(R1, R2)) * 0.5 : Math.max(L1, L2);
            }
        }
        return -1;
    }
}
