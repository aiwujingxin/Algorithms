package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 10:28
 */
public class LeetCode3 {

    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, ans = 0;
        int n = s.length();
        int[] w = new int[128];
        char[] ch = s.toCharArray();
        while (r < n) {
            char c = ch[r];
            w[c]++;
            while (l < r && w[c] > 1) {
                char d = ch[l];
                w[d]--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }

    class Solution_opt {

        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            int ans = 0;
            Map<Character, Integer> map = new HashMap<>();
            int l = 0;
            for (int r = 0; r < n; r++) {
                char c = s.charAt(r);
                if (map.containsKey(c)) {
                    l = Math.max(map.get(c) + 1, l);
                }
                ans = Math.max(ans, r - l + 1);
                map.put(c, r);
            }
            return ans;
        }
    }
}
