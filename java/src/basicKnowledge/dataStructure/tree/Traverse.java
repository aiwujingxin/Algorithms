package basicKnowledge.dataStructure.tree;

import common.TreeNode;

import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 11:44
 */
public interface Traverse {

    //preOrder https://leetcode.cn/problems/binary-tree-preorder-traversal/
    //inOrder https://leetcode.cn/problems/binary-tree-inorder-traversal/
    //postOrder https://leetcode.cn/problems/binary-tree-postorder-traversal/
    //levelOrder https://leetcode.cn/problems/binary-tree-level-order-traversal/
    //levelOrderII https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/

    List<Integer> DFS(TreeNode root);

    List<Integer> Iteration(TreeNode root);
}
