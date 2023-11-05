package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/5 14:11
 */
public class LeetCode231 {

    public boolean isPowerOfTwo(int n) {
        //n & (n - 1) 该位运算技巧可以直接将 n 二进制表示的最低位 1 移除
        return n > 0 && (n & (n - 1)) == 0;
    }
}
