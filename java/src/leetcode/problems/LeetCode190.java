package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/18 14:46
 */
public class LeetCode190 {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                res |= (1 << (31 - i));
            }
        }
        return res;
    }
}
