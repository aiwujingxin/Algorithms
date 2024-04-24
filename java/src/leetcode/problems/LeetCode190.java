package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/18 14:46
 */
public class LeetCode190 {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int t = n >> i & 1;
            res |= t << (32 - i - 1);
        }
        return res;
    }
}
