package leetcode;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/31 22:17
 */
public class LeetCode472_dfs {

    //dfs + memorization
    Boolean[] memo;//global data to storage status

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Collections.addAll(set, words);
        for (String str : words) {
            set.remove(str);
            memo = new Boolean[str.length() + 1];
            if (canBreak(str, str.length(), set) && str.length() > 0) {
                res.add(str);
            }
            set.add(str);
        }

        return res;
    }

    public boolean canBreak(String s, int n, Set<String> dict) {
        if (n == 0) {
            return true;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        memo[n] = false;
        for (int i = 0; i < n; i++) {
            if (dict.contains(s.substring(i, n))) {
                boolean left = canBreak(s, i, dict);
                if (left) {
                    memo[n] = true;
                    break;
                }
            }
        }
        return memo[n];
    }
}
