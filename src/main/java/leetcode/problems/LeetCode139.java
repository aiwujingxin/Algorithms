package leetcode.problems;

import java.util.HashSet;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/15 19:28
 */
public class LeetCode139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        if (s == null || s.length() == 0) {
            return false;
        }
        //fix boolean[] dp = new boolean[s.length() + 1];
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (set.contains(s.substring(j, i)) && dp[j]) {//fix dp[j]
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
