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
        memo = new Boolean[1 << maxChoosableInteger];
        this.maxChoosableInteger = maxChoosableInteger;
        this.desiredTotal = desiredTotal;
        return this.maxChoosableInteger * (this.maxChoosableInteger + 1) / 2 >= this.desiredTotal && dfs(0);
    }

    private Boolean dfs(int cur) {
        if (memo[cur] != null) {
            return memo[cur];
        }
        int sum = 0;
        for (int i = 0; i < maxChoosableInteger; i++) {
            if (((cur >> i) & 1) == 1) { // 已被取过的数字和
                sum += i + 1;
            }
        }
        for (int i = 0; i < maxChoosableInteger; i++) {
            if (((cur >> i) & 1) == 0) {//该数字未被取过
                if (sum + (i + 1) >= desiredTotal || !dfs(cur | (1 << i))) {// 标记被取过
                    memo[cur] = true;
                    return true;
                }
            }
        }
        memo[cur] = false;
        return false;
    }
}
