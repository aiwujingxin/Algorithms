package leetcode.problems;

import common.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/31 22:30
 */
public class LeetCode1650_v2 {

    public Node lowestCommonAncestor(Node p, Node q) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        Set<Node> visited = new HashSet<>();
        visited.add(p);
        visited.add(q);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.parent == null) {
                continue;
            }
            if (visited.contains(node.parent)) {
                return node.parent;
            }
            visited.add(node.parent);
            queue.add(node.parent);
        }
        return null;
    }
}
