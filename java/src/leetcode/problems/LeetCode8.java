package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 13:13
 */
public class LeetCode8 {

    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        int index = 0;
        boolean sign = false;
        if (s.charAt(0) == '-') {
            index++;
            sign = true;
        } else if (s.charAt(0) == '+') {
            index++;
        }
        int res = 0;
        int limit = Integer.MAX_VALUE / 10;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c < '0' || c > '9') {
                return sign ? -1 * res : res;
            }
            if (res > limit) {
                return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            if (res == limit) {
                if (sign) {
                    if (c >= '8') {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    if (c > '7') {
                        return Integer.MAX_VALUE;
                    }
                }
            }
            res = res * 10 + (c - '0');
            index++;
        }
        return sign ? -1 * res : res;
    }
}
