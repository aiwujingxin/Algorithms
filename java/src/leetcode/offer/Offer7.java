package leetcode.offer;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jingxinwu
 * @date 2021-11-19 9:32 下午
 */
public class Offer7 {

    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 && inorder.length == 0) {
            return null;
        }

        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, preorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {

        if (p_start > p_end) {
            return null;
        }


        TreeNode root = new TreeNode(preorder[p_start]);

        int index = indexMap.get(preorder[p_start]);

        // 得到左子树中的节点数目
        int size_left_subtree = index - i_start;

        root.left = buildTree(preorder, p_start + 1, p_start + size_left_subtree, inorder, i_start, index - 1);
        root.right = buildTree(preorder, p_start + size_left_subtree + 1, p_end, inorder, index + 1, i_end);

        return root;
    }

}


