package leetcode.problems;

import common.Node;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/29 17:35
 */
public class LeetCode133 {
    private final HashMap<Node, Node> cache = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (cache.containsKey(node)) {
            return cache.get(node);
        }
        Node cloneNode = new Node(node.val, new ArrayList<>());
        cache.put(node, cloneNode);
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}
