package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/8 23:01
 * <a href="https://leetcode.cn/problems/valid-palindrome-iii/solution/javazi-di-xiang-shang-dong-tai-gui-hua-b-u3a4/">...</a>
 * <a href="https://www.youtube.com/watch?v=Xfk2lEByP9M">区间DP</a>
 * <p>
 */
public class LeetCode1216 {
    public boolean isValidPalindrome(String s, int k) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] dp = new int[n][n];

        //第一重循环控制长度
        for (int i = 2; i <= n; i++) {
            //第二重循环控制左端点
            for (int j = 0; j < n; j++) {
                //计算右端点
                int right = j + i - 1;
                //处理越界情况
                if (right >= n) {
                    continue;
                }
                //考虑最坏情况：减小一位的字串是k回文，当前字串是k + 1回文
                dp[j][right] = Math.min(dp[j + 1][right], dp[j][right - 1]) + 1;
                //如果两端相等，两端各减少一
                if (c[j] == c[right]) {
                    dp[j][right] = Math.min(dp[j][right], dp[j + 1][right - 1]);
                }
            }
        }
        //判断是否 小于等于 k 即可
        return dp[0][n - 1] <= k;
    }
}