package leetcode.topinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/24 19:27
 */
public class LeetCode131 {

    //study
    //分两步
    boolean[][] dp;
    int n;
    List<List<String>> ans = new ArrayList<>();
    List<String> list = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        n = s.length();
        dp = new boolean[s.length()][s.length()];
        for (boolean[] d : dp) {
            Arrays.fill(d, true);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        dfs(s, 0);
        return ans;
    }

    private void dfs(String s, int i) {

        if (i == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j < n; j++) {
            if (dp[i][j]) {
                list.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
