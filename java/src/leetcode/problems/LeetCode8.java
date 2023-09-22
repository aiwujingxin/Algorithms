package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-06-14 1:43 下午
 */
public class LeetCode8 {

    public static void main(String[] args) {
        System.out.println(new LeetCode8().myAtoi("   -42"));
    }

    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        int index = 0, sign = 1;
        if (s.charAt(index) == '+') {
            index++;
        } else if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        int res = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c < '0' || c > '9') {
                break;
            }
            int num = c - '0';
            if (res > (Integer.MAX_VALUE - num) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + num;
            index++;
        }
        return sign * res;
    }
}
