package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/21 22:21
 */
public class LeetCode787_bfs {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]>[] edge = new List[n];
        int[] prices = new int[n];
        for(int i = 0; i < n; ++i){
            edge[i] = new ArrayList<>();
            prices[i] = Integer.MAX_VALUE;
        }
        for(int[] flight : flights){
            edge[flight[0]].add(new int[]{flight[1], flight[2]});
        }
        prices[src] = 0;
        queue.add(new int[]{src, 0, prices[src]});
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            if(poll[1] > k) break;
            for(int[] next : edge[poll[0]]){
                if(prices[next[0]] > poll[2] + next[1]){
                    prices[next[0]] = poll[2] + next[1];
                    queue.add(new int[]{next[0], poll[1] + 1, prices[next[0]]});
                }
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
