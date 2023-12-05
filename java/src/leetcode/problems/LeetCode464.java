package leetcode.problems;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/5 22:09
 * @description 状态压缩DP
 * @description 博弈 枚举每次取数字能不能赢，对方赢不了就是自己能赢
 */
public class LeetCode464 {

    private Boolean[] memo;
    private int maxChoosableInteger, total;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        memo = new Boolean[1 << maxChoosableInteger];
        this.maxChoosableInteger = maxChoosableInteger;
        total = desiredTotal;
        return this.maxChoosableInteger * (this.maxChoosableInteger + 1) / 2 >= total && dfs(0);
    }

    private Boolean dfs(int cur) {
        if (memo[cur] != null) {
            return memo[cur];
        }
        int sum = 0;
        for (int i = 0; i < maxChoosableInteger; i++) {
            if (((cur >> i) & 1) == 1) {
                sum += i + 1;
            }
        }
        for (int i = 0; i < maxChoosableInteger; i++) {
            if (((cur >> i) & 1) == 0) {//该数字未被取过
                if (sum + i + 1 >= total ||
                        !dfs(cur | (1 << i))) {// 标记被取过
                    memo[cur] = true;
                    return true;
                }
            }
        }
        memo[cur] = false;
        return false;
    }

    public boolean canIWin_v1(int maxChoosableInteger, int desiredTotal) {
        HashSet<Integer> choosable = new HashSet<>();
        for (int i = 1; i <= maxChoosableInteger; ++i) {
            choosable.add(i);
        }
        return dfs(choosable, 0, desiredTotal);
    }

    public boolean dfs(HashSet<Integer> choosable, int sum, int desiredTotal) {
        for (int x : new HashSet<>(choosable)) {
            if (sum + x >= desiredTotal) {
                return true;
            }
            HashSet<Integer> copy = new HashSet<>(choosable);
            copy.remove(x);
            if (!dfs(copy, sum + x, desiredTotal)) {
                return true;
            }
        }
        return false;
    }
}
