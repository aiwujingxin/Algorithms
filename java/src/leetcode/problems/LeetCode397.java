package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/22 21:35
 */
public class LeetCode397 {

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2);
        }
        return 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));
    }
}
