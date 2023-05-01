package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-18 6:57 PM
 */
public class LeetCode303 {

    class NumArray {

        int[] sums;

        public NumArray(int[] nums) {
            int n = nums.length;
            sums = new int[n + 1];
            for (int i = 1; i < sums.length; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return sums[j + 1] - sums[i];
        }
    }
}
