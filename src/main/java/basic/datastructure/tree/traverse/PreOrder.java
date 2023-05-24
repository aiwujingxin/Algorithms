package basic.datastructure.tree.traverse;

import basic.problems.tree.*;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 11:47
 */
public abstract class PreOrder implements Traverse {

    List<Integer> list = new ArrayList<>();

    @Override
    public List<Integer> traverseByDFS(TreeNode root) {
        if (root == null) {
            return list;
        }
        dfs(root);
        return list;
    }

    @Override
    public abstract List<Integer> traverseByIteration(TreeNode root);

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

}
