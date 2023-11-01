package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/1 23:33
 */
public class LeetCode140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        int n = s.length();
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        List<String> res = new ArrayList<>();
        if (dp[n]) {
            backtrack(s, n, set, dp, new ArrayDeque<>(), res);
            return res;
        }
        return res;
    }


    private void backtrack(String s, int len, Set<String> wordSet, boolean[] dp, Deque<String> path, List<String> res) {
        if (len == 0) {
            res.add(String.join(" ", path));
            return;
        }
        for (int i = len - 1; i >= 0; i--) {
            String suffix = s.substring(i, len);
            if (wordSet.contains(suffix) && dp[i]) {
                path.addFirst(suffix);
                backtrack(s, i, wordSet, dp, path, res);
                path.removeFirst();
            }
        }
    }
}
