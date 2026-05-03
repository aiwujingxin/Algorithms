package leetcode.problems;

import java.util.Arrays;

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
            int[] index = new int[128];
            Arrays.fill(index, -1);
            int j = -1;
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (index[c] != -1) {
                    j = Math.max(j, index[c]);
                }
                max = Math.max(i - j, max);
                index[c] = i;
            }
            return max;
        }
    }
}
