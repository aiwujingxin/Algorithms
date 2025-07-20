package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 13:13
 */
public class LeetCode8 {

    public int myAtoi(String s) {
        s = s.trim();
        int i = 0, res = 0, sign = 1, n = s.length();
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        while (i < n) {
            int c = s.charAt(i) - '0';
            if (c < 0 || c > 9) break;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && c > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + c;
            i++;
        }
        return sign * res;
    }
}
