package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/11 18:05
 */
public class LeetCode1530 {

    int ans = 0;
    int distance;

    public int countPairs(TreeNode root, int distance) {
        this.distance = distance;
        dfs(root);
        return ans;
    }

    public List<Integer> dfs(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        if (node.left == null && node.right == null) {
            list.add(0);
            return list;
        }
        List<Integer> left = dfs(node.left);
        List<Integer> right = dfs(node.right);
        for (int v : left) {
            if (v + 1 >= distance) {
                continue;
            }
            list.add(v + 1);
        }
        for (int v : right) {
            if (v + 1 >= distance) {
                continue;
            }
            list.add(v + 1);
        }
        for (int l : left) {
            for (int r : right) {
                if (l + r + 2 <= distance) {
                    ans++;
                }
            }
        }
        return list;
    }
}
