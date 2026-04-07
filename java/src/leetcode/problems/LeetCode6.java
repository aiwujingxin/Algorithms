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
        int d = 1;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            rows[r].append(s.charAt(i));
            r += d;
            if (r == 0 || r == n - 1) d = -d;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder row : rows) ans.append(row);
        return ans.toString();
    }

    class Solution_Best {
        // 发现和实践规律
        public String convert(String s, int numRows) {
            if (numRows == 1) return s;
            int c = 2 * numRows - 2;
            int n = s.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; i + j < n; j += c) {
                    sb.append(s.charAt(i + j));
                    if (i != 0 && i != numRows - 1 && j + c - i < n) {
                        sb.append(s.charAt(j + c - i));
                    }
                }
            }
            return sb.toString();
        }
    }
}
