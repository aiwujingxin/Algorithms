package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/19 00:05
 */
public class LeetCode461 {

    public int hammingDistance(int x, int y) {
        int res = 0;
        for (int i = 1; i <= 32; i++) {
            if ((x & (1 << i)) != (y & (1 << i))) {
                res++;
            }
        }
        return res;
    }
}
