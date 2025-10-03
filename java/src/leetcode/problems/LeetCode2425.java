package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 7/29/25 13:05
 * @description 展开 观察规律
 */
public class LeetCode2425 {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int res = 0;
        if (n % 2 != 0) {
            for (int j : nums1) {
                res ^= j;
            }
        }
        if (m % 2 != 0) {
            for (int j : nums2) {
                res ^= j;
            }
        }
        return res;
    }
}
