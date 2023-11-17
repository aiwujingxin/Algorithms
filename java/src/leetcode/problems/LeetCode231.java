package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/5 14:11
 */
public class LeetCode231 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
