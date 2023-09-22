package leetcode.lists.LCP;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/24 22:29
 */
public class LCP52_SegTree {

    int n, m, c;
    SegTreeNode[] segTree;
    List<Integer> nums = new ArrayList<>();

    public int getNumber(TreeNode root, int[][] ops) {
        inorder(root);
        n = nums.size();
        segTree = new SegTreeNode[5 * n];
        buildSegTree(0, 0, n - 1);
        m = segTree.length;
        for (int[] op : ops) {
            update(0, op[1], op[2], op[0]);
        }
        c = 0;
        query(0);
        return c;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        nums.add(root.val);
        inorder(root.right);
    }


    static class SegTreeNode {
        int l, r, len, color;
        Integer lazy;

        public SegTreeNode() {
        }

        public SegTreeNode(int l, int r, int len) {
            this.l = l;
            this.r = r;
            this.len = len;
        }
    }

    SegTreeNode buildSegTree(int i, int l, int r) {
        if (l == r) {
            segTree[i] = new SegTreeNode(nums.get(l), nums.get(r), 1);
            return segTree[i];
        }
        segTree[i] = new SegTreeNode();
        int mid = l + ((r - l) >> 1);
        SegTreeNode left = buildSegTree(2 * i + 1, l, mid);
        SegTreeNode right = buildSegTree(2 * i + 2, mid + 1, r);
        segTree[i] = new SegTreeNode(left.l, right.r, left.len + right.len);
        return segTree[i];
    }

    public void update(int i, int l, int r, int color) {
        if (segTree[i].lazy != null) {
            if (segTree[i].lazy == color) {
                return;
            }
            pushDown(i);
        }
        if (l == segTree[i].l && r == segTree[i].r) {
            segTree[i].color = color;
            segTree[i].lazy = color;
            return;
        }
        if (color == 0) {
            segTree[i].color = color;
        }
        int tl = 2 * i + 1, tr = 2 * i + 2;
        if ((tl >= m || segTree[tl] == null) && (tr >= m || segTree[tr] == null)) {
            return;
        }
        int left = segTree[tl].r, right = segTree[tr].l;
        if (r <= left) {
            update(tl, l, r, color);
        } else if (l > left) {
            update(tr, l, r, color);
        } else {
            update(tl, l, left, color);
            update(tr, right, r, color);
        }
    }

    public void pushDown(int i) {
        int c = segTree[i].lazy, l = 2 * i + 1, r = 2 * i + 2;
        segTree[i].lazy = null;
        if (l < m && segTree[l] != null) {
            segTree[l].lazy = c;
            segTree[l].color = c;
        }
        if (r < m && segTree[r] != null) {
            segTree[r].lazy = c;
            segTree[r].color = c;
        }
    }

    public void query(int i) {
        if (i >= m || segTree[i] == null) {
            return;
        }
        if (segTree[i].color == 1) {
            c += segTree[i].len;
            return;
        }
        if (segTree[i].lazy == null) {
            query(2 * i + 1);
            query(2 * i + 2);
        }
    }
}
