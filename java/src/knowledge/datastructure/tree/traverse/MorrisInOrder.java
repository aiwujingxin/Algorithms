package knowledge.datastructure.tree.traverse;

import common.TreeNode;
import knowledge.datastructure.tree.Iteration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/27 21:40
 * @description Morris中顺遍历
 */
public class MorrisInOrder implements Iteration {

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        MorrisInOrder morris = new MorrisInOrder();
        System.out.println("In-order traversal using Morris Traversal:");
        System.out.println(morris.Iteration(root));
    }

    public List<Integer> Iteration(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                list.add(cur.val);
                cur = cur.right; // Move to the right child
            } else {
                // Find the inorder predecessor of current
                TreeNode mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    // Make current as the right child of its inorder predecessor
                    mostRight.right = cur;
                    cur = cur.left; // Move to the left child
                } else {
                    // Revert the changes made in the if block above
                    mostRight.right = null;
                    list.add(cur.val);
                    cur = cur.right; // Move to the right child
                }
            }
        }
        return list;
    }
}
