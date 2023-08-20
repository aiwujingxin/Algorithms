package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/14 21:24
 */
public class LeetCode2467 {

    //https://leetcode.cn/problems/most-profitable-path-in-a-tree/solutions/2027285/-by-wa-pian-d-q2on/

    Map<Integer, Integer> bobs;
    int ans;
    int[] amount;
    List<Integer>[] graph;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        this.amount = amount;
        int len = edges.length;
        int n = len + 1;
        // init
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        bobs = new HashMap<>();
        ans = Integer.MIN_VALUE;
        findBob(-1, 0, bob);
        tryAlice(-1, 0, 0, 0);
        return ans;
    }

    private int findBob(int from, int start, int bob) {
        if (start == bob) {
            bobs.put(bob, 0);
            return 1;
        }
        List<Integer> next = graph[start];
        if (next.size() == 1 && from != -1) {
            return -1;
        }
        for (int n : next) {
            if (n != from) {
                int cur = findBob(start, n, bob);
                if (cur != -1) {
                    bobs.put(start, cur);
                    return cur + 1;
                }
            }
        }
        return -1;
    }

    private void tryAlice(int from, int time, int start, int point) {
        List<Integer> next = graph[start];
        int bob = bobs.getOrDefault(start, -1);
        int amt = this.amount[start];
        if (bob != -1) {
            if (bob == time) {
                amt >>= 1;
            } else if (bob < time) {
                amt = 0;
            }
        }
        point += amt;
        if (next.size() == 1 && from != -1) {
            ans = Math.max(ans, point);
            return;
        }
        for (int n : next) {
            if (n != from) {
                tryAlice(start, time + 1, n, point);
            }
        }
    }
}
