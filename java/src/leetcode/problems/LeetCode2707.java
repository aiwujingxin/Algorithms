package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 11/18/25 17:21
 */
public class LeetCode2707 {

    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, dictionary);
        int n = s.length();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (set.contains(s.substring(i, j))) {
                    List<Integer> list = map.getOrDefault(j - 1, new ArrayList<>());
                    list.add(i);
                    map.put(j - 1, list);
                }
            }
        }
        if (map.isEmpty()) return n;
        int[] dp = new int[n];
        dp[0] = map.containsKey(0) ? 1 : 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];
            for (int start : map.getOrDefault(i, new ArrayList<>())) {
                dp[i] = Math.max(dp[i], (start > 0 ? dp[start - 1] : 0) + i - start + 1);
            }
        }
        return n - dp[n - 1];
    }
}
