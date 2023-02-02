package leetcode.lists.hot100;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/13 00:52
 */
public class LeetCode4_binarysearch {
    //https://www.youtube.com/watch?v=ScCg9v921ns&t=604s
    /*
                   L1  R1
       A: 2  4  6  7  10

                 L2  R2
       B: 1  3   5   8  9  11  12  13  14
       */
    // L1 <= R2
    // L2 <= R1
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int n1 = nums1.length;
        final int n2 = nums2.length;
        final int len = n1 + n2;
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int l = 0;
        int r = n1;

        while (l <= r) {
            final int cutA = (l + r) / 2;
            final int cutB = (len + 1) / 2 - cutA; //左半边比右半边多一个元素
            final int L1 = cutA == 0 ? Integer.MIN_VALUE : nums1[cutA - 1];
            final int L2 = cutB == 0 ? Integer.MIN_VALUE : nums2[cutB - 1];
            final int R1 = cutA == n1 ? Integer.MAX_VALUE : nums1[cutA];
            final int R2 = cutB == n2 ? Integer.MAX_VALUE : nums2[cutB];
            if (L1 <= R2 && L2 <= R1) {
                return (n1 + n2) % 2 == 0 ? (Math.max(L1, L2) + Math.min(R1, R2)) * 0.5 : Math.max(L1, L2);
            } else if (L1 > R2) {
                r = cutA - 1;
            } else if (L2 > R1) {
                l = cutA + 1;
            }
        }
        return -1;
    }
}
