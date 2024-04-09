package leetcode.problems;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/23 22:13
 */
public class LeetCode1062_bs {

    public int longestRepeatingSubstring(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            int mid = r + l + 1 >> 1;
            if (check(mid, s)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public boolean check(int L, String s) {
        HashSet<Integer> seen = new HashSet<>();
        for (int start = 0; start < s.length() - L + 1; ++start) {
            String tmp = s.substring(start, start + L);
            int h = tmp.hashCode();
            if (seen.contains(h)) {
                return true;
            }
            seen.add(h);
        }
        return false;
    }
}
