package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/30 02:14
 */
public class LeetCode326 {

    //study
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
