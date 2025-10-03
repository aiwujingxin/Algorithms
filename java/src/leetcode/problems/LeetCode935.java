package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/2/25 13:24
 */
public class LeetCode935 {

    private static final int MOD = 1_000_000_007;
    private static final int MX = 5000;
    private static final int[][] NEXT = {
            {4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}
    };

    private static final int[][] dp = new int[MX][10];

    static {
        for (int j = 0; j < 10; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < MX; i++) {      // 枚举移动次数
            for (int j = 0; j < 10; j++) {  // 枚举单元格
                for (int k : NEXT[j]) {     // 遍历下一个合法位置
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                }
            }
        }
    }

    public int knightDialer(int n) {
        int ans = 0;
        for (int j = 0; j < 10; j++) { // 累加所有的可能
            ans = (ans + dp[n - 1][j]) % MOD;
        }
        return ans;
    }
}
