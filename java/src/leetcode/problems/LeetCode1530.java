package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 12/2/25 15:25
 */
public class LeetCode1530 {
    int ans;
    int distance;

    public int countPairs(TreeNode root, int distance) {
        this.distance = distance;
        dfs(root);
        return ans;
    }

    private List<Integer> dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return List.of(1);
        }
        List<Integer> left = dfs(root.left);
        List<Integer> right = dfs(root.right);
        if (left != null && right != null) {
            for (Integer l : left) {
                for (Integer r : right) {
                    if (l + r <= distance) {
                        ans++;
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        if (left != null) {
            for (Integer l : left) {
                l++;
                res.add(l);
            }
        }
        if (right != null) {
            for (Integer r : right) {
                r++;
                res.add(r);
            }
        }
        return res;
    }
}
