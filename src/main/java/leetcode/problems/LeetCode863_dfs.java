package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/13 22:50
 */
public class LeetCode863_dfs {

    int idx;    // 根据数据范围最多有 501 个点，每个点最多有 2 条无向边（两个子节点）
    int N = 510, M = N * 4;
    boolean[] vis = new boolean[N];

    public List<Integer> distanceK(TreeNode root, TreeNode t, int k) {
        List<Integer> ans = new ArrayList<>();
        Arrays.fill(he, -1);
        dfs(root);
        vis[t.val] = true;
        find(t.val, k, 0, ans);
        return ans;
    }

    int[] he = new int[N], e = new int[M], ne = new int[M];

    void find(int root, int max, int cur, List<Integer> ans) {
        if (cur == max) {
            ans.add(root);
            return;
        }
        for (int i = he[root]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!vis[j]) {
                vis[j] = true;
                find(j, max, cur + 1, ans);
            }
        }
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            add(root.val, root.left.val);
            add(root.left.val, root.val);
            dfs(root.left);
        }
        if (root.right != null) {
            add(root.val, root.right.val);
            add(root.right.val, root.val);
            dfs(root.right);
        }
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }
}
