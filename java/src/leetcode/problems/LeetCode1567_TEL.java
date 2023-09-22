package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/10 19:19
 */
public class LeetCode1567_TEL {

    public static void main(String[] args) {
        System.out.println(new LeetCode1567_TEL().getMaxLen(new int[]{1, -2, -3, 4}));
        System.out.println(new LeetCode1567_TEL().getMaxLen(new int[]{0, 1, -2, -3, -4}));
        System.out.println(new LeetCode1567_TEL().getMaxLen(new int[]{-1, -2, -3, 0, 1}));
    }

    public int getMaxLen(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 && nums[0] > 0) {
            return 1;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0] > 0 ? 1 : 0;
        int max = 0;

        for (int i = 1; i < nums.length; i++) {
            int n_count = nums[i] < 0 ? 1 : 0;
            int temp = nums[i] > 0 ? 1 : 0;
            if (nums[i] == 0) {
                dp[i] = dp[i - 1];
                continue;
            }
            // 这个地方存在重复计算， 可以优化的
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < 0) {
                    n_count++;
                }
                if (nums[j] == 0) {
                    dp[i] = temp;
                    break;
                }

                if (n_count % 2 == 0) {
                    temp = Math.max(temp, i - j + 1);
                }
            }
            dp[i] = temp == 0 ? dp[i - 1] : temp;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
