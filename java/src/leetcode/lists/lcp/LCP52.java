package leetcode.lists.lcp;

import common.TreeNode;

import java.util.TreeSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/24 22:24
 */
public class LCP52 {
    // 保存的是没有操作过的节点
    TreeSet<Integer> set;

    public int getNumber(TreeNode root, int[][] ops) {
        if (root == null) return 0;
        set = new TreeSet<>();
        build(root);
        int res = 0;
        for (int i = ops.length - 1; i >= 0; i--) {
            while (true) {
                // 找到第一个大于x的节点
                Integer upper = set.higher(ops[i][1] - 1);
                if (upper == null || upper > ops[i][2]) {
                    break;
                }
                // 删除操作过的节点
                set.remove(upper);
                // 如果是染红，记录红色节点数
                if (ops[i][0] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    private void build(TreeNode root) {
        if (root == null) {
            return;
        }
        build(root.left);
        set.add(root.val);
        build(root.right);
    }
}
