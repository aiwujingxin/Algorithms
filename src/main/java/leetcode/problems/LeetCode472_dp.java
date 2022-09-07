package leetcode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/31 22:15
 */
public class LeetCode472_dp {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Collections.addAll(set, words);

        for (String word : words) {
            if (helper(word, set)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean helper(String s, Set<String> set) {
        int len = s.length();
        if (len == 0) {
            return false;
        }
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i <= len; i++) {
            for (int j = i - 1; j >= 0; j--) { // running this loop in the backwards direction saves time
                if (i == len && j == 0) // we can't consider the string to be made up of itself i.e. we ignore s.substring(0, len)
                    continue;
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
