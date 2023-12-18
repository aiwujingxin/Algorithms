package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/18 20:00
 */
public class LeetCode7 {

    public int reverse(int x) {
        int sign = 1;
        String s = String.valueOf(x);
        int start = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            start++;
        }
        //2147483647
        int max = Integer.MAX_VALUE / 10;
        int res = 0;
        int index = s.length() - 1;
        while (index >= start) {
            int num = (s.charAt(index) - '0');
            if (res > max || (res == max && num > 7)) {
                return 0;
            }
            res = res * 10 + num;
            index--;
        }
        return sign * res;
    }
}
