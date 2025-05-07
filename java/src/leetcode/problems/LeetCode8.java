package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 13:13
 */
public class LeetCode8 {

    public int myAtoi(String s) {
        s = s.trim();
        int index = 0, res = 0, sign = 1;
        if (index < s.length() && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }
        while (index < s.length()) {
            int c = s.charAt(index) - '0';
            if (c < 0 || c > 9) break;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && c > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + c;
            index++;
        }
        return sign * res;
    }
}
