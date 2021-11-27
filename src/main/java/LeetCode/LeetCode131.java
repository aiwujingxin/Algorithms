package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-07-10 3:31 下午
 */
public class LeetCode131 {


    boolean[][] dp;
    int n;
    List<List<String>> res = new ArrayList<>();
    List<String> ans = new ArrayList<>();


    public List<List<String>> partition(String s) {

        if (s == null || s.length() == 0) {
            return res;
        }

        n = s.length();
        dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int i) {
        if (i == n) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (dp[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
