package leetCode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-26 8:56 PM
 */
public class LeetCode342 {


    public boolean isPowerOfFour(int n) {

        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;

    }
}
