package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-07-04 7:52 下午
 */
public class LeetCode96_dfs {

    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += numTrees(i) + numTrees(n - i - 1);
        }
        return res;
    }
}
