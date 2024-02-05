package leetcode.problems;

import common.Node;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1485 {

    private Map<Node, NodeCopy> cache = new HashMap<>();

    public NodeCopy copyRandomBinaryTree(Node root) {
        return dfs(root);
    }

    private NodeCopy dfs(Node node) {
        if (node == null) {
            return null;
        }
        if (cache.containsKey(node)) {
            return cache.get(node);
        }
        NodeCopy copy = new NodeCopy(node.val);
        cache.put(node, copy);
        copy.left = dfs(node.left);
        copy.right = dfs(node.right);
        copy.random = dfs(node.random);
        return copy;
    }

    class NodeCopy {
        int val;
        NodeCopy left;
        NodeCopy right;
        NodeCopy random;

        NodeCopy() {
        }

        NodeCopy(int val) {
            this.val = val;
        }

        NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.random = random;
        }
    }
}
