package leetcode;

/**
 * @author jingxinwu
 * @date 2021-12-11 11:59 下午
 */
public class LeetCode338_dp {

    public int[] countBits(int n) {
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
