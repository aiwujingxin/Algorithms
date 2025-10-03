package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/5 22:09
 * @description 状态压缩DP
 * @description 博弈 枚举每次取数字能不能赢，对方赢不了就是自己能赢
 */
public class LeetCode464 {

    public boolean canIWin(int max, int target) {
        if (max >= target) return true;
        if (max * (max + 1) / 2 < target) return false;
        return dfs(0, 0, max, target, new Boolean[1 << (max + 1)]);
    }

    private boolean dfs(int used, int sum, int max, int target, Boolean[] memo) {
        if (memo[used] != null) return memo[used];
        for (int i = 1; i <= max; i++) {
            if ((used & (1 << i)) != 0) continue;
            if (sum + i >= target || !dfs(used | (1 << i), sum + i, max, target, memo)) {
                return memo[used] = true;
            }
        }
        return memo[used] = false;
    }
}
