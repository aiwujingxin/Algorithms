package leetcode.problems;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2022-03-01 6:55 PM
 */
public class LeetCode1297 {


    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length();
        HashMap<String, Integer> occ = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            HashSet<Character> exist = new HashSet<>();
            StringBuilder cur = new StringBuilder();
            for (int j = i; j < Math.min(n, i + maxSize); ++j) {
                exist.add(s.charAt(j));
                if (exist.size() > maxLetters) {
                    break;
                }
                cur.append(s.charAt(j));
                if (j - i + 1 >= minSize) {
                    occ.put(cur.toString(), occ.getOrDefault(cur.toString(), 0) + 1);
                    ans = Math.max(ans, occ.get(cur.toString()));
                }
            }
        }
        return ans;
    }
}
