package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 8/18/25 23:05
 */
public class LeetCode828 {

    public int uniqueLetterString(String s) {
        int n = s.length();
        int[] prev = new int[n], next = new int[n];
        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'A';
            prev[i] = last[c];
            last[c] = i;
        }
        Arrays.fill(last, n);
        for (int i = n - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'A';
            next[i] = last[c];
            last[c] = i;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) (i - prev[i]) * (next[i] - i);
        }
        return (int) ans;
    }
}
