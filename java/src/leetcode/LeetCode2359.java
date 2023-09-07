package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/7 22:51
 */
public class LeetCode2359 {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        // 点 node1 和 node2 到其它所有点的最短路径
        int[] dist1 = getDist(edges, node1);
        int[] dist2 = getDist(edges, node2);
        int ans = -1, min = Integer.MAX_VALUE;
        // 遍历可选择的「中间点」
        for (int i = 0; i < n; i++) {
            // 分别为 node1 和 node2 到 i 的最短路径
            int d1 = dist1[i], d2 = dist2[i];
            // 如果有一方到不了，则跳过
            if (d1 == -1 || d2 == -1) {
                continue;
            }
            int max = Math.max(d1, d2);
            if (max < min) {
                min = max;
                ans = i;
            }
        }
        return ans;
    }

    // 求点 s 到其它所有点的最短路径
    private int[] getDist(int[] edges, int s) {
        int d = 0;
        int[] dist = new int[edges.length];
        Arrays.fill(dist, -1);
        while (s != -1) {
            // 已经访问，考虑「环」的存在
            if (dist[s] != -1) {
                break;
            }
            dist[s] = d++;
            s = edges[s];
        }
        return dist;
    }
}
