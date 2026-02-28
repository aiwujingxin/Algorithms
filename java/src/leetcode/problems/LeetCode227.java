package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/26 10:50
 */
public class LeetCode227 {

    public int calculate(String s) {
        int res = 0, lastNum = 0, num = 0;
        char sign = '+';
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {
                if (sign == '+') {
                    res += lastNum;
                    lastNum = num;
                } else if (sign == '-') {
                    res += lastNum;
                    lastNum = -num;
                } else if (sign == '*') {
                    lastNum *= num;
                } else if (sign == '/') {
                    lastNum /= num;
                }
                sign = c;
                num = 0;
            }
        }
        return res + lastNum;
    }
}
