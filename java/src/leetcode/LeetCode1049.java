package leetcode;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/2/23 23:15
 * <a href="https://leetcode.cn/problems/last-stone-weight-ii/solution/gong-shui-san-xie-xiang-jie-wei-he-neng-jgxik/">...</a>
 * 可以转化为: <a href="https://www.lintcode.com/problem/92/description">...</a>
 * <a href="https://www.lintcode.com/problem/92/solution/17247">题解</a>
 */
public class LeetCode1049 {

    public int lastStoneWeightII(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i : nums) sum += i;
        int target = sum / 2;
        int[][] f = new int[n + 1][target + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= nums[i - 1]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - nums[i - 1]] + nums[i - 1]);
                }
            }
        }
        return Math.abs(sum - f[n][target] - f[n][target]);
    }
}
