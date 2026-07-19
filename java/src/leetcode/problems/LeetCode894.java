package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/17 16:36
 * @see LeetCode95
 */
public class LeetCode894 {

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n % 2 == 0) {
            return result;
        }
        if (n == 1) {
            result.add(new TreeNode(0));
            return result;
        }
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> leftRes = allPossibleFBT(i);
            List<TreeNode> rightRes = allPossibleFBT(n - 1 - i);
            for (TreeNode left : leftRes) {
                for (TreeNode right : rightRes) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
