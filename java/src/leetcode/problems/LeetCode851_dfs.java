package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/1 15:01
 * @description 记忆化搜索
 * 如果没有 memo，计算每个节点都需要遍历整棵依赖树
 * 节点0: 需要遍历 0->1->2->3->...
 * 节点1: 需要遍历 1->2->3->...
 * 节点2: 需要遍历 2->3->...
 * 导致大量重复计算
 */
public class LeetCode851_dfs {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] pair : richer) graph[pair[1]].add(pair[0]);
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) result[i] = dfs(i, graph, quiet, memo);
        return result;
    }

    private int dfs(int person, List<Integer>[] graph, int[] quiet, int[] memo) {
        if (memo[person] != -1) return memo[person];
        int min = person;
        for (int richer : graph[person]) {
            int candidate = dfs(richer, graph, quiet, memo);
            if (quiet[candidate] < quiet[min]) min = candidate;
        }
        memo[person] = min;
        return min;
    }
}
