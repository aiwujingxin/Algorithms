package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/7 17:40
 */
public class LeetCode303 {

    class NumArray {

        int[] presum;

        public NumArray(int[] nums) {
            presum = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                presum[i] = presum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return presum[right + 1] - presum[left];
        }
    }
}
