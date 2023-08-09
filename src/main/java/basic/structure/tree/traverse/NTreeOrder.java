package basic.structure.tree.traverse;

import basic.structure.tree.*;
import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/1 13:01
 */
public class NTreeOrder implements Traverse {
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
        return null;
    }

}
