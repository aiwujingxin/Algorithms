package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 13:01
 */
public class LeetCode7 {
    public int reverse(int x) {
        String s = String.valueOf(x);
        boolean flag = false;
        int index = s.length() - 1;
        if (x < 0) {
            flag = true;
        }
        long res = 0;
        while (index >= (flag ? 1 : 0)) {
            res = res * 10 + (s.charAt(index) - '0');
            if (res > Integer.MAX_VALUE) {
                return 0;
            }
            index--;
        }
        return flag ? -1 * (int) res : (int) res;
    }
}
