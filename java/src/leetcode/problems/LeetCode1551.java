package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/31 14:37
 */
public class LeetCode1551 {

    public int minOperations(int n) {
        return (n / 2) * (n / 2 + n % 2);
    }
}
