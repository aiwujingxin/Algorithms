package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/8 23:01
 * <a href="https://leetcode.cn/problems/valid-palindrome-iii/solution/javazi-di-xiang-shang-dong-tai-gui-hua-b-u3a4/">...</a>
 * <a href="https://www.youtube.com/watch?v=Xfk2lEByP9M">区间DP</a>
 */
public class LeetCode1216 {
    public boolean isValidPalindrome(String s, int k) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] dp = new int[n][n];

        //第一重循环控制长度
        for (int len = 2; len <= n; len++) {
            //第二重循环控制左端点
            for (int l = 0; l < n; l++) {
                //计算右端点
                int r = l + len - 1;
                //处理越界情况
                if (r >= n) {
                    continue;
                }
                //考虑最坏情况：减小一位的字串是k回文，当前字串是k + 1回文
                dp[l][r] = Math.min(dp[l + 1][r], dp[l][r - 1]) + 1;
                //如果两端相等，两端各减少一
                if (c[l] == c[r]) {
                    dp[l][r] = Math.min(dp[l][r], dp[l + 1][r - 1]);
                }
            }
        }
        //判断是否 小于等于 k 即可
        return dp[0][n - 1] <= k;
    }
}