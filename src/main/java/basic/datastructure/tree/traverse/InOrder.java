package basic.datastructure.tree.traverse;

import basic.problems.tree.*;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 14:18
 */
public abstract class InOrder implements Traverse {


    List<Integer> list = new ArrayList<>();

    @Override
    public List<Integer> traverseByDFS(TreeNode root) {
        if (root == null) {
            return list;
        }
        dfs(root);
        return list;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    public abstract List<Integer> traverseByIteration(TreeNode root);

}
