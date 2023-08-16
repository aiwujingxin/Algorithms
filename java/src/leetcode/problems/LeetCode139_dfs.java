package leetcode.problems;

import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/7 22:55
 */
public class LeetCode139_dfs {


    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] memo = new boolean[s.length()];
        return dfs(s, wordDict, 0, memo);
    }

    private boolean dfs(String s, List<String> wordDict, int start, boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start]) {
            return false;
        }
        for (String word : wordDict) {
            if (word.length() > s.length() - start) {
                continue;
            }
            if (s.startsWith(word, start) && dfs(s, wordDict, start + word.length(), memo)) {
                return true;
            }
        }
        memo[start] = true;
        return false;
    }
}
