package leetcode.problems;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/31 22:30
 */
public class LeetCode1650_v1 {

    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> seen = new HashSet<>();
        while (p != null) {
            seen.add(p);
            p = p.parent;
        }
        while (q != null) {
            if (seen.contains(q)) {
                return q;
            }
            q = q.parent;
        }
        return null;
    }
}
