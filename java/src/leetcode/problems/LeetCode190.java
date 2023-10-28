package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/28 12:04
 */
public class LeetCode190 {

    public int reverseBits(int n) {
        if (n == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            res = res | (n & 1);
            n = n >> 1;
        }
        return res;
    }
}
