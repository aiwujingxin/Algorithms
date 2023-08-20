package leetcode;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/17 16:36
 * @see LeetCode95
 */
public class LeetCode894 {


    //https://leetcode.cn/problems/all-possible-full-binary-trees/solution/cu-su-yi-dong-chun-di-gui-gen-zhao-di-gu-7zok/

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (n == 1) {
            allTrees.add(new TreeNode(0));
            return allTrees;
        }

        // 获取子问题结果，这道题的子问题，就是下面这个循环里的嘛
        for (int i = 1; i < n - 1; i += 2) {
            List<TreeNode> leftTrees = allPossibleFBT(i);
            List<TreeNode> rightTrees = allPossibleFBT(n - i - 1);
            // 拿到当前子结果，计算当前问题的结果
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode curRoot = new TreeNode(0);
                    curRoot.left = left;
                    curRoot.right = right;
                    allTrees.add(curRoot);
                }
            }
        }
        return allTrees;
    }
}
