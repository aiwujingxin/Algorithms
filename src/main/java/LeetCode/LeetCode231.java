package LeetCode;

/**
 * @author jingxinwu
 * @date 2021-12-26 8:57 PM
 */
public class LeetCode231 {

    public boolean isPowerOfTwo(int n) {

        //n & (n - 1) 该位运算技巧可以直接将 nn 二进制表示的最低位 11 移除
        return n > 0 && (n & (n - 1)) == 0;
    }


    public boolean isPowerOfTwoV2(int n) {
        return n > 0 && (n & -n) == n;
    }

}
