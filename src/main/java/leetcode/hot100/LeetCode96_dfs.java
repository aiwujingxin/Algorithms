package leetcode.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/4 16:28
 */
public class LeetCode96_dfs {

    //https://www.youtube.com/watch?v=-rlQCg_TJac

    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        int res = 0;

        for (int i = 0; i < n; i++) {
            res += numTrees(i) * numTrees(n - i - 1);
        }
        return res;
    }
}
