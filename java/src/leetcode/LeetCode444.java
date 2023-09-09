package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/30 19:15
 * @see ../go/src/leetcode/offerII/Offer115.go
 */
public class LeetCode444 {

    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int n = nums.length;
        int[] indegrees = new int[n + 1];
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> sequence : sequences) {
            for (int i = 1; i < sequence.size(); i++) {
                graph[sequence.get(i - 1)].add(sequence.get(i));
                indegrees[sequence.get(i)]++;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        if (queue.size() > 1) {
            return false;
        }
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            int num = queue.poll();
            for (int next : graph[num]) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return true;
    }
}
