package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/7 22:55
 */
public class LeetCode139_dfs {

    boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new boolean[s.length()];
        return dfs(s, wordDict, 0);
    }

    private boolean dfs(String s, List<String> wordDict, int start) {
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
            if (s.startsWith(word, start) && dfs(s, wordDict, start + word.length())) {
                return true;
            }
        }
        memo[start] = true;
        return false;
    }
}
