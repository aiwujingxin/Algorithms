package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/4 10:51
 * <a href="https://leetcode.cn/problems/flip-string-to-monotone-increasing/solutions/1593843/by-ac_oier-h0we/"></a>
 */
public class LeetCode926 {

    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[][] dp = new int[n][2];
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[0][1] = s.charAt(0) == '0' ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][0]);
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1] + 1);
            }
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }

    public int minFlipsMonoIncr_LIS(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int len = 0;
        for (char c : s.toCharArray()) {
            int num = c - '0';
            int l = 0, r = len;
            while (l < r) {
                int mid = (l + r) / 2;
                if (dp[mid] <= num) l = mid + 1;
                else r = mid;
            }
            if (len == r) {
                len++;
            }
            dp[l] = num;
        }
        return n - len;
    }

    public int minFlipsMonoIncr_pre(String ss) {
        char[] cs = ss.toCharArray();
        int n = cs.length, ans = n;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + (ss.charAt(i - 1) - '0');
        }
        for (int i = 1; i <= n; i++) {
            int l = s[i - 1];                // 左边有多少个1
            int r = (n - i) - (s[n] - s[i]); // 右边边有多少个0
            ans = Math.min(ans, l + r);
        }
        return ans;
    }
}
