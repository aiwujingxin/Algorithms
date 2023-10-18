package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 13:13
 */
public class LeetCode8 {

    public static void main(String[] args) {
        System.out.println(new LeetCode8().myAtoi("-21474836482"));
    }

    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        int index = 0;
        boolean flag = false;
        if (s.charAt(0) == '-') {
            index++;
            flag = true;
        } else if (s.charAt(0) == '+') {
            index++;
        }
        int res = 0;
        int max = Integer.MAX_VALUE / 10;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c < '0' || c > '9') {
                return flag ? -1 * res : res;
            }
            if (res > max) {
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            if (res == max) {
                if (flag) {
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
        return flag ? -1 * res : res;
    }
}
