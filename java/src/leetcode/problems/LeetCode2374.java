package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/7 23:06
 */
public class LeetCode2374 {

    public int edgeScore(int[] edges) {
        int n = edges.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i]].add(i);
        }
        long max = 0;
        int res = -1;
        for (int i = 0; i < graph.length; i++) {
            long sum = 0;
            for (int j = 0; j < graph[i].size(); j++) {
                sum += graph[i].get(j);
            }
            if (sum > max) {
                max = sum;
                res = i;
            }
        }
        return res;
    }
}
