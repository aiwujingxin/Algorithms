package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/8 00:01
 */
public class LeetCode1044 {

    public String longestDupSubstring(String s) {
        int n = s.length();
        int left = 0;
        int right = n;
        int start = -1;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            int index;
            if ((index = find(s, mid)) > -1) {
                start = index;
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return start == -1 ? "" : s.substring(start, start + left);
    }

    long mod = (long) Math.pow(10, 11);
    long mul = 26;

    private int find(String txt, int len) {
        int ans = -1;

        long base = 1;
        for (int i = 0; i < len - 1; i++) {
            base = base * mul % mod;
        }

        long hash = 0;
        for (int i = 0; i < len; i++) {
            hash = (hash * mul + (txt.charAt(i))) % mod;
        }

        Set<Long> set = new HashSet<>();
        set.add(hash);
        for (int i = len; i < txt.length(); i++) {
            hash = (mul * (hash - (txt.charAt(i - len) * base)) + (txt.charAt(i))) % mod;
            if (hash < 0) {
                hash = hash + mod;
            }
            if (!set.add(hash)) {
                return i - len + 1;
            }
        }
        return ans;
    }
}
