package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/11 11:23
 */
public class LeetCode69 {

    public int mySqrt(int x) {
        long l = 0;
        long r = x;
        while (l < r) {
            long m = l + r + 1 >> 1;
            if (m * m > x) r = m - 1;
            else l = m;
        }
        return (int) l;
    }
}
