package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/13 13:37
 */
public class LeetCode338_bit {

    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            //将 x 的二进制表示的最后一个 1 变成 0
            x &= (x - 1);
            ones++;
        }
        return ones;
    }
}
