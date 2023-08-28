package leetcode;

import common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/29 00:18
 */
public class LeetCode590 {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    public void dfs(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        for (Node ch : root.children) {
            dfs(ch, res);
        }
        res.add(root.val);
    }
}
