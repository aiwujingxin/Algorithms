package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-07-10 3:31 下午
 */
public class LeetCode131 {

    List<List<String>> list = new ArrayList<>();
    boolean[][] dp;

    public List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        int n = s.length();
        dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j < 3 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }
        backtrack(s, 0, new ArrayList<>());
        return list;
    }

    private void backtrack(String s, int i, ArrayList<String> temp) {
        if (i == s.length()) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int j = i; j < s.length(); ++j) {
            if (dp[i][j]) {
                temp.add(s.substring(i, j + 1));
                backtrack(s, j + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
