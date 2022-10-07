package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/21 00:04
 */
public class LeetCode7 {

    //copy
    public int reverse(int x) {
        int rev = 0, rem;
        while (x != 0) {
            rem = x % 10;
            if ((rev > Integer.MAX_VALUE / 10) || (rev < Integer.MIN_VALUE / 10)) {
                return 0;
            }
            rev = rev * 10 + rem;
            x /= 10;
        }
        return rev;
    }
}
