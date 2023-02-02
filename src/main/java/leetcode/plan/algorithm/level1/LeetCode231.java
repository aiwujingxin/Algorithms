package leetcode.plan.algorithm.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/17 23:47
 */
public class LeetCode231 {


    //https://leetcode.com/problems/power-of-two/discuss/1857791/Easy-Solution-or-or-Recursion-or-or-Iteration
    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n = n / 2;
        }
        return n == 1;
    }
}
