package leetcode.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/19 14:11
 */
public class LeetCode461 {

    public int hammingDistance(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret += s & 1;
            s >>= 1;
        }
        return ret;

    }
}
