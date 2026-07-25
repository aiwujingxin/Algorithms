package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/17 11:10
 */
public class LeetCode131 {

    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
            }
        }
        List<List<String>> res = new ArrayList<>();
        backtrack(s, dp, 0, res, new ArrayList<>());
        return res;
    }

    private void backtrack(String s, boolean[][] dp, int index, List<List<String>> res, List<String> list) {
        if (index == dp.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < dp.length; i++) {
            if (dp[index][i]) {
                list.add(s.substring(index, i + 1));
                backtrack(s, dp, i + 1, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
