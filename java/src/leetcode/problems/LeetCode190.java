package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/18 14:42
 */
public class LeetCode190 {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                res |= (1 << (31 - i));
            }
            n >>= 1;
        }
        return res;
    }
}
