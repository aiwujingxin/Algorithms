package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/19 00:05
 */
public class LeetCode461 {

    public int hammingDistance(int x, int y) {
        int s = x ^ y;
        int res = 0;
        while (s != 0) {
            res += s & 1;
            s >>= 1;
        }
        return res;
    }
}
