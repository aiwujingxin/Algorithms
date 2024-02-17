package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/8 16:40
 */
public class LeetCode2981 {

    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long sum2 = 0;
        int zero1 = 0;
        int zero2 = 0;
        for (int j : nums1) {
            sum1 += j;
            if (j == 0) {
                zero1++;
            }
        }
        for (int j : nums2) {
            sum2 += j;
            if (j == 0) {
                zero2++;
            }
        }
        long minSum1 = sum1 + zero1, minSum2 = sum2 + zero2;
        if (zero1 == 0 && minSum1 < minSum2 || zero2 == 0 && minSum1 > minSum2) {
            return -1;
        }
        return Math.max(minSum1, minSum2);
    }
}
