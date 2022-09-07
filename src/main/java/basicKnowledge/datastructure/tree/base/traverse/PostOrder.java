package basicKnowledge.datastructure.tree.base.traverse;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 11:50
 */
public abstract class PostOrder implements Traverse {

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
        dfs(root.right);
        list.add(root.val);
    }

    public abstract List<Integer> traverseByIteration(TreeNode root);
}
