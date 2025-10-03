package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/31 22:13
 */
public class LeetCode1443 {

    static class Node {
        int val;
        List<Node> child;
        Boolean has;

        public Node(int i, boolean has) {
            this.val = i;
            this.has = has;
            this.child = new ArrayList<>();
        }
    }

    int cnt;
    boolean[] vs;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, Node> map = new HashMap<>();
        vs = new boolean[n];
        for (int i = 0; i < n; i++) {
            map.put(i, new Node(i, hasApple.get(i)));
        }
        for (int[] e : edges) {
            Node e0 = map.get(e[0]);
            e0.child.add(map.get(e[1]));
            Node e1 = map.get(e[1]);
            e1.child.add(map.get(e[0]));
        }
        vs[0] = true;
        dfs(map.get(0));
        return cnt;
    }

    public boolean dfs(Node root) {
        if (root == null) {
            return false;
        }
        boolean res = false;
        for (Node ch : root.child) {
            if (vs[ch.val])
                continue;
            vs[ch.val] = true;
            boolean t = dfs(ch);
            res |= t;
            if (t)
                cnt += 2;
        }
        return res || root.has;
    }
}
