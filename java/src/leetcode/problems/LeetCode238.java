package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/25 14:57
 * @see LeetCode2906
 */
public class LeetCode238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = suffix;
            suffix = suffix * nums[i];
        }
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = ans[i] * prefix;
            prefix = prefix * nums[i];
        }
        return ans;
    }
}
