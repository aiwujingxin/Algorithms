package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 9/16/25 15:16
 */
public class LeetCode3076 {

    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        HashMap<String, Set<Integer>> map = new HashMap<>();
        for (int k = 0; k < n; k++) {
            String s = arr[k];
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    map.computeIfAbsent(s.substring(i, j), key -> new HashSet<>()).add(k);
                }
            }
        }
        String[] ans = new String[n];
        Arrays.fill(ans, "");
        for (int i = 0; i < n; i++) {
            String t = "";
            String s = arr[i];
            for (int len = 1; len <= s.length(); len++) {
                for (int l = 0; l + len <= s.length(); l++) {
                    String sub = s.substring(l, l + len);
                    Set<Integer> set = map.get(sub);
                    if (set.size() == 1 && (t.isEmpty() || sub.compareTo(t) < 0)) {
                        t = sub;
                    }
                }
                if (!t.isEmpty()) {
                    ans[i] = t;
                    break;
                }
            }
        }
        return ans;
    }
}
