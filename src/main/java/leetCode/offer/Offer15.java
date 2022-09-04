package leetCode.offer;

/**
 * @author jingxinwu
 * @date 2021-11-21 2:11 下午
 */
public class Offer15 {

    //循环检查二进制位
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }

    public int hammingWeightV2(int n) {
        int ret = 0;
        while (n != 0) {
            //其预算结果恰为把 nn 的二进制位中的最低位的 11 变为 00 之后的结果。
            n &= n - 1;
            ret++;
        }
        return ret;
    }
}
