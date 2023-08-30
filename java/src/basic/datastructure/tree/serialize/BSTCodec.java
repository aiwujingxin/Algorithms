package basic.datastructure.tree.serialize;

import basic.datastructure.tree.*;
import common.*;
import leetcode.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/16 15:52
 * @see LeetCode449
 */
public class BSTCodec implements Serialization {

    @Override
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<String> list = new ArrayList<>();
        dfs1(root, list);
        int n = list.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i));
            if (i != n - 1) {
                sb.append(COMMA);
            }
        }
        return sb.toString();
    }

    void dfs1(TreeNode root, List<String> list) {
        if (root == null) {
            return;
        }
        list.add(String.valueOf(root.val));
        dfs1(root.left, list);
        dfs1(root.right, list);
    }

    @Override
    public TreeNode deserialize(String s) {
        if (s == null) {
            return null;
        }
        String[] ss = s.split(COMMA);
        return dfs2(ss, 0, ss.length - 1);
    }

    TreeNode dfs2(String[] ss, int l, int r) {
        if (l > r) {
            return null;
        }
        int ll = l + 1, rr = r, t = Integer.parseInt(ss[l]);
        while (ll < rr) {
            int mid = ll + rr >> 1;
            if (Integer.parseInt(ss[mid]) > t) {
                rr = mid;
            } else {
                ll = mid + 1;
            }
        }
        if (Integer.parseInt(ss[rr]) <= t) {
            rr++;
        }
        TreeNode ans = new TreeNode(t);
        ans.left = dfs2(ss, l + 1, rr - 1);
        ans.right = dfs2(ss, rr, r);
        return ans;
    }
}
