package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/11/26 22:14
 */
public class LeetCode279_dfs_TEL {

    public int numSquares(int n) {
        if (n < 4)
            return n;

        int ans = n;

        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            ans = Math.min(ans, 1 + numSquares(n - square));
        }

        return ans;
    }

}
