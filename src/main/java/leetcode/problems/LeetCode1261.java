package leetcode.problems;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/21 15:23
 */
public class LeetCode1261 {

    class FindElements {

        Set<Integer> set;

        public FindElements(TreeNode root) {
            set = new HashSet<>();
            root.val = 0;
            set.add(0);
            fix(root);
        }

        private void fix(TreeNode root) {
            if (root.left != null) {
                int val = (root.val << 1) + 1;
                this.set.add(val);
                root.left.val = val;
                this.fix(root.left);
            }
            if (root.right != null) {
                int val = (root.val << 1) + 2;
                this.set.add(val);
                root.right.val = val;
                this.fix(root.right);
            }
        }

        public boolean find(int target) {
            return this.set.contains(target);
        }
    }
}
