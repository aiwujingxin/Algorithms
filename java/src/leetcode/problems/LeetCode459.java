package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/4 17:04
 * @link <a href="https://leetcode.cn/problems/repeated-substring-pattern/solutions/1705527/by-carlsun-2-g3iz/">kmp</a>
 */
public class LeetCode459 {

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (check(s, i, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(String s, int j, int len) {
        int k = j;
        while (k < s.length()) {
            int right = k;
            int left = 0;
            while (left < len && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right++;
            }
            k += len;
        }
        return k == s.length();
    }

    public boolean repeatedSubstringPattern_KMP(String s) {
        int n = s.length();
        int[] next = new int[n];
        Arrays.fill(next, -1);
        for (int i = 1; i < n; ++i) {
            int j = next[i - 1];
            while (j != -1 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(j + 1) == s.charAt(i)) {
                next[i] = j + 1;
            }
        }
        return next[n - 1] != -1 && n % (n - next[n - 1] - 1) == 0;
    }
}
