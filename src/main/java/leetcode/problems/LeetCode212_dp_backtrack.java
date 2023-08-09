package leetcode.problems;


import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/28 01:58
 */
public class LeetCode212_dp_backtrack {


    //https://leetcode.com/problems/word-break-ii/discuss/1598199/JAVA-DP-Solution%3A-same-as-Word-Break-with-path-trace.
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        // base case
        dp[0] = true;

        List<Integer>[] tracePath = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            tracePath[i] = new ArrayList<>();
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    tracePath[i].add(j);
                }
            }
        }

        List<String> result = new ArrayList<>();
        backTrace(n, tracePath, s, new ArrayList<>(), result);
        return result;
    }

    private void backTrace(int index, List[] dp, String s, List<String> curr, List<String> result) {
        List<Integer> list = dp[index];
        for (int next : list) {
            curr.add(s.substring(next, index));
            if (next == 0) {
                Collections.reverse(curr);
                result.add(String.join(" ", curr));
                Collections.reverse(curr);
            }
            backTrace(next, dp, s, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
