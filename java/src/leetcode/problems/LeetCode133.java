package leetcode.problems;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/29 17:35
 */
public class LeetCode133 {

    HashMap<Node, Node> cache = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (cache.containsKey(node)) {
            return cache.get(node);
        }
        Node newNode = new Node(node.val, new ArrayList<>());
        cache.put(node, newNode);
        for (Node next : node.neighbors) {
            newNode.neighbors.add(cloneGraph(next));
        }
        return newNode;
    }
}
