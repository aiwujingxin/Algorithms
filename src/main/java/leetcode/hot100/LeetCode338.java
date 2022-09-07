package leetcode.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/5 22:49
 */
public class LeetCode338 {

    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }
}
