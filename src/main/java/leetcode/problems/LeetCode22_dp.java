package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/3 15:10
 */
public class LeetCode22_dp {

    public List<String> generateParenthesis(int n) {
        List<String>[] dp = new List[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[0].add("");

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                for (String str1 : dp[j]) {
                    for (String str2 : dp[i - j - 1]) {
                        dp[i].add("(" + str2 + ")" + str1);
                    }
                }
            }
        }
        return dp[n];
    }
}
