package knowledge.datastructure.tree.traverse;

import common.TreeNode;
import knowledge.datastructure.tree.TraverseDFS;
import knowledge.datastructure.tree.TraverseIteration;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/1 13:01
 */
public class NTreeOrder implements TraverseIteration, TraverseDFS {

    @Override
    public List<Integer> DFS(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        for (TreeNode child : root.children) {
            // 前序位置需要的操作
            DFS(child);
            // 后序位置需要的操作
        }
        return list;
    }

    @Override
    public List<Integer> Iteration(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            for (TreeNode next : cur.children) {
                if (next != null) {
                    queue.add(next);
                    list.add(next.val);
                }
            }
        }
        return list;
    }
}
