package leetcode.lists.classic;

import common.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/2/27 22:30
 * <a href="https://leetcode.cn/problems/bst-sequences-lcci/solution/quan-pai-lie-de-bian-xing-by-fresh_zhe/">...</a>
 */
public class Number0409 {
    List<List<Integer>> reses = new LinkedList<>();
    LinkedList<Integer> res = new LinkedList<>();

    public List<List<Integer>> BSTSequences(TreeNode root) {
        if (root == null) {
            reses.add(res);
            return reses;
        }
        HashSet<TreeNode> curLevel = new HashSet<>();
        curLevel.add(root);
        dfs(curLevel);
        return reses;
    }

    public void dfs(HashSet<TreeNode> curLevel) {
        //当前集合没有需要遍历的元素，说明遍历到底
        if (curLevel.size() == 0) {
            reses.add(new LinkedList<>(res));
            return;
        }
        HashSet<TreeNode> nextLevel = new HashSet<>(curLevel);
        for (TreeNode t : curLevel) {
            res.add(t.val);
            nextLevel.remove(t);//出了当前节点，其余节点下一层都可以遍历
            if (t.left != null) {
                nextLevel.add(t.left);
            }
            if (t.right != null) {
                nextLevel.add(t.right);
            }
            dfs(nextLevel);
            if (t.left != null) {
                nextLevel.remove(t.left);
            }
            if (t.right != null) {
                nextLevel.remove(t.right);
            }

            nextLevel.add(t);
            res.removeLast();
        }
    }
}
