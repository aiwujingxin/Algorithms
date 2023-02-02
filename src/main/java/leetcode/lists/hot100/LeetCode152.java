package leetcode.lists.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/4 17:03
 */
public class LeetCode152 {

    //https://www.youtube.com/watch?v=0Kpz-ChuQIE

    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxF = nums[0], minF = nums[0], ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int mx = maxF, mn = minF;
            maxF = Math.max(nums[i], Math.max(mx * nums[i], mn * nums[i]));
            minF = Math.min(nums[i], Math.min(mx * nums[i], mn * nums[i]));
            ans = Math.max(ans, maxF);
        }
        return ans;
    }
}
