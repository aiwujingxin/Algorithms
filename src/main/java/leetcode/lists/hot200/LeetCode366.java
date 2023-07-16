package leetcode.lists.hot200;


import common.TreeNode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/24 17:52
 */

//https://leetcode.cn/problems/find-leaves-of-binary-tree/solution/366-xun-zhao-er-cha-shu-de-xie-zi-jie-dian-by-klb/
public class LeetCode366 {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        while (root != null) {
            List<Integer> list = new ArrayList<>();
            root = recur(root, list);
            resList.add(list);
        }
        return resList;
    }

    private TreeNode recur(TreeNode root, List<Integer> list) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return null;
        }
        root.left = recur(root.left, list);
        root.right = recur(root.right, list);
        return root;
    }
}
