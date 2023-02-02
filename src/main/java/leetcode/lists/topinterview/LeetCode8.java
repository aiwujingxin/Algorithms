package leetcode.lists.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/21 00:07
 */
public class LeetCode8 {

    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();

        if (s.length() == 0) {
            return 0;
        }

        int sign = 1;
        long sum = 0;

        //符号位
        if (s.charAt(0) == '-') {
            sign = -1;
        }

        int i = (s.charAt(0) == '+' || s.charAt(0) == '-') ? 1 : 0;

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        while (i < s.length()) {
            if (!Character.isDigit(s.charAt(i))) {
                break;
            }

            sum = sum * 10 + (s.charAt(i) - '0');

            if (sum > max && sign == 1) {
                return max;
            } else if (sum * -1 < min && sign == -1) {
                return min;
            }
            i++;
        }

        return (int) sum * sign;

    }
}
