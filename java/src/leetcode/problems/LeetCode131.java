package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/30 21:51
 */
public class LeetCode131 {

    public List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
            }
        }
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res, dp);
        return res;
    }

    private void backtrack(String s, int index, List<String> list, List<List<String>> res, boolean[][] dp) {
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (dp[index][i]) {
                list.add(s.substring(index, i + 1));
                backtrack(s, i + 1, list, res, dp);
                list.remove(list.size() - 1);
            }
        }
    }
}
