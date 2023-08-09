package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/2 22:15
 */
public class LeetCode1490 {

    public Node cloneTree(Node root) {
        if (root == null) {
            return null;
        }
        Node cloneRoot = new Node(root.val);
        for (Node child : root.children) {
            cloneRoot.children.add(cloneTree(child));
        }
        return cloneRoot;
    }
}
