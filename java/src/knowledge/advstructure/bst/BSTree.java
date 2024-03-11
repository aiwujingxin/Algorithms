package knowledge.advstructure.bst;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/4 15:49
 * @see leetcode.problems.LeetCode98 检查一个树是否是二叉搜索树
 * @see leetcode.problems.LeetCode99 根据递增排序的序列生成二权搜索树
 * @see leetcode.problems.LeetCode701 插入
 * @see leetcode.problems.LeetCode450 删除
 */
public class BSTree {

    private TreeNode root;

    public BSTree() {
        this.root = null;
    }

    public void insert(int val) {
        root = insertNode(root, val);
    }

    private TreeNode insertNode(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertNode(root.left, val);
        } else if (val > root.val) {
            root.right = insertNode(root.right, val);
        }

        return root;
    }

    public TreeNode delete(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //从当前节点的左子树中选择值最大的节点
            TreeNode t = root.left;
            while (t.right != null) {
                t = t.right;
            }
            t.right = root.right;
            return root.left;
        } else if (root.val < key) {
            root.right = delete(root.right, key);
        } else {
            root.left = delete(root.left, key);
        }
        return root;
    }

    public boolean search(int val) {
        return searchNode(root, val);
    }

    private boolean searchNode(TreeNode root, int val) {
        if (root == null) {
            return false;
        }
        if (val == root.val) {
            return true;
        }
        if (val < root.val) {
            return searchNode(root.left, val);
        } else {
            return searchNode(root.right, val);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
