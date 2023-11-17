package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2023-11-17 13:48
 */
public class LeetCode326 {

    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
