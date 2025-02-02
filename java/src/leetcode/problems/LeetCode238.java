package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/25 14:57
 */
public class LeetCode238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        int t = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * t;
            t *= nums[i];
        }
        return ans;
    }
}
