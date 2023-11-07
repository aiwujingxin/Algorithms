package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/8 23:01
 * <a href="https://leetcode.cn/problems/valid-palindrome-iii/solution/javazi-di-xiang-shang-dong-tai-gui-hua-b-u3a4/">...</a>
 * <a href="https://www.youtube.com/watch?v=Xfk2lEByP9M">区间DP</a>
 * <p>
 * @see LeetCode516
 * @see LeetCode312
 */
public class LeetCode1216 {
    public boolean isValidPalindrome(String s, int k) {
        char[] c = s.toCharArray();
        int len = c.length;
        int[][] dp = new int[len][len];

        //第一重循环控制长度
        for (int l = 2; l <= len; l++) {
            //第二重循环控制左端点
            for (int left = 0; left < len; left++) {
                //计算右端点
                int right = left - 1 + l;
                //处理越界情况
                if (right >= len) {
                    continue;
                }
                //考虑最坏情况：减小一位的字串是k回文，当前字串是k + 1回文
                dp[left][right] = Math.min(dp[left + 1][right], dp[left][right - 1]) + 1;
                //如果两端相等，两端各减少一
                if (c[left] == c[right]) {
                    dp[left][right] = Math.min(dp[left][right], dp[left + 1][right - 1]);
                }
            }
        }
        //判断是否 小于等于 k 即可
        return dp[0][len - 1] <= k;
    }
}