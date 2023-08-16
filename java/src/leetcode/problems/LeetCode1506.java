package leetcode.problems;

import common.Node;

import java.util.HashSet;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/13 12:31
 */
public class LeetCode1506 {

    public Node findRoot(List<Node> tree) {
        HashSet<Node> set = new HashSet<>();
        for (Node node : tree) {
            set.addAll(node.children);
        }
        for (Node node : tree) {
            if (!set.contains(node)) {
                return node;
            }
        }
        return null;
    }
}
