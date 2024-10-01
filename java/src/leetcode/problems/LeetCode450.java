package leetcode.problems;

import common.TreeNode;
import knowledge.datastructure.tree.bst.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/3 13:01
 * @link <a href="https://leetcode.cn/problems/delete-node-in-a-bst/solutions/1531428/by-ac_oier-s60a/"></a>
 */
public class LeetCode450 {

    public TreeNode deleteNode(TreeNode root, int key) {
       return new BSTree().delete(root, key);
    }
}
