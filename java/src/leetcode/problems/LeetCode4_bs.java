package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 4/18/25 00:55
 */
public class LeetCode4_bs {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2; // 左半部分的总长度
        int left = 0;
        int right = m;
        while (left <= right) {
            int partitionA = (left + right) / 2;
            int partitionB = totalLeft - partitionA;
            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int minRightA = (partitionA == m) ? Integer.MAX_VALUE : nums1[partitionA];
            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int minRightB = (partitionB == n) ? Integer.MAX_VALUE : nums2[partitionB];
            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {  // 找到正确的分割点
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                right = partitionA - 1; // 减少 partitionA
            } else {
                left = partitionA + 1; // 增加 partitionA
            }
        }
        return -1;
    }
}
