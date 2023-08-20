package leetcode;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/23 22:13
 */
public class LeetCode1062_bs {

    public int longestRepeatingSubstring(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            int mid = (right + left + 1) / 2;
            if (search(mid, s)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean search(int L, String s) {
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
