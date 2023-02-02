package leetcode.plan.dp.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/7 16:51
 */
public class LeetCode213 {

    public static void main(String[] args) {
        System.out.println(new LeetCode213().rob(new int[]{1, 2, 3, 1}));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, 1, nums.length - 1), rob(nums, 0, nums.length - 2));
    }

    public int rob(int[] nums, int start, int end) {
        int[] arr = new int[nums.length - 1];
        int index = 0;
        while (start <= end) {
            arr[index] = nums[start];
            index++;
            start++;
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}
