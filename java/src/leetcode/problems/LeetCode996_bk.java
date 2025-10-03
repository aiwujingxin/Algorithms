package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 9/25/25 15:05
 */
public class LeetCode996_bk {

    private int result = 0;
    private int[] nums;
    private int n;

    public int numSquarefulPerms(int[] nums) {
        this.n = nums.length;
        if (n == 0) {
            return 0;
        }
        this.nums = nums;
        // 关键一步：排序，为处理重复数字做准备
        Arrays.sort(this.nums);
        boolean[] used = new boolean[n];
        backtrack(0, 0, used);
        return result;
    }

    private void backtrack(int count, int prev, boolean[] used) {
        if (count == n) {
            result++;
            return;
        }
        for (int i = 0; i < n; i++) {
            // 3. 剪枝判断
            // 剪枝1: 如果当前数字已经被使用，跳过
            if (used[i]) {
                continue;
            }
            // 剪枝2: (处理重复数字)
            // 如果当前数字与前一个数字相同，并且前一个数字还未使用，则跳过。
            // 这保证了对于重复的数字，我们总是按从左到右的顺序使用它们。
            // 例如对于 [2, 2, 2]，我们不会在第一个2还没用的情况下就去用第二个2。
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            // 剪枝3: 如果不是第一个数，并且和前一个数的和不是完全平方数，跳过
            if (count > 0 && !isPerfectSquare(prev + nums[i])) {
                continue;
            }
            used[i] = true;
            backtrack(count + 1, nums[i], used);
            used[i] = false;
        }
    }

    // 检查一个数是否是完全平方数
    private boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
