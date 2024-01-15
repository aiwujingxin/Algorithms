package leetcode.problems;

import common.TreeNode;

import java.util.Objects;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/13 12:42
 */
public class LeetCode988 {

    String res = "";

    public String smallestFromLeaf(TreeNode root) {
        backtrack(root, new StringBuilder());
        return res;
    }

    private void backtrack(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sb.append((char) ('a' + root.val));
            String s = sb.toString();
            s = new StringBuilder(s).reverse().toString();
            if (Objects.equals(res, "") || can(res, s)) {
                res = s;
            }
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        sb.append((char) ('a' + root.val));
        backtrack(root.left, sb);
        backtrack(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    private boolean can(String a, String b) {
        if (a.equals(b)) {
            return false;
        }
        int i1 = 0;
        int i2 = 0;
        while (i1 < a.length() && i2 < b.length()) {
            if (a.charAt(i1) > b.charAt(i2)) {
                return true;
            }
            if (a.charAt(i1) < b.charAt(i2)) {
                return false;
            }
            i1++;
            i2++;
        }
        if (i1 == a.length()) {
            return false;
        }
        return true;
    }
}
