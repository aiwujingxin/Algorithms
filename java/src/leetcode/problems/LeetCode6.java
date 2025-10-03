package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 10:41
 */
public class LeetCode6 {

    public String convert(String s, int n) {
        if (n == 1 || s.length() <= n) return s;
        StringBuilder[] rows = new StringBuilder[n];
        for (int i = 0; i < n; i++) rows[i] = new StringBuilder();
        int d = -1;
        for (int i = 0, r = 0; i < s.length(); i++) {
            rows[r].append(s.charAt(i));
            if (r == 0 || r == n - 1) d = -d;
            r += d;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder row : rows) ans.append(row);
        return ans.toString();
    }
}
