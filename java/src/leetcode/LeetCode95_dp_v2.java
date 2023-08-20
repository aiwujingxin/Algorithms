package leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/11 16:27
 */
public class LeetCode95_dp_v2 {

    //https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/410074/Java-Recursion-and-Iteration-Solutions-(DP-Clone-Memoization)
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<TreeNode>[][] g = new ArrayList[n + 1][n + 1];
        // init
        List<TreeNode> nullList = new ArrayList<>();
        nullList.add(null);
        g[0][0] = nullList;
        for (int k = 1; k <= n; ++k) { // g(0, k)
            g[0][k] = nullList;
        }
        for (int k = 1; k <= n; ++k) { // diagonal: one node (itself)
            List<TreeNode> oneList = new ArrayList<>();
            oneList.add(new TreeNode(k));
            g[k][k] = oneList;
        }
        for (int k = 1; k <= n; ++k) { // one node above diagonal: nullList
            g[k][k - 1] = nullList;
        }
        // dp
        for (int i = n - 1; i >= 1; --i) {
            for (int j = i + 1; j <= n; ++j) {
                List<TreeNode> result = new ArrayList<>();
                for (int k = i; k <= j; ++k) { // for each k as root [i, j]
                    List<TreeNode> leftList = (k - 1 <= n) ? g[i][k - 1] : nullList;
                    List<TreeNode> rightList = (k + 1 <= n) ? g[k + 1][j] : nullList;
                    for (TreeNode left : leftList) {
                        for (TreeNode right : rightList) {
                            TreeNode newTree = new TreeNode(k);
                            newTree.left = left;
                            newTree.right = right;
                            result.add(newTree);
                        }
                    }
                }
                g[i][j] = result;
            }
        }
        return g[1][n];
    }
}
