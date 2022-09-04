package leetCode.problems;

/**
 * @author jingxinwu
 * @date 2021-06-14 1:43 下午
 */
public class LeetCode8 {

    public static void main(String[] args) {
        LeetCode8 leetCode8 = new LeetCode8();
        System.out.println(leetCode8.myAtoi("   -42"));
    }

    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - '0';

            if ((temp < 0 || temp > 9)) {

                if (s.charAt(i) != '-' && s.charAt(i) != ' ') {
                    return 0;
                }
            }

            if (s.charAt(i) == '-') {
                flag = true;
                break;
            }

        }
        int res = 0;
        int factor = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int temp = s.charAt(i) - '0';

            if (temp < 0 || temp > 9) {
                continue;
            }

            if (i == 0 && flag) {
                continue;
            }
            if (temp < 0 || temp > 9) {
                break;
            }

            res += factor * temp;
            factor = factor * 10;
        }
        return flag ? -1 * res : res;
    }

    public int myAtoi2(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        if (str.isEmpty() || Character.isAlphabetic(str.charAt(0))) {
            return 0;
        }

        // 正负号
        boolean minus = false;
        if (str.charAt(0) == '-') {
            minus = true;
        }

        StringBuilder build = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                build.append(ch);
                if ("0".equals(build.toString())) {
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
