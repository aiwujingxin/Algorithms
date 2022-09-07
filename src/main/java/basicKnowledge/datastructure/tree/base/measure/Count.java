package basicKnowledge.datastructure.tree.base.measure;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 12:22
 */
public interface Count {

    // 543. 二叉树的直径 https://leetcode.cn/problems/diameter-of-binary-tree/
    // 563. 二叉树的坡度 https://leetcode.cn/problems/binary-tree-tilt/
    int count(TreeNode root);
}
