package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/5 22:09
 * @description 状态压缩DP
 * @description 博弈 枚举每次取数字能不能赢，对方赢不了就是自己能赢
 */
public class LeetCode464 {

    private Boolean[] memo;
    private int maxChoosableInteger;
    private int desiredTotal;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        memo = new Boolean[1 << maxChoosableInteger + 1];
        this.maxChoosableInteger = maxChoosableInteger;
        this.desiredTotal = desiredTotal;
        if (this.maxChoosableInteger >= this.desiredTotal) {
            return true;
        }
        if (this.maxChoosableInteger * (this.maxChoosableInteger + 1) / 2 < this.desiredTotal) {
            return false;
        }
        return dfs(0, 0);
    }

    private Boolean dfs(int status, int sum) {
        if (sum >= desiredTotal) {
            memo[status] = false;
            return false;
        }
        if (memo[status] != null) {
            return memo[status];
        }
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (((status >> i) & 1) == 1) {
                continue;
            }
            int next = status | (1 << i);
            if ((sum + i >= desiredTotal || !dfs(next, sum + i))) {
                memo[status] = true;
                return true;
            }
        }
        memo[status] = false;
        return false;
    }
}
