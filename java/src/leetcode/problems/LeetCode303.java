package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/7 17:40
 */
public class LeetCode303 {

    class NumArray {
        int[] s;

        public NumArray(int[] nums) {
            int n = nums.length;
            s = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                s[i] = s[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return s[right + 1] - s[left];
        }
    }
}
