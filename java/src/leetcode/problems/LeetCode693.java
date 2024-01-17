package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/12 12:59
 */
public class LeetCode693 {

    public boolean hasAlternatingBits(int n) {
        int t = n & 1;
        n >>= 1;
        while (n > 0) {
            if ((t ^ (n & 1)) == 0) {
                return false;
            }
            t = n & 1;
            n >>= 1;
        }
        return true;
    }
}
