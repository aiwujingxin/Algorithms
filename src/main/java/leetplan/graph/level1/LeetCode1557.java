package leetplan.graph.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/22 22:21
 */
public class LeetCode1557 {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        if (edges == null || edges.size() == 0) {
            return new ArrayList<>();
        }
        int[] in = new int[n];
        for (List<Integer> node : edges) {
            in[node.get(1)]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }
}
