package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/17 14:56
 */
public class LeetCode152 {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxF = nums[0], minF = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            int mx = maxF;
            int mn = minF;
            maxF = Math.max(Math.max(nums[i], nums[i] * mx), nums[i] * mn);
            minF = Math.min(Math.min(nums[i], nums[i] * mx), nums[i] * mn);
            res = Math.max(res, Math.max(maxF, minF));
        }
        return res;
    }
}


