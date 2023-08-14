package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/10 14:42
 */
public class LeetCode8_v2 {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        if (str.isEmpty() || Character.isAlphabetic(str.charAt(0))) {
            return 0;
        }

        // 正负号
        boolean minus = str.charAt(0) == '-';

        StringBuilder build = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                build.append(ch);
                if ("0".contentEquals(build)) {
                    build = new StringBuilder();
                }
            } else {
                if (i == 0 && (ch == '-' || ch == '+')) {
                    continue;
                } else {
                    break;
                }
            }
        }
        if (build.length() == 0) {
            return 0;
        }
        if (build.length() > 12) {
            if (minus) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        long number = Long.parseLong(build.toString());
        number = minus ? number * -1 : number;

        if (number > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (number < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) number;
    }
}
