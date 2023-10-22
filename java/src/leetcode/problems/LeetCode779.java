package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/15 12:21
 */
public class LeetCode779 {

    public int kthGrammar(int n, int k) {
        if (k == 1) {
            return 0;
        }
        if (k == 2) {
            return 1;
        }
        if (k > Math.pow(2, (n - 2))) {
            return 1 ^ kthGrammar(n - 1, k - (int) Math.pow(2, (n - 2)));
        }
        return kthGrammar(n - 1, k);
    }
}
