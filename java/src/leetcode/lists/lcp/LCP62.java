package leetcode.lists.lcp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/8 22:11
 */
public class LCP62 {

    public int transportationHub(int[][] path) {
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int[] pa : path) {
            indegree.put(pa[1], indegree.getOrDefault(pa[1], 0) + 1);
            outdegree.put(pa[0], indegree.getOrDefault(pa[1], 0) + 1);
            set.add(pa[0]);
            set.add(pa[1]);
        }
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == set.size() - 1 && outdegree.getOrDefault(entry.getKey(), 0) == 0) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
