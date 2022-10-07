package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/27 14:21
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
            n >>= 1;
        }
        return res;
    }
}
