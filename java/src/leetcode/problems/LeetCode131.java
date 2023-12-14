package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/14 17:13
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
        backtrack(dp, 0, s, res, new ArrayList<>());
        return res;
    }

    private void backtrack(boolean[][] dp, int index, String s, List<List<String>> res, List<String> list) {
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = index; j < s.length(); j++) {
            if (dp[index][j]) {
                list.add(s.substring(index, j + 1));
                backtrack(dp, j + 1, s, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
