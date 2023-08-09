package leetcode.problems;

import common.*;

import java.util.*;

public class LeetCode1609 {

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<List<Integer>> level = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> first = new ArrayList<>();
        first.add(root.val);
        level.add(first);
        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            while (size > 0) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    temp.add(cur.left.val);
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    temp.add(cur.right.val);
                    q.add(cur.right);
                }
                size--;
            }
            level.add(temp);
        }
        for (int i = 0; i < level.size(); i++) {
            List<Integer> list = level.get(i);
            boolean res;
            if (i % 2 == 0) {
                res = checkOdd(list);
            } else {
                res = checkEven(list);
            }
            if (!res) {
                return false;
            }
        }
        return true;
    }

    private boolean checkOdd(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 != 1) {
                return false;
            }
            if (i < list.size() - 1 && list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkEven(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 != 0) {
                return false;
            }
            if (i < list.size() - 1 && list.get(i) <= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
