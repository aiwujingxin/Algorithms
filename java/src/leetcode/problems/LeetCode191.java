package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/28 11:29
 */
public class LeetCode191 {

    public int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                res++;
            }
            n = n >> 1;
        }
        return res;
    }
}
