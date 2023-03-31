package leetcode.lists.hot200;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/30 19:15
 * {@link  /main/GO/leetcode/lists/offerII/Offer115.go}
 */
public class LeetCode444 {


    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();

        for (List<Integer> sequence : sequences) {
            for (int num : sequence) {
                if (num < 1 || num > nums.length) {
                    return false;
                }
                graph.putIfAbsent(num, new HashSet<>());
                inDegrees.putIfAbsent(num, 0);
            }
            for (int i = 0; i < sequence.size() - 1; i++) {
                if (!graph.get(sequence.get(i)).contains(sequence.get(i + 1))) {
                    graph.get(sequence.get(i)).add(sequence.get(i + 1));
                    inDegrees.put(sequence.get(i + 1), inDegrees.get(sequence.get(i + 1)) + 1);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Integer in : inDegrees.keySet()) {
            if (inDegrees.get(in) == 0) {
                queue.add(in);
            }
        }

        List<Integer> built = new LinkedList<>();
        while (queue.size() == 1) {//important
            int num = queue.poll();
            built.add(num);

            for (Integer next : graph.get(num)) {
                inDegrees.put(next, inDegrees.get(next) - 1);
                if (inDegrees.get(next) == 0) {
                    queue.add(next);
                }
            }
        }

        System.out.println(Arrays.toString(built.stream().mapToInt(i -> i).toArray()));
        return Arrays.equals(built.stream().mapToInt(i -> i).toArray(), nums);
    }

    //====dp===
    public boolean sequenceReconstruction_DP(int[] nums, List<List<Integer>> sequences) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int[] sub = new int[n + 1];

        for (int i = 0; i < n; i++) {
            sub[nums[i]] = i;
        }

        for (List<Integer> sequence : sequences) {
            for (int j = 1; j < sequence.size(); j++) {
                if (sub[sequence.get(j)] - sub[sequence.get(j - 1)] == 1) {
                    dp[sub[sequence.get(j)]] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!dp[i]) {
                return false;
            }
        }
        return true;
    }
}
