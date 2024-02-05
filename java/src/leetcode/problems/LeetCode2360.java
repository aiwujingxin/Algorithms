package leetcode.problems;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/7 23:40
 * @link <a href="https://leetcode.cn/problems/longest-cycle-in-a-graph/solutions/1710861/by-flix-gcit/">...</a>
 * @see LeetCode2127
 */
public class LeetCode2360 {

    public int longestCycle(int[] edges) {
        /*
        基环树+拓扑排序
        拓扑排序可以优先逐步筛选掉那些入度为0的节点，最后就只剩下成环的节点了
        拓扑排序总体思路为:
        1.定义入度数组并统计每个节点的入度，首次先将入度为0点节点入队
        2.将上一轮的入队的节点的弹出删除，并将出队节点指向的节点入度-1，如果此时又有节点入度为0就入队，以此类推直至队列为空
        (注意上述过程入队的节点都要进行标记后面不能再用)
        3.剩下的节点就是成环的，入度永远也不可能为0的节点了
            这里可以提前判断一下剩余节点个数是不是为0了，如果是可以提前退出
        4.枚举每个节点进行for循环遍历(因为只有一条出边因此可以用for循环代替DFS/BFS)
            如果已经删除掉的就跳过，如果不是就证明这个节点必然在环中，直接for循环遍历并统计最大长度
            遍历过的环同样进行标记避免下一次重复访问
            那么最后统计到的最大长度就是最长环
        时间复杂度:O(N) 空间复杂度:O(N)
         */
        int n = edges.length;
        boolean[] vis = new boolean[n];
        Queue<Integer> que = new LinkedList<>();    // 辅助队列
        int[] inDegree = new int[n];    // 入度数组
        for (int e : edges) {
            if (e != -1) inDegree[e]++;
        }
        // 入度为0的节点优先入队
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                que.add(i);
                vis[i] = true;  // 标记访问
            }
        }
        while (!que.isEmpty()) {
            int poll = que.poll();  // 删除节点poll
            int next = edges[poll]; // 指向的节点索引
            // 注意可能不成环的情况next在最后一个节点为-1，因此要加一个判断
            if (next != -1 && --inDegree[next] == 0) { // 由于删除了节点poll因此其指向的节点对应入度也-1，若为0就入队
                que.add(next);
                vis[next] = true;
            }
        }
        int res = -1;
        // 剩下的节点就是环上的节点
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;   // 访问过的节点跳过
            // 否则就是未访问过的环上的节点
            int cur = i, cycleNum = 0;
            while (!vis[edges[cur]]) {
                cur = edges[cur];
                cycleNum++;
                vis[cur] = true;
            }
            res = Math.max(res, cycleNum);  // 维护环的最大值
        }
        return res;
    }
}
