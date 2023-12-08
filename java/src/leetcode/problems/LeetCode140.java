package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/1 23:33
 * @see LeetCode139
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
        if (!dp[n]) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        backtrack(s, n, set, dp, new ArrayDeque<>(), res);
        return res;
    }


    private void backtrack(String s, int n, Set<String> wordSet, boolean[] dp, Deque<String> list, List<String> res) {
        if (n == 0) {
            res.add(String.join(" ", list));
            return;
        }
        for (int i = n - 1; i >= 0; i--) {
            String suffix = s.substring(i, n);
            if (wordSet.contains(suffix) && dp[i]) {
                list.addFirst(suffix);
                backtrack(s, i, wordSet, dp, list, res);
                list.removeFirst();
            }
        }
    }
}
