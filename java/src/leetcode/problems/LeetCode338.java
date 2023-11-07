package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/13 13:37
 */
public class LeetCode338 {

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


    public int[] countBits_dp(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {

            //判断一个正整数是不是 2 的整数次幂
            if ((i & (i - 1)) == 0) {
                //更新当前的最高有效位(只有最高位是1)
                highBit = i;
            }
            //bits[x]=bits[z]+1
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

}
