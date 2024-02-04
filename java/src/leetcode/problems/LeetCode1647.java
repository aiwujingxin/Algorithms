package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/4 17:31
 * @see LeetCode945
 * @see LeetCode1433
 */
public class LeetCode1647 {

    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        for (int i : freq) {
            if (i != 0) {
                while (set.contains(i)) {
                    i--;
                    cnt++;
                }
                if (i != 0) {
                    set.add(i);
                }
            }
        }
        return cnt;
    }
}
