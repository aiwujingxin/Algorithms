package knowledge.datastructure.graph.shortestpath.impl;

import knowledge.datastructure.graph.shortestpath.ShortestPath;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/29 21:40
 * @description SPFA(Shortest Path Faster Algorithm)精选题单与算法模板
 * <算法定位>
 * SPFA 是 Bellman-Ford 的队列优化,不是独立的贪心算法。
 * Bellman-Ford 每轮扫描所有边;SPFA 只让“距离刚刚变小”的节点进入队列,再用它松弛出边。
 * 核心依据:若 dist[u] 没有变化,从 u 出发的任何边都不可能产生新的有效松弛。
 * <适用条件>
 * - 单源最短路允许负权边,但从源点可达的子图中不能存在负环。
 * - 图通常较稀疏,且有效松弛范围明显小于全图时,队列优化才可能获得实际收益。
 * - 状态最短路可将 State(位置,资源...) 视为扩展图节点,对完整状态执行同样的松弛。
 * - 多源问题可把所有源点以距离 0 同时入队,等价于增加一个零权虚拟源点。
 * <核心数据结构>
 * - dist[u]:当前已发现的源点到 u 的最短距离上界。
 * - queue:保存距离变小、需要继续传播影响的活跃节点。
 * - inQueue[u]:只表示 u 当前是否在队列中,用于避免重复入队;它不是永久 visited。
 * - count[u]:记录当前最短路径经过的边数,用于检测可达负环。
 * <执行链路>
 * 1. dist[source]=0,源点入队,其余距离初始化为 INF。
 * 2. 弹出 u 并清除 inQueue[u],枚举每条出边 (u,v,w)。
 * 3. 若 dist[u]+w<dist[v],更新 dist[v];若 v 当前不在队列中,将其入队。
 * 4. 队列为空时,所有边都无法继续松弛,dist 达到 Bellman-Ford 的不动点。
 * <正确性与重要性质>
 * - 松弛不变量:dist 始终是某条已发现路径的长度,只会变小,不会漏掉有效路径。
 * - 与 Bellman-Ford 等价:两者执行同一组松弛操作,区别只在边的调度顺序。
 * - 不具备“弹出即定稿”:队列不按距离排序,节点出队后仍可能被改善并再次入队。
 * - 不能首次到达目标就返回:必须等待相关松弛完成,通常在算法结束后读取 dist[target]。
 * - 允许负权边:负边只会触发再次松弛;真正导致最短路不存在的是可达负环。
 * - 队列为空即收敛:若无可达负环,有限个节点的距离最终不再变化。
 * <负环检测>
 * - 单源检测:只从 source 入队,只能发现从 source 可达的负环。
 * - 全图检测:建立超级源点向所有节点连零权边,或初始时将所有节点以距离 0 入队。
 * - 当某条不断改善的路径包含至少 V 条边时,其中必然重复节点;若仍能变短,说明存在负环。
 * - 检测到负环后不存在有限最短距离,应立即终止并返回约定的失败结果。
 * <复杂度>
 * - 空间复杂度 O(V+E),状态图中对应 O(S+T)。
 * - 随机稀疏图上通常较快,但不存在可靠的平均 O(E) 保证。
 * - 最坏时间复杂度 O(VE),状态图中为 O(ST),可被链式反复松弛数据卡退化。
 * - SLF/LLL 等队列顺序优化只改善常数和部分数据表现,不改变最坏复杂度。
 * <算法选择决策表>
 * ▸ 无权图或所有边权相等       → BFS,节点首次访问即可定稿
 * ▸ 边权仅为 0/1              → 0-1 BFS,双端队列保证距离非降序
 * ▸ 所有边权非负              → Dijkstra,复杂度稳定且可弹出定稿
 * ▸ DAG,边权可正可负           → 拓扑序松弛,严格 O(V+E)
 * ▸ 存在负权边且图较稀疏       → 可尝试 SPFA
 * ▸ 需要稳定复杂度或数据对抗性强 → Bellman-Ford / 其他专用算法
 * <实现注意事项>
 * - inQueue 在节点出队时必须恢复为 false,否则该节点后续无法再次入队。
 * - 只有成功松弛后才入队;同一节点已在队列中时不重复加入。
 * - 执行 dist[u]+w 前确保 dist[u] 可达,并选择足够安全的 INF 防止整数溢出。
 * - 邻接表适合稀疏图;邻接矩阵会让每次出队都扫描 O(V),削弱队列优化意义。
 * - 非负权图虽然也能运行 SPFA,但通常应优先选择复杂度更稳定的 Dijkstra。
 * <I. 标准与受限最短路>
 * @see leetcode.problems.LeetCode787_SPFA [M] K站中转内最便宜的航班 (按允许边数分层松弛)
 * <II. 状态扩展最短路>
 * @see leetcode.problems.LeetCode1928_SPFA [H] State(city,time) 规定时间内到达终点的最小花费
 * @see leetcode.problems.LeetCode2093_SPFA [M] State(city,remainingDiscounts) 前往目标城市的最低费用
 * @see leetcode.problems.LeetCode1293_SPFA [H] State(row,col,remaining) 网格中的最短路径
 * @see leetcode.problems.lists.lcp.LCP35_SPFA [H] State(city,power) 电动车游城市
 * <III. 多源与单位权退化>
 * @see leetcode.problems.LeetCode1162_SPFA [M] 多源 SPFA;单位权下本质等价于多源 BFS
 * <IV. 广义松弛>
 * @see leetcode.problems.LeetCode1514_SPFA [M] 最大概率路径 (加法最短改为乘法最大)
 * <V. 项目中的等价队列松弛>
 * @see leetcode.problems.LeetCode1263 [H] 走路权 0、推箱权 1;队列重复松弛完整状态
 * @see leetcode.problems.LeetCode505 [M] 迷宫 II;队列重复松弛滚动距离
 */
public class SPFA implements ShortestPath {

    final static int INF = 0x3f3f3f3f;

    /**
     * 计算有向图中源点到其余节点的最短距离,并检测源点可达的负环。
     *
     * @param n     节点数量
     * @param edges 有向边,每条边格式为 {from, to, weight}
     * @param s     源点编号
     * @return 最短距离数组;检测到可达负环时返回 null
     */
    public int[] shortestPath(int n, int[][] edges, int s) {
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }
        int[] cnt = new int[n]; // 记录点进队次数. 判断负环
        int[] d = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(d, INF);
        d[s] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        vis[s] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            vis[u] = false;
            for (int[] ne : graph[u]) {
                int v = ne[0];
                int w = ne[1];
                if (d[v] > d[u] + w) {
                    d[v] = d[u] + w;
                    if (!vis[v]) {
                        q.add(v); // 只考察有必要的点
                        vis[v] = true;
                        cnt[v]++;
                        if (cnt[v] >= n) {
                            System.out.println("图中存在负权回路");
                            return null;
                        }
                    }
                }
            }
        }
        return d;
    }
}
