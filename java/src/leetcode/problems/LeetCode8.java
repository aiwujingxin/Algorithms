package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 13:13
 */
public class LeetCode8 {

    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        int i = 0, sign = 1, res = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            sign = s.charAt(i++) == '-' ? -1 : 1;
        }
        int limit = Integer.MAX_VALUE / 10;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int d = s.charAt(i++) - '0';
            if (res > limit || (res == limit && d > 7)) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + d;
        }
        return sign * res;
    }
}
