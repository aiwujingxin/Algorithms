package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/23 17:26
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
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);
            }
        }
        List<List<String>> res = new ArrayList<>();
        backtrack(dp, s, 0, res, new ArrayList<>());
        return res;
    }

    private void backtrack(boolean[][] dp, String s, int index, List<List<String>> res, List<String> list) {
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        int n = dp.length;
        for (int i = index; i < s.length(); i++) {
            if (dp[index][i]) {
                list.add(s.substring(index, i + 1));
                backtrack(dp, s, i + 1, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
