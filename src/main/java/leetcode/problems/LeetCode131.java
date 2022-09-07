package leetcode.problems;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-07-10 3:31 下午
 */
public class LeetCode131 {

    public static void main(String[] args) {
        System.out.println(new LeetCode131().partition("aabbccpoopc"));
    }


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

        // init
        //为什么i要倒序遍历？因为dp[i][j] 需要用到dp[i + 1][j - 1]的结果，前提是dp[i + 1][j - 1]已经被处理过。
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                //  dp[i + 1][j - 1] 去掉了头尾字符串的子串
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }
        PrintUtil.print(dp);
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
