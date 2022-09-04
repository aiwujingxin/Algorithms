package leetCode.problems;

/**
 * @author jingxinwu
 * @date 2021-11-18 11:43 下午
 */
public class LeetCode7 {


    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}
