package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/8 17:20
 * <a href="https://www.youtube.com/watch?v=G3Pq0IUvkY4">...</a>
 */
public class LeetCode44 {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    // 比较耗时的写法
//                    for (int k = 0; k <= i; k++) {
//                        if (dp[k][j - 1]) {
//                            dp[i][j] = true;
//                            break;
//                        }
//                    }
                    // "*" 不用 || 用(用的时候，采用的递归的思想,隐含的把 for 循环给实现了)
                    //严谨证明：
                    //我们知道，当p[j]=='*'的前提下，我们有dp[i][j] = dp[0][j-1] || dp[1][j-1] || dp[2][j-1] || ... || dp[i-1][j-1] || dp[i][j-1]
                    //在上式中，将i用i-1替换，就同理可以写出dp[i-1][j] = dp[0][j-1] || dp[1][j-1] || dp[2][j-1] || ... || dp[i-1][j-1]
                    //用第二式替换第一式右边的大部分项，就有dp[i][j] = dp[i-1][j] || dp[i][j-1]. 惊喜不惊喜？
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
