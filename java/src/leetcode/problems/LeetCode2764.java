package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/20 11:24
 */
public class LeetCode2764 {

    Map<Integer, List<Integer>> map = new HashMap<>();
    List<List<Integer>> nodes;
    int index = 0;

    public boolean isPreorder(List<List<Integer>> nodes) {
        if (nodes == null || nodes.isEmpty()) {
            return true;
        }
        this.nodes = nodes;
        // build tree
        for (List<Integer> node : nodes) {
            map.putIfAbsent(node.get(1), new ArrayList<>());
            map.get(node.get(1)).add(node.get(0));
        }

        return dfs(-1);
    }

    private boolean dfs(Integer node) {
        if (map.get(node) == null || map.get(node).isEmpty()) {
            return true;
        }
        for (Integer next : map.get(node)) {
            if (next != nodes.get(index).get(0)) {
                return false;
            }
            index++;
            if (!dfs(next)) {
                return false;
            }
        }
        return true;
    }
}
