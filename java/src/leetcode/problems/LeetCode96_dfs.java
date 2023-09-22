package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2023.09.19 16:29 下午
 */
public class LeetCode96_dfs {

    public int numTrees(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int left = numTrees(i);
            int right = numTrees(n - i - 1);
            res += left * right;
        }
        return res;
    }
}
