package newker;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ThreeOrders {

    public int[][] threeOrders(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(preorderTraversal(root));
        ans.add(inorderTraversalV2(root));
        ans.add(postOrderTrace(root));
        int[][] res = new int[ans.size()][ans.get(0).size()];
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(0).size(); j++) {
                res[i][j] = ans.get(i).get(j);
            }
        }
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pNode = stack.pop();
            result.add(pNode.val);
            if (pNode.right != null) {
                stack.push(pNode.right);
            }
            if (pNode.left != null) {
                stack.push(pNode.left);
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode top = root;
        while (top != null || !s.isEmpty()) {
            while (top != null) {
                s.push(top);
                top = top.left;
            }
            top = s.pop();
            list.add(top.val);
            top = top.right;
        }
        return list;
    }

    public List<Integer> inorderTraversalV2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode top = root;
        while (top != null || !s.isEmpty()) {
            if (top != null) {
                s.push(top);
                top = top.left;
            } else {
                top = s.pop(); //根节点
                list.add(top.val);
                top = top.right;
            }
        }
        return list;
    }


    public List<Integer> postOrderTrace(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode top = root;
        TreeNode pre = null;
        while (top != null || !s.isEmpty()) {
            while (top != null) {
                s.push(top);
                top = top.left;
            }
            top = s.peek();
            if (top.right != null && pre != top.right) {
                top = top.right;
            } else {
                top = s.pop();
                list.add(top.val);
                pre = top;
                top = null;
            }

        }
        return list;
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode tmp = stack.pollFirst();
                if (tmp != null) {
                    list.add(tmp.val);
                    if (tmp.left != null) {
                        stack.addLast(tmp.left);
                    }
                    if (tmp.right != null) {
                        stack.addLast(tmp.right);
                    }
                }
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}
