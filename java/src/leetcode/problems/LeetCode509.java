package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/20 18:40
 */
public class LeetCode509 {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int a = 0;
        int b = 1;
        for (int i = 1; i < n; i++) {
            int t = b;
            b = a + b;
            a = t;
        }
        return b;
    }
}
