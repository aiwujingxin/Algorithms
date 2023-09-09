package leetcode;


import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/8 17:36
 */
public class LeetCode2497 {

    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        List<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        //构建无向图，目标节点的值小于 0 时，不添加。
        for (int[] e : edges) {
            if (vals[e[1]] > 0) {
                list[e[0]].add(e[1]);
            }
            if (vals[e[0]] > 0) {
                list[e[1]].add(e[0]);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            //list的自定义排序，从大到小
            list[i].sort((a, b) -> vals[b] - vals[a]);
            int temp = vals[i];
            for (int j = 0; j < Math.min(k, list[i].size()); j++) {
                temp += vals[list[i].get(j)];
            }
            max = Math.max(max, temp);
        }
        return max;
    }
}
