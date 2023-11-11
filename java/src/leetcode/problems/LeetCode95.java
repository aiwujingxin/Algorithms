package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/11 19:28
 */
public class LeetCode95 {

    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    public List<TreeNode> generate(int start, int end) {
        if (start > end) {
            List<TreeNode> res = new ArrayList<>();
            res.add(null);
            return res;
        }
        List<TreeNode> res = new ArrayList<>();
        for (int i = start; i < end; i++) {
            List<TreeNode> left = generate(start, i - 1);
            List<TreeNode> right = generate(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
