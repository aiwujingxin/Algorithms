package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/16 20:15
 */

public class LeetCode332 {

    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> list = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!graph.containsKey(src)) {
                graph.put(src, new PriorityQueue<>());
            }
            graph.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(list);
        return list;
    }

    public void dfs(String curr) {
        while (graph.containsKey(curr) && !graph.get(curr).isEmpty()) {
            String next = graph.get(curr).poll();
            dfs(next);
        }
        list.add(curr);
    }
}
