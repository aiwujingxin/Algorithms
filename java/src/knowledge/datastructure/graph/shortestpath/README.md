# 最短路径：从“松弛”到状态图的统一方法

最短路径不是一组互不相关的模板，而是一套统一的建模方法：

> 把问题中的完整局面看成节点，把一次合法决策看成边，把决策代价看成边权，然后选择与边权性质匹配的松弛顺序。

真正需要掌握的不是“Dijkstra、Bellman-Ford、SPFA 分别怎么背”，而是下面四个问题：

1. **节点到底表示什么状态？**
2. **边权有什么性质：等权、0/1、非负、可能为负？**
3. **求单源、单目标、多源，还是全源最短路？**
4. **距离何时可以定稿，何时必须允许反复修正？**

本文以当前包中的实现为主线，解释各算法之间的关系、正确性、选择依据，以及它们在项目题目中的实际建模方式。

---

## 1. 最短路的本质：状态、转移与松弛

### 1.1 图不一定来自题目输入

题目给出的道路、航班天然是一张图，但很多问题表面上没有图：

- 转动一次密码锁；
- 移动空白滑块；
- 拿着不同钥匙走到同一个格子；
- 在不同剩余电量下到达同一城市；
- 推箱子后箱子和玩家分别位于不同位置。

只要存在“当前局面”和“下一步合法操作”，就存在一张隐式图：

```text
节点 = 完整状态
边   = 一次合法操作
边权 = 这次操作新增的代价
```

例如“城市 + 电量”问题中，单独使用城市编号不能唯一描述未来能力：

```text
(city=3, power=0) 不能直接开车
(city=3, power=5) 可以继续行驶
```

它们必须是两个不同节点。

### 1.2 `dist` 是当前最优路径的上界

初始化时：

```text
dist[source] = 0
dist[other]  = INF
```

对于一条边 `(u, v, w)`，如果经过 `u` 到 `v` 更优：

```text
dist[u] + w < dist[v]
```

就执行：

```text
dist[v] = dist[u] + w
```

这一步叫作**松弛（relaxation）**。

所有最短路算法都在做松弛，区别仅在于：

- 先松弛哪条边；
- 一条边需要松弛几次；
- 一个节点何时可以确认“以后不可能更优”。

### 1.3 两种核心工作模式

| 模式 | 代表算法 | 节点能否反复修改 | 核心依据 |
| :--- | :--- | :---: | :--- |
| 定稿型（Label Setting） | BFS、0-1 BFS、Dijkstra | 定稿后不能修改 | 按距离非降序处理 |
| 修正型（Label Correcting） | Bellman-Ford、SPFA | 可以反复修改 | 持续松弛直到收敛 |

此外，DAG 最短路、Floyd-Warshall 可以看成按确定阶段顺序执行的动态规划。

---

## 2. 当前包的算法地图

统一入口 [ShortestPath.java](ShortestPath.java) 定义了基础单源最短路契约：

```java
int[] shortestPath(int n, int[][] edges, int source);
```

它适合返回“一个源点到所有普通节点”的距离数组。各实现对不可达值和边方向的具体处理仍需结合模板确认。

下面三类模板没有直接实现该接口：

- `StateDijkstra` 返回任意目标状态的单个 `long` 距离；
- `Johnson` 返回所有点对距离矩阵；
- A* 通常只返回指定起点到指定目标的结果。

| 模板 | 边权条件 | 解决范围 | 时间复杂度 | 核心结构 |
| :--- | :--- | :--- | :--- | :--- |
| [BFS01](impl/BFS01.java) | `0/1` | 单源 | `O(V+E)` | 双端队列 |
| [Dijkstra](impl/Dijkstra.java) | 非负 | 单源 | `O((V+E)logV)` | 小顶堆 |
| [StateDijkstra](impl/StateDijkstra.java) | 状态边非负 | 单目标状态图 | `O((S+T)logS)` | `HashMap + PriorityQueue` |
| [BellmanFord](impl/BellmanFord.java) | 可含负权 | 单源、负环 | `O(VE)` | 边集 |
| [SPFA](impl/SPFA.java) | 可含负权 | 单源、负环 | 最坏 `O(VE)` | 队列 |
| [TopoOrder](impl/TopoOrder.java) | DAG，可含负权 | 单源 | `O(V+E)` | 拓扑序 |
| [FloydWarshall](impl/FloydWarshall.java) | 可含负权，无负环 | 全源 | `O(V^3)` | 二维 DP |
| [Johnson](impl/Johnson.java) | 可含负权，无负环 | 稀疏图全源 | `O(VE+V(E+V)logV)` | BF + Dijkstra |

其中：

- `V、E` 表示原图节点数和边数；
- `S、T` 表示扩展状态图中实际可达的状态数和转移数。

状态题的复杂度必须按 `S、T` 计算，不能仍然只看原图的 `V、E`。

---

## 3. 一张决策表选算法

按下面顺序判断，通常可以直接确定模板。

| 问题特征 | 首选算法 | 原因 |
| :--- | :--- | :--- |
| 无权图或所有边权相等 | BFS | 层数就是距离 |
| 边权只有 `0/1` | 0-1 BFS | 双端队列维持距离顺序 |
| 非负权稀疏图 | Dijkstra | 稳定、可提前结束 |
| 非负权稠密图 | 朴素 Dijkstra | `O(V^2)` 避免堆常数 |
| DAG，边权可正可负 | 拓扑序松弛 | 每条边只处理一次 |
| 存在负权边 | Bellman-Ford | 稳定 `O(VE)` |
| 负权稀疏图且数据温和 | SPFA | 可能跳过大量无效边 |
| 点数较小的全源最短路 | Floyd-Warshall | 实现直接，`O(V^3)` |
| 稀疏图全源最短路且含负边 | Johnson | 重赋权后重复 Dijkstra |
| 只求单目标且有可靠估价 | A* | 用启发函数减少搜索范围 |
| 位置外还有资源/历史 | 状态扩展 + 对应最短路 | 必须完整状态去重 |

需要特别注意：

```text
非负权图可以运行 SPFA，但通常不应该优先使用 SPFA。
0/1 图可以运行 Dijkstra，但 0-1 BFS 更简单且复杂度更优。
DAG 可以运行 Bellman-Ford，但拓扑序只需线性时间。
```

算法“能跑”不等于“应该选”。

---

## 4. BFS 与 0-1 BFS：最简单的定稿模型

### 4.1 为什么普通 BFS 能求最短路

无权图中每条边代价都相同，可以统一看成 `1`。

BFS 按层扩展：

```text
第 0 层：起点
第 1 层：一步可达
第 2 层：两步可达
...
```

因此节点第一次出队时，其层数就是最短距离。

一旦边权不相等，“步数少”就不再代表“总代价小”，普通 BFS 失效。

### 4.2 0-1 BFS 为什么只需要双端队列

当边权只可能是 `0` 或 `1`：

- 经过 `0` 权边，距离不增加，应当优先继续处理；
- 经过 `1` 权边，距离增加一层，可以延后处理。

于是：

```java
if (w == 0) {
    deque.addFirst(v);
} else {
    deque.addLast(v);
}
```

双端队列模拟了只有两个优先级的小顶堆。

### 4.3 与 Dijkstra 的关系

```text
BFS      = 所有边权相等时的 Dijkstra
0-1 BFS  = 边权只有两个等级时的 Dijkstra
Dijkstra = 一般非负边权下的统一实现
```

项目模板：[BFS01.java](impl/BFS01.java)

代表题：

- [LeetCode2290：到达角落需要移除障碍物的最小数目](../../../../leetcode/problems/LeetCode2290.java)
- [LeetCode3286：穿越网格图的安全路径](../../../../leetcode/problems/LeetCode3286.java)
- [LeetCode1263：推箱子](../../../../leetcode/problems/LeetCode1263.java)，走路权 `0`、推箱权 `1`

---

## 5. Dijkstra：非负权为什么能贪心定稿

项目模板：[Dijkstra.java](impl/Dijkstra.java)

### 5.1 核心过程

```text
1. 起点距离为 0，放入小顶堆。
2. 弹出当前候选距离最小的节点 u。
3. 跳过过期候选。
4. 用 u 松弛所有邻边。
5. 距离变小的节点重新入堆。
```

### 5.2 定稿证明

设 `u` 是当前最小的未定稿节点。

假设未来存在一条更短路径到达 `u`，这条路径必须先经过另一个未定稿节点 `x`。

由于 `u` 是当前最小候选：

```text
dist[x] >= dist[u]
```

又因为后续边权非负：

```text
dist[x] + 后续代价 >= dist[x] >= dist[u]
```

矛盾。因此 `u` 弹出时即可定稿。

这也是负权边会破坏 Dijkstra 的原因：如果后续边可能为负，上面的不等式不再成立。

### 5.3 Java 中的懒删除

`PriorityQueue` 不支持高效的 `decrease-key`，所以距离变小时直接插入新候选：

```text
(u, 10) 旧候选
(u,  6) 新候选
```

弹出旧候选时：

```java
if (cost > dist[u]) {
    continue;
}
```

这就是懒删除。不要在节点入堆时永久标记 `visited`，因为更短路径可能尚未出现。

### 5.4 什么时候可以提前返回

目标节点**有效弹出**时可以返回：

```java
if (cost > dist[u]) continue;
if (u == target) return cost;
```

不能在生成目标邻居或目标首次入堆时返回，因为堆中可能还有更短候选。

### 5.5 代表题型

#### 标准加法最短路

- [LeetCode743：网络延迟时间](../../../../leetcode/problems/LeetCode743.java)
- [LeetCode1334：阈值距离内邻居最少的城市](../../../../leetcode/problems/LeetCode1334_Dijkstra.java)
- [LeetCode2662：前往目标的最小代价](../../../../leetcode/problems/LeetCode2662.java)
- [LeetCode3112：访问消失节点的最少时间](../../../../leetcode/problems/LeetCode3112.java)

#### 网格与隐式图

- [LeetCode1631：最小体力消耗路径](../../../../leetcode/problems/LeetCode1631.java)
- [LeetCode2577：在网格图中访问一个格子的最少时间](../../../../leetcode/problems/LeetCode2577.java)
- [LeetCode3341：到达最后一个房间的最少时间 I](../../../../leetcode/problems/LeetCode3341.java)
- [LeetCode505：迷宫 II](../../../../leetcode/problems/LeetCode505_state.java)

---

## 6. Bellman-Ford：用轮次控制路径边数

项目模板：[BellmanFord.java](impl/BellmanFord.java)

### 6.1 为什么最多执行 `V-1` 轮

不存在负环时，最短路一定可以转换为简单路径。

一个含 `V` 个节点的简单路径最多只有 `V-1` 条边，因此扫描全部边 `V-1` 轮后，所有最短距离都应传播完成。

### 6.2 第 `V` 轮为什么可以检测负环

如果第 `V` 轮仍能更新，说明存在一条至少包含 `V` 条边的更优路径。

这条路径必然重复某个节点，即包含一个环。重复经过该环后距离仍然变小，说明环权和为负。

### 6.3 原地更新与备份数组

普通最短路允许原地更新：

```text
本轮刚更新的 dist[v] 可以继续更新后面的节点
```

这样可能在一轮内传播多条边，只会加速收敛。

但如果题目限制“最多使用 K 条边”，必须隔离轮次：

```java
int[] backup = dist.clone();
for (Edge e : edges) {
    dist[e.to] = Math.min(dist[e.to], backup[e.from] + e.weight);
}
```

否则同一轮可能连续走多条边，突破边数限制。

代表题：

- [LeetCode787：K 站中转内最便宜的航班](../../../../leetcode/problems/LeetCode787_BellmanFord.java)
- [LeetCode1928：规定时间内到达终点的最小花费](../../../../leetcode/problems/LeetCode1928_BellmanFord.java)
- [LeetCode2093：前往目标城市的最低费用](../../../../leetcode/problems/LeetCode2093_Bellman.java)
- [LeetCode1514：概率最大的路径](../../../../leetcode/problems/LeetCode1514_BellmanFord.java)

---

## 7. SPFA：只传播真正发生变化的节点

项目模板：[SPFA.java](impl/SPFA.java)

### 7.1 它与 Bellman-Ford 的关系

Bellman-Ford 不管一条边是否可能更新，每轮都扫描全部边。

SPFA 观察到：

> 只有 `dist[u]` 刚刚变小，`u` 的出边才可能产生新的有效松弛。

因此用队列维护“活跃节点”。

### 7.2 `inQueue` 不是 `visited`

```text
inQueue[u] = true  只表示 u 当前在队列里
```

节点出队后必须恢复为 `false`。如果它之后又被更短路径改善，必须允许再次入队。

SPFA 不具备 Dijkstra 的“出队定稿”性质，所以不能首次到达目标就返回。

### 7.3 复杂度必须保守看待

SPFA 在很多稀疏图上很快，但不存在稳定的 `O(E)` 保证。

```text
最好/常见数据：可能接近线性
最坏情况：O(VE)
```

对抗数据可以让节点反复入队。非负权图应优先选择 Dijkstra，0/1 图应优先选择 0-1 BFS。

### 7.4 项目题型

- [LeetCode787_SPFA](../../../../leetcode/problems/LeetCode787_SPFA.java)：边数受限
- [LeetCode1928_SPFA](../../../../leetcode/problems/LeetCode1928_SPFA.java)：`State(city,time)`
- [LeetCode2093_SPFA](../../../../leetcode/problems/LeetCode2093_SPFA.java)：`State(city,remainingDiscounts)`
- [LeetCode1293_SPFA](../../../../leetcode/problems/LeetCode1293_SPFA.java)：`State(row,col,remaining)`
- [LCP35_SPFA](../../../../leetcode/problems/lists/lcp/LCP35_SPFA.java)：`State(city,power)`
- [LeetCode1162_SPFA](../../../../leetcode/problems/LeetCode1162_SPFA.java)：多源、单位权，实质退化为 BFS
- [LeetCode1514_SPFA](../../../../leetcode/problems/LeetCode1514_SPFA.java)：乘法最大松弛

---

## 8. DAG 最短路：拓扑序就是天然处理顺序

项目模板：[TopoOrder.java](impl/TopoOrder.java)

DAG 中没有环。按拓扑序处理节点时，所有可能到达当前节点的前驱都已经处理完，因此当前距离可以直接用于更新后继。

```text
拓扑排序 + 每条边松弛一次
```

复杂度：

```text
拓扑排序 O(V+E)
松弛全部边 O(E)
总计 O(V+E)
```

DAG 最短路允许负权边，因为不存在环，更不存在负环。

这是一个重要选择原则：

> 看见负权边不要立刻使用 Bellman-Ford；如果图是 DAG，拓扑序更优。

DAG 最短路也可以求最长路，只需把 `min` 改为 `max` 并调整初始值。

---

## 9. 全源最短路：Floyd-Warshall 与 Johnson

### 9.1 Floyd-Warshall：枚举允许经过的中间点

项目模板：[FloydWarshall.java](impl/FloydWarshall.java)

定义：

```text
dist[i][j] = 当前允许的中间点集合下，i 到 j 的最短距离
```

加入中间点 `k` 时只有两种选择：

```text
不经过 k：dist[i][j]
经过 k：  dist[i][k] + dist[k][j]
```

转移：

```text
dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
```

循环顺序必须让 `k` 位于最外层，因为 `k` 表示 DP 阶段。

复杂度：

```text
时间 O(V^3)
空间 O(V^2)
```

适合：

- 点数较小；
- 图较稠密；
- 需要大量任意两点查询；
- 传递闭包、最小环等 Floyd 变形。

代表题：

- [LeetCode1462：课程表 IV](../../../../leetcode/problems/LeetCode1462_Floyd.java)
- [LeetCode3015：按最短距离统计城市对](../../../../leetcode/problems/LeetCode3015.java)

### 9.2 Johnson：让负边变成非负边

项目模板：[Johnson.java](impl/Johnson.java)

Johnson 解决：

```text
稀疏图 + 全源最短路 + 允许负边 + 不允许负环
```

步骤：

1. 增加超级源点 `s`，向所有节点连权重为 `0` 的边；
2. Bellman-Ford 求势能 `h[v]`；
3. 对每条边重赋权：

```text
w'(u,v) = w(u,v) + h[u] - h[v]
```

4. 在非负权新图上从每个源点运行 Dijkstra；
5. 把距离还原：

```text
dist(u,v) = dist'(u,v) - h[u] + h[v]
```

为什么重赋权不改变最短路径？

一条从 `s` 到 `t` 的路径上，势能项会望远镜消去：

```text
Σ(w + h[u] - h[v]) = Σw + h[s] - h[t]
```

对于固定起终点，所有路径都增加同一个常数，因此最优路径顺序不变。

---

## 10. 状态 Dijkstra：把资源约束变成普通图

项目模板：[StateDijkstra.java](impl/StateDijkstra.java)

### 10.1 为什么只按位置去重会错

考虑“规定时间内最小费用”：

```text
到达城市 3，花费 10，已用时间 90
到达城市 3，花费 15，已用时间 20
```

第一条路径费用更小，但可能已经没有时间到达终点；第二条路径仍有后续空间。

所以节点必须定义为：

```text
State(city,time)
```

而不是只有 `city`。

### 10.2 通用模板的三个钩子

```java
public interface Problem {
    State start();
    boolean isGoal(State s);
    List<Edge> neighbors(State s);
}
```

题目只负责：

1. 起点是什么；
2. 什么状态算目标；
3. 当前状态可以如何转移。

`State` 使用全部整型坐标参与 `equals/hashCode`，`HashMap` 因而按完整状态去重。

### 10.3 状态维度如何寻找

判断一段历史是否需要进入状态，只问一句：

> 两条路径到达相同位置后，如果这段历史不同，未来可选操作或代价是否可能不同？

如果答案是“会”，它必须进入状态。

常见资源维：

- 已使用边数；
- 已用时间；
- 剩余电量；
- 已用折扣次数；
- 剩余障碍消除次数；
- 钥匙集合；
- 上一次操作类型；
- 上一次跳跃距离；
- 整个棋盘排列。

### 10.4 当前项目中的状态映射

| 题目 | 完整状态 | 资源如何变化 |
| :--- | :--- | :--- |
| [787](../../../../leetcode/problems/LeetCode787_state.java) | `(city, usedEdges)` | 每飞一次 `usedEdges+1` |
| [1928](../../../../leetcode/problems/LeetCode1928_state.java) | `(city, time)` | 行驶后 `time+roadTime` |
| [2093](../../../../leetcode/problems/LeetCode2093_state.java) | `(city, usedDiscounts)` | 可原价或消耗一次折扣 |
| [LCP35](../../../../leetcode/problems/lists/lcp/LCP35_state.java) | `(city, power)` | 充电增加，行驶减少 |
| [864](../../../../leetcode/problems/LeetCode864_state.java) | `(row, col, keyMask)` | 捡钥匙时设置对应位 |
| [1293](../../../../leetcode/problems/LeetCode1293_state.java) | `(row, col, remaining)` | 进入障碍时减一 |
| [847](../../../../leetcode/problems/LeetCode847_state.java) | `(node, visitedMask)` | 到达节点时加入集合 |
| [1263](../../../../leetcode/problems/LeetCode1263_state.java) | `(boxRow,boxCol,playerRow,playerCol)` | 玩家移动权 0，推箱权 1 |
| [1654](../../../../leetcode/problems/LeetCode1654_state.java) | `(position,lastBackward)` | 后跳后禁止继续后跳 |
| [403](../../../../leetcode/problems/LeetCode403_state.java) | `(stoneIndex,lastJump)` | 下一跳为 `k-1/k/k+1` |
| [752](../../../../leetcode/problems/LeetCode752_state.java) | `(d0,d1,d2,d3)` | 转动一个数字 |
| [773](../../../../leetcode/problems/LeetCode773_state.java) | `(c0,c1,...,c5)` | 交换空格和相邻滑块 |
| [505](../../../../leetcode/problems/LeetCode505_state.java) | `(row,col)` | 一次滚动到停止点 |

### 10.5 六个代表性建模细节

#### 787：中转站数与航班数

`K` 个中转站意味着最多使用 `K+1` 条航班边。

```text
State(city,usedEdges)
usedEdges <= K 时还可以再飞一条边
```

边界条件错一位是这类题最常见的问题。

#### 1928：最小化费用，时间只是约束

```text
状态维：time
距离值：cost
```

不要把“状态资源”和“优化目标”混在一起。

#### LCP35：充电也是一条边

在 `(city,power)` 状态图中：

```text
充 1 度电：(city,power) -> (city,power+1)，代价 charge[city]
开车：      (city,power) -> (next,power-need)，代价 need
```

原题中的“操作”自然变成状态图中的边。

#### 864：集合信息压缩成位掩码

六把钥匙用六个二进制位表示：

```text
mask | (1 << key)      捡起钥匙
mask & (1 << lock)     判断能否开锁
```

同一个格子携带不同钥匙集合时，未来能力完全不同。

#### 847：多源问题转成单源

可以从任意节点开始，因此增加虚拟起点：

```text
virtual -> State(i, 1<<i)，边权 0
```

这样无需修改通用模板的单起点接口。

#### 1263：为什么玩家位置也必须进入状态

即使箱子位置相同，玩家位于箱子不同侧面时，可推动方向不同。

因此只记录箱子坐标会错误合并状态，必须记录：

```text
State(boxRow,boxCol,playerRow,playerCol)
```

### 10.6 状态爆炸与支配剪枝

通用模板按完整状态精确去重，但不会自动识别支配关系。

例如同一城市：

```text
状态 A：费用更低、剩余电量更多
状态 B：费用更高、剩余电量更少
```

如果 A 在所有维度都不差于 B，则 B 被 A 支配，可以剪掉。

但支配关系必须由具体题目证明，不能放进完全通用的模板中。

---

## 11. A*：给 Dijkstra 加上方向感

项目实现：[AStar.java](../../../algorithms/search/bfs/AStar.java)

Dijkstra 按已付出的真实代价 `g(x)` 排序；A* 按：

```text
f(x) = g(x) + h(x)
```

其中 `h(x)` 是从当前状态到目标的估价。

如果 `h(x)` 从不高估真实剩余代价，则 A* 可以保持最优性；若启发函数还满足一致性，节点通常无需重复展开。

特殊情况：

```text
h(x) = 0
```

A* 就退化为 Dijkstra。

代表题：[LeetCode1091：二进制矩阵中的最短路径](../../../../leetcode/problems/LeetCode1091.java)

---

## 12. 不只是“路径和”：Dijkstra 的常见变形

### 12.1 最大概率路径

普通最短路：

```text
dist[v] = min(dist[v], dist[u] + w)
```

最大概率：

```text
prob[v] = max(prob[v], prob[u] * p)
```

使用大顶堆，每次定稿当前成功概率最大的节点。

代表题：[LeetCode1514](../../../../leetcode/problems/LeetCode1514_Dij.java)

### 12.2 瓶颈最短路

路径代价不是边权之和，而是路径最大边：

```text
nd = max(dist[u], w)
dist[v] = min(dist[v], nd)
```

代表题：

- [LeetCode1631：最小体力消耗路径](../../../../leetcode/problems/LeetCode1631.java)
- [LeetCode778：水位上升的泳池中游泳](../../../../leetcode/problems/LeetCode778.java)

### 12.3 最短路计数

维护：

```text
dist[v] 最短距离
ways[v] 达到该最短距离的方案数
```

转移：

```text
发现更短：dist 覆盖，ways[v] = ways[u]
发现等长：ways[v] += ways[u]
```

代表题：[LeetCode1976](../../../../leetcode/problems/LeetCode1976.java)

### 12.4 次短路

每个节点不再只保留一个距离，而是保留最小和次小距离：

```text
first[v]
second[v]
```

代表题：[LeetCode2045](../../../../leetcode/problems/LeetCode2045.java)

---

## 13. 常见错误清单

### 13.1 看到“最短”就直接 Dijkstra

先检查边权：

```text
存在负边 -> Dijkstra 定稿证明失效
```

### 13.2 只按位置去重

如果时间、电量、钥匙、次数会影响未来，位置相同不代表状态相同。

### 13.3 目标入堆时提前返回

只有 Dijkstra 的目标状态**有效弹出**时才能返回。

Bellman-Ford、SPFA 不存在弹出定稿，必须等待收敛或使用额外证明。

### 13.4 把 `inQueue` 当成永久访问标记

SPFA 节点出队后可能再次变优，必须允许重新入队。

### 13.5 限制 K 条边却原地更新

Bellman-Ford 同一轮原地更新可能连续走多条边，限制边数时必须使用上一轮备份。

### 13.6 忘记不可达判断

执行：

```text
INF + negativeWeight
```

可能制造伪距离。Bellman-Ford 松弛前必须确认 `dist[u]` 有限。

### 13.7 比较器和距离溢出

避免：

```java
(a, b) -> a.cost - b.cost
```

应使用：

```java
Long.compare(a.cost, b.cost)
```

路径和可能超过 `int` 时，距离和堆中代价必须统一使用 `long`。

### 13.8 混淆有向图与无向图

当前包中模板的输入方向并不完全相同：

| 模板 | 当前实现对输入边的处理 |
| :--- | :--- |
| `Dijkstra` | 自动添加双向边 |
| `BFS01` | 自动添加双向边 |
| `BellmanFord` | 按有向边处理 |
| `SPFA` | 按有向边处理 |
| `TopoOrder` | 按有向边处理 |
| `FloydWarshall` | 按有向边处理 |

调用前必须确认题意和模板方向一致。

---

## 14. 正确性证明工具箱

### 14.1 最优子结构

最短路径的任意前缀也是对应端点之间的最短路径，否则替换前缀即可得到更短完整路径。

### 14.2 松弛不变量

`dist[v]` 始终对应某条真实路径，因此是最短距离的上界；成功松弛只会让上界更紧。

### 14.3 贪心切分

Dijkstra 将节点切分为已定稿集合和未定稿集合，利用非负边证明跨越切分的第一条路径不可能改善当前最小候选。

### 14.4 轮次归纳

Bellman-Ford 使用备份数组时，可归纳证明第 `k` 轮后得到最多使用 `k` 条边的最短距离。

### 14.5 阶段 DP

Floyd-Warshall 的阶段是“允许使用前 `k` 个中间点”；DAG 最短路的阶段是拓扑顺序。

### 14.6 状态等价性

状态压缩必须满足：

> 两条历史映射到同一状态后，它们拥有完全相同的未来合法操作和转移代价。

如果不满足，就丢失了影响未来的信息。

---

## 15. 学习路线

建议按下面顺序掌握：

1. **BFS**：理解层序和第一次访问最短。
2. **Dijkstra**：理解非负权、弹出定稿和懒删除。
3. **0-1 BFS**：理解它是二值优先级的 Dijkstra。
4. **Bellman-Ford**：理解松弛轮数和负环。
5. **SPFA**：理解它只优化调度，不改变最坏复杂度。
6. **DAG 最短路**：理解结构信息可以替代通用算法。
7. **Floyd-Warshall**：理解中间点集合 DP。
8. **Johnson**：理解势能重赋权。
9. **StateDijkstra**：把资源、历史、集合加入状态。
10. **A* 与广义 Dijkstra**：理解最优优先搜索的统一框架。

完成一道新题后，用下面的 Checklist 复盘：

- [ ] 节点是否包含影响未来的全部信息？
- [ ] 每条边表示什么操作，边权表示什么代价？
- [ ] 边权是否非负、是否只有 0/1、图是否是 DAG？
- [ ] 求单源、单目标、多源还是全源？
- [ ] 节点何时定稿，能否提前返回？
- [ ] 去重键是否是完整状态？
- [ ] 是否存在支配剪枝？
- [ ] 状态数和转移数上界是多少？
- [ ] `int` 是否可能溢出？
- [ ] 输入边是有向还是无向？

---

## 16. 最终心法

遇到最短路问题时，不要先问“套哪个模板”，而要按以下顺序思考：

```text
完整状态是什么
    ↓
一次合法转移是什么
    ↓
优化目标和资源约束分别是什么
    ↓
边权具有什么性质
    ↓
距离应按什么顺序传播
    ↓
选择 BFS / 0-1 BFS / Dijkstra / BF / SPFA / DAG / Floyd / Johnson
```

所有模板最终都回到同一个动作：

```text
用已经知道的更优状态，尝试改善它能到达的下一个状态。
```

区别只在于，什么状态值得先处理，以及它何时可以永远定稿。
