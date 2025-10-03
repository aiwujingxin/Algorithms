package knowledge.algorithms.dp.intervaldp.problems;

import java.util.Scanner;

/**
 * @author wujingxinit@outlook.com
 * @date 7/6/25 13:15
 * @description 括号区间匹配 <a href="https://www.nowcoder.com/practice/e391767d80d942d29e6095a935a5b96b"></a>
 * 给定一个由 '[' ，']'，'('，‘)’ 组成的字符串，请问最少插入多少个括号就能使这个字符串的所有括号左右配对。
 * 例如当前串是 "([[])"，那么插入一个']'即可满足。
 */
public class ValidParentheses {

    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            int n = s.length();
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = 1;
            }
            for (int i = n - 2; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    // 两种情况 非互斥
                    // 情况1：s[i] 和 s[j] 是一对匹配括号
                    if (isMatch(s.charAt(i), s.charAt(j))) {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    // 情况2：枚举断点分割
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
            System.out.println(dp[0][n - 1]);
        }

        private static boolean isMatch(char left, char right) {
            return (left == '(' && right == ')') ||
                    (left == '[' && right == ']') ||
                    (left == '{' && right == '}');
        }
    }
}
