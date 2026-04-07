package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/25 17:49
 */
public class LeetCode647 {

    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    class Solution_Center {

        public int countSubstrings(String s) {
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                cnt += extendPalindrome(s, i, i);
                cnt += extendPalindrome(s, i, i + 1);
            }
            return cnt;
        }

        private int extendPalindrome(String s, int i, int j) {
            int cnt = 0;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                cnt++;
                i--;
                j++;
            }
            return cnt;
        }
    }

    class Solution_Manacher {
        public int countSubstrings(String s) {
            char[] chs = s.toCharArray();
            int n = chs.length * 2 + 1;
            char[] t = new char[n];
            for (int i = 0; i < chs.length; i++) {
                t[i * 2] = '#';
                t[i * 2 + 1] = chs[i];
            }
            t[n - 1] = '#';
            int[] d = new int[n];
            int c = 0, r = 0;
            int totalCount = 0; // 用于累加所有回文子串的数量
            for (int i = 0; i < n; i++) {
                // 加速盒子
                d[i] = r > i ? Math.min(d[2 * c - i], r - i) : 0;
                // 中心扩展
                while (i - d[i] - 1 >= 0 && i + d[i] + 1 < n &&
                        t[i - d[i] - 1] == t[i + d[i] + 1]) {
                    d[i]++;
                }
                // 更新最右边界
                if (i + d[i] > r) {
                    c = i;
                    r = i + d[i];
                }
                totalCount += (d[i] + 1) / 2;
            }
            return totalCount;
        }
    }
}
