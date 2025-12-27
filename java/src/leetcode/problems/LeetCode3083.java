package leetcode.problems;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 12/22/25 15:10
 */
public class LeetCode3083 {

    public boolean isSubstringPresent(String s) {
        int n = s.length();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < n; i++) {
            set.add(s.charAt(i - 1) * 26 + s.charAt(i));
        }
        for (int i = n - 1; i >= 0; i--) {
            if (set.contains(s.charAt(i + 1) * 26 + s.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
