package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/13 12:57
 */
public class LeetCode2049 {

    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] score;
    int n;
    int cnt;
    long maxScore = 0;

    public int countHighestScoreNodes(int[] parents) {
        if (parents == null || parents.length == 0) {
            return 0;
        }
        n = parents.length;
        // build tree
        preorder(parents);
        score = new int[parents.length];
        dfs(0);
        return cnt;
    }

    private int dfs(int node) {
        long score = 1;
        int size = 0;

        for (int c : map.get(node)) {
            int t = dfs(c);
            score *= t;
            size += t;
        }
        if (node != 0) {
            score *= n - size - 1;
        }
        if (score == maxScore) {
            cnt++;
        } else if (score > maxScore) {
            maxScore = score;
            cnt = 1;
        }
        return size + 1;
    }

    private void preorder(int[] parents) {
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(i, new ArrayList<>());
        }
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] != -1) {
                map.get(parents[i]).add(i);
            }
        }
    }
}
