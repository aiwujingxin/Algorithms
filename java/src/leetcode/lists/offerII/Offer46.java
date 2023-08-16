package leetcode.lists.offerII;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/25 11:07
 */
public class Offer46 {

    int high = 0;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        dfs(root, list, 0);
        return list;
    }

    public void dfs(TreeNode root, List<Integer> list, int h) {
        if (h == high) {
            high++;
            list.add(root.val);
        }
        if (root.right != null) {
            dfs(root.right, list, h + 1);
        }
        if (root.left != null) {
            dfs(root.left, list, h + 1);
        }
    }
}
