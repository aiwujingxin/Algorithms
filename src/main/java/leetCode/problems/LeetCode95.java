package leetCode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-07-04 5:08 下午
 */
public class LeetCode95 {

    public static void main(String[] args) {
        System.out.println(new LeetCode95().generateTreesV2(100));
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }

    //DP
    public List<TreeNode> generateTreesV2(int n) {
        ArrayList<TreeNode>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<>();
        if (n == 0) {
            return dp[0];
        }
        dp[0].add(null);
        //长度为 1 到 n
        for (int len = 1; len <= n; len++) {
            dp[len] = new ArrayList<>();
            //将不同的数字作为根节点，只需要考虑到 len
            for (int root = 1; root <= len; root++) {
                int left = root - 1;  //左子树的长度
                int right = len - root; //右子树的长度
                for (TreeNode leftTree : dp[left]) {
                    for (TreeNode rightTree : dp[right]) {
                        TreeNode treeRoot = new TreeNode(root);
                        treeRoot.left = leftTree;
                        //克隆右子树并且加上偏差
                        treeRoot.right = clone(rightTree, root);
                        dp[len].add(treeRoot);
                    }
                }
            }
        }
        return dp[n];
    }

    private TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }


    //https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/410074/Java-Recursion-and-Iteration-Solutions-(DP-Clone-Memoization)
    public List<TreeNode> generateTreesV3(int n) {
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
