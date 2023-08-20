package leetcode;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/13 12:40
 */
public class LeetCode1273_topo {

    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        int[] outDegree = new int[nodes];

        for (int i = 1; i < nodes; i++) {
            outDegree[parent[i]]++;
        }

        int[] count = new int[nodes];
        Arrays.fill(count, 1);

        // 子节点
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < outDegree.length; i++) {
            if (outDegree[i] == 0) {
                deque.add(i);
            }
        }

        while (!deque.isEmpty()) {
            int node = deque.poll();
            if (value[node] == 0) {
                count[node] = 0;
            }
            int parentNode = parent[node];
            if (parentNode == -1) {
                continue;
            }
            outDegree[parentNode]--;
            if (outDegree[parentNode] == 0) {
                deque.add(parentNode);
            }
            value[parentNode] += value[node];
            count[parentNode] += count[node];
        }
        return count[0];
    }
}
