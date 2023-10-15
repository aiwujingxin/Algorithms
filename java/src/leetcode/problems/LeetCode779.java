package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/15 13:17
 * @see LeetCode60
 * @see LeetCode2415_bfs
 */
public class LeetCode779 {

    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (k & 1) ^ 1 ^ kthGrammar(n - 1, (k + 1) / 2);
    }
}
