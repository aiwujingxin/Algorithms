package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 9/9/25 17:23
 */
public class LeetCode3319 {

    List<Integer> list;

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        list = new ArrayList<>();
        dfs(root);
        Collections.sort(list);
        return list.size() < k ? -1 : list.get(list.size() - k);
    }

    public int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 1};
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int flag = 0;
        if (l[0] == r[0] && l[1] == 1 && r[1] == 1) {
            list.add(l[0] + r[0] + 1);
            flag = 1;
        }
        return new int[]{l[0] + r[0] + 1, flag};
    }
}
