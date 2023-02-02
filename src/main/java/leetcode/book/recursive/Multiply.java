package leetcode.book.recursive;

/**
 * @author jingxinwu
 * @date 2022-01-31 2:21 PM
 */
public class Multiply {

    /**
     * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
     *
     * 示例1:
     *
     * 输入：A = 1, B = 10
     * 输出：10
     * 示例2:
     *
     * 输入：A = 3, B = 4
     * 输出：12
     *
     * @author ronaldwu
     * @date 2022-01-31 14:21:42
     **/

    public int multiply(int A, int B) {
        int n = Math.min(A, B);
        int m = Math.max(A, B);
        if (n == 1) {
            return m;
        }
        return m + multiply(n - 1, m);
    }
}
