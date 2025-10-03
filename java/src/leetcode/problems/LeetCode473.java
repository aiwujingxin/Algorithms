package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/1 23:53
 */
public class LeetCode473 {

    class Solution_ball {
        // 站在"火柴"的角度（逐个放置火柴）
        // 比较难记忆化
        public boolean makesquare(int[] matchsticks) {
            int sum = 0;
            for (int matchstick : matchsticks) {
                sum += matchstick;
            }
            if (sum % 4 != 0) {
                return false;
            }
            Arrays.sort(matchsticks);
            reverse(matchsticks);
            return backtrack(matchsticks, 0, new int[4], sum / 4);
        }

        private boolean backtrack(int[] nums, int index, int[] edges, int target) {
            if (index == nums.length) {
                return true;
            }
            for (int i = 0; i < edges.length; i++) {
                if (i > 0 && edges[i] == edges[i - 1]) {
                    continue;
                }
                if (edges[i] + nums[index] > target) {
                    continue;
                }
                edges[i] += nums[index];
                if (backtrack(nums, index + 1, edges, target)) {
                    return true;
                }
                edges[i] -= nums[index];
            }
            return false;
        }
    }

    public void reverse(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    class Solution_box { // （边角度）

        public boolean makesquare(int[] matchsticks) {
            int n = matchsticks.length;
            int sum = Arrays.stream(matchsticks).sum();
            if (sum % 4 != 0) return false;
            int target = sum / 4;
            // 排序优化：从大到小尝试
            matchsticks = Arrays.stream(matchsticks).boxed().sorted((a, b) -> b - a).mapToInt(Integer::intValue).toArray();
            if (matchsticks[0] > target) return false;
            Boolean[] memo = new Boolean[1 << n];
            return dfs(0, 0, 0, matchsticks, target, memo);
        }

        private boolean dfs(int mask, int sideIndex, int sum, int[] sticks, int target, Boolean[] memo) {
            if (memo[mask] != null) return memo[mask];
            if (sideIndex == 4) return true; // 完成四条边
            if (sum == target) { // 完成一条边，开始下一条边
                return memo[mask] = dfs(mask, sideIndex + 1, 0, sticks, target, memo);
            }
            for (int i = 0; i < sticks.length; i++) {
                if ((mask & (1 << i)) != 0) continue; // 火柴已使用
                if (sum + sticks[i] > target) continue;
                if (dfs(mask | (1 << i), sideIndex, sum + sticks[i], sticks, target, memo)) {
                    return memo[mask] = true;
                }
                // 修正：在回溯后跳过相同长度的火柴
                while (i + 1 < sticks.length && sticks[i + 1] == sticks[i]) {
                    i++;
                }
            }
            return memo[mask] = false;
        }
    }
}
