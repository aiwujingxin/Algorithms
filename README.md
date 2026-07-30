# 🌌 算法与数据结构 知识图谱 (DSA Roadmap)

> *“算法是程序的灵魂，数据结构是程序的骨架。”*
> 本仓库以 **ACM 竞赛模板** 风格系统沉淀了从基础到竞赛级别的核心算法体系。所有模板均遵循统一的 JavaDoc 规范（`@author` / `@date` / `@description` / `@see` 题号索引），追求极致简洁、可直接复用。

**快速导航**：[算法](#-算法-algorithms) · [数据结构](#-数据结构-data-structures) · [数学](#-数学-mathematics) · [深度笔记](#-深度笔记-notebook) · [学习路线](#-推荐学习顺序)

---

## 📖 如何使用

- **代码位置**：全部知识点位于 [`java/src/knowledge`](java/src/knowledge)，按 `algorithms`（算法）、`datastructure`（数据结构）、`mathematics`（数学）三大主线组织。
- **导航入口**：三条主线及核心模块均提供「全景索引」类，聚合模板、适用边界与配套题单。
- **深度笔记**：[`knowledge/notebook`](java/src/knowledge/notebook) 收录了「六维深度解析框架」的专题文档与 XMind 思维导图。
- **工程约定**：Java 21，无 Maven/Gradle；模板信任题目输入，以 `javac` 整树编译校验。
- **当前规模**：共 **403** 个知识模板，另有 `leetcode` 题解作为 `@see` 实战索引。

| 主线 | 文件数 | 知识范围 | 全景索引 |
| :--- | ---: | :--- | :--- |
| 🧮 算法 | 186 | 基础算法、搜索、分治、贪心、动态规划 | [Algorithms.java](java/src/knowledge/algorithms/Algorithms.java) |
| 🧱 数据结构 | 143 | 线性结构、树、堆、字符串、图、高级数据结构 | [DataStructure.java](java/src/knowledge/datastructure/DataStructure.java) |
| 🔢 数学 | 74 | 数论、线性代数、组合、几何、概率、高精度 | [Mathematics.java](java/src/knowledge/mathematics/Mathematics.java) |

### 🗺️ 知识全景

| 层次 | 模块 |
| :--- | :--- |
| **基础表示与操作** | 数组、链表、栈、队列、哈希、字符串、位运算、前缀和与差分 |
| **基础算法范式** | 二分、倍增、双指针、滑动窗口、排序、搜索、分治、贪心 |
| **状态与递推** | 线性 / 区间 / 树形 / 状压 / 数位 / 概率 DP，背包体系，博弈论，DP 优化 |
| **结构化查询** | 堆、单调结构、并查集、ST 表、树状数组、线段树、主席树、树链剖分 |
| **图与字符串** | 最短路、生成树、连通性、二分图、网络流、欧拉图、KMP、Trie、AC 自动机、后缀结构 |
| **数学工具链** | 模运算、素数与分解、同余方程、矩阵、NTT、组合计数、计算几何、随机算法、高精度 |

### 🧭 推荐学习顺序

1. **基础层**：数组 / 链表 / 栈 / 队列 → 排序 / 二分 → 前缀和 / 差分 / 双指针。
2. **方法层**：DFS / BFS → 分治 / 贪心 → 线性 DP / 背包 / 区间 DP。
3. **结构层**：堆 / 并查集 / ST 表 → 树状数组 / 线段树 → 平衡树 / 可持久化结构。
4. **专题层**：字符串 → 图论 → 数论 / 组合数学 / 计算几何 / 概率。
5. **竞赛进阶**：状态压缩、数位 DP、DP 优化、网络流、Pollard-Rho、NTT、半平面交。

---

## 🧮 算法 (Algorithms)

### 🔍 二分 · 倍增 · 分治

| 主题 | 核心模板 |
| :--- | :--- |
| **二分查找** | [BinarySearch](java/src/knowledge/algorithms/binarysearch/BinarySearch.java)（左右边界 / 二分答案） |
| **倍增** | [BinaryLifting](java/src/knowledge/algorithms/binarylifting/BinaryLifting.java) · [BinaryLiftingLCA](java/src/knowledge/algorithms/binarylifting/BinaryLiftingLCA.java) · [SparseTable](java/src/knowledge/algorithms/binarylifting/SparseTable.java) · [QuickPow](java/src/knowledge/algorithms/binarylifting/QuickPow.java) |
| **分治** | [DivideConquer](java/src/knowledge/algorithms/divideconquer/DivideConquer.java) · [InversionCount](java/src/knowledge/algorithms/divideconquer/InversionCount.java) · [MaxSubArrayDivide](java/src/knowledge/algorithms/divideconquer/MaxSubArrayDivide.java) · [CDQDivideConquer](java/src/knowledge/algorithms/divideconquer/CDQDivideConquer.java) |

### 🎯 贪心 · 位运算 · 前缀和差分

* **贪心**：[Greedy](java/src/knowledge/algorithms/greedy/Greedy.java)（价值优先 / 区间问题 / 贪心构造 / 跳跃游戏 / 反悔贪心，配 [Greedy.md](java/src/knowledge/algorithms/greedy/Greedy.md)）
* **位运算**：[BIT](java/src/knowledge/algorithms/bit/BIT.java)（位运算技巧） · [XorBasis](java/src/knowledge/algorithms/bit/XorBasis.java)（线性基）
* **前缀和 / 差分**：[PreSum](java/src/knowledge/algorithms/presumAnddiff/PreSum.java) · [PreDiff](java/src/knowledge/algorithms/presumAnddiff/PreDiff.java)

### 👉 双指针 & 滑动窗口

> 索引：[TwoPoint](java/src/knowledge/algorithms/twopoint/TwoPoint.java) · [SlidingWindow](java/src/knowledge/algorithms/twopoint/SlidingWindow.java)

* **双指针**：相向指针 · 快慢指针（[FastSlowPointers](java/src/knowledge/algorithms/twopoint/impl/FastSlowPointers.java)）· Floyd 判圈（[CycleDetection](java/src/knowledge/algorithms/twopoint/impl/CycleDetection.java)）· 三数之和（[ThreeSumTemplate](java/src/knowledge/algorithms/twopoint/impl/ThreeSumTemplate.java)）· 荷兰国旗（[DutchFlag](java/src/knowledge/algorithms/twopoint/impl/DutchFlag.java)）· 双序列匹配（[TwoSequencePointers](java/src/knowledge/algorithms/twopoint/impl/TwoSequencePointers.java)）
* **滑动窗口**：定长（[FixedSlidingWindow](java/src/knowledge/algorithms/twopoint/impl/slidingwindow/FixedSlidingWindow.java)）· 变长最长/最短（[VariableSlidingWindowLongest](java/src/knowledge/algorithms/twopoint/impl/slidingwindow/VariableSlidingWindowLongest.java) / [Shortest](java/src/knowledge/algorithms/twopoint/impl/slidingwindow/VariableSlidingWindowShortest.java)）· 恰好 K 个（[ExactSlidingWindow](java/src/knowledge/algorithms/twopoint/impl/slidingwindow/ExactSlidingWindow.java)）· 单调队列优化（[MonotonicQueueSlidingWindow](java/src/knowledge/algorithms/twopoint/impl/slidingwindow/MonotonicQueueSlidingWindow.java)）

### 🔀 排序 (Sort)

> 索引：[Sort](java/src/knowledge/algorithms/sort/Sort.java) · [IndexingSort](java/src/knowledge/algorithms/sort/IndexingSort.java)

| 分类 | 模板 |
| :--- | :--- |
| **比较排序** | [Bubble](java/src/knowledge/algorithms/sort/comparison/BubbleSort.java) · [Insert](java/src/knowledge/algorithms/sort/comparison/InsertSort.java) · [Select](java/src/knowledge/algorithms/sort/comparison/SelectSort.java) · [Shell](java/src/knowledge/algorithms/sort/comparison/ShellSort.java) · [Merge](java/src/knowledge/algorithms/sort/comparison/MergeSort.java) · [Quick](java/src/knowledge/algorithms/sort/comparison/QuickSort.java) · [Heap](java/src/knowledge/algorithms/sort/comparison/HeapSort.java) |
| **非比较排序** | [Counting](java/src/knowledge/algorithms/sort/noncomparison/CountingSort.java) · [Radix](java/src/knowledge/algorithms/sort/noncomparison/RadixSort.java) · [Bucket](java/src/knowledge/algorithms/sort/noncomparison/BucketSort.java)（Offset 支持负数） |
| **选择型** | [QuickSelect](java/src/knowledge/algorithms/sort/selection/QuickSelect.java) · [HeapSelect](java/src/knowledge/algorithms/sort/selection/HeapSelect.java) · [TopK](java/src/knowledge/algorithms/sort/selection/TopK.java) |

### 🚀 搜索 (Search)

> 索引：[Search](java/src/knowledge/algorithms/search/Search.java)

* **BFS**：[BFS](java/src/knowledge/algorithms/search/bfs/BFS.java) · 多源（[MultiBFS](java/src/knowledge/algorithms/search/bfs/MultiBFS.java)）· 双向（[BiBFS](java/src/knowledge/algorithms/search/bfs/BiBFS.java)）· 状态压缩（[StateBFS](java/src/knowledge/algorithms/search/bfs/StateBFS.java)）· 限制层数（[LimitBFS](java/src/knowledge/algorithms/search/bfs/LimitBFS.java)）· A\* 寻路（[AStar](java/src/knowledge/algorithms/search/bfs/AStar.java)），配 [BFS大融合.md](java/src/knowledge/notebook/markdown/BFS大融合.md)
* **DFS**：[DFS](java/src/knowledge/algorithms/search/dfs/DFS.java) · 回溯（[Backtrack](java/src/knowledge/algorithms/search/dfs/Backtrack.java)）· 洪水填充（[FloodFill](java/src/knowledge/algorithms/search/dfs/FloodFill.java)）· 迭代加深（[IDDFS](java/src/knowledge/algorithms/search/dfs/IDDFS.java)）· IDA\*（[IDAStar](java/src/knowledge/algorithms/search/dfs/IDAStar.java)）
* **综合实战**：[八数码、埃及分数、迷宫、装载、调度与 TSP 分支限界](java/src/knowledge/algorithms/search/problems)

### 🧠 动态规划 (Dynamic Programming)

> 索引：[DP](java/src/knowledge/algorithms/dp/DP.java)

* **🗂️ 基础模型**
  * 线性 DP：[Sequence](java/src/knowledge/algorithms/dp/linerdp/Sequence.java) · [MatrixPath](java/src/knowledge/algorithms/dp/linerdp/MatrixPath.java) · [StatusMachine](java/src/knowledge/algorithms/dp/linerdp/StatusMachine.java)
  * 区间 DP：[IntervalDP](java/src/knowledge/algorithms/dp/intervaldp/IntervalDP.java) · [PalindromeDP](java/src/knowledge/algorithms/dp/intervaldp/PalindromeDP.java)
  * 树形 DP：[TreeDP](java/src/knowledge/algorithms/dp/treedp/TreeDP.java)
  * 记忆化搜索：[DFSMemo](java/src/knowledge/algorithms/dp/memoization/DFSMemo.java)
* **🎒 背包问题**（索引：[BackPack](java/src/knowledge/algorithms/dp/backpack/BackPack.java)）
  * 01 / 完全 / 多重 / 混合 / 分组 / 依赖 / 二维费用背包，及方案数、路径、第 K 优解等衍生（[solution](java/src/knowledge/algorithms/dp/backpack/solution)）
* **🔮 进阶模型**
  * 状态压缩：[CompressDP](java/src/knowledge/algorithms/dp/compressdp/CompressDP.java)
  * 数位 DP：[DigitDP](java/src/knowledge/algorithms/dp/digitdp/DigitDP.java)
  * 概率期望：[ExpectationDP](java/src/knowledge/algorithms/dp/probabilitydp/ExpectationDP.java)
  * 博弈论：[GameDP](java/src/knowledge/algorithms/dp/gamedp/GameDP.java) · [NimGame](java/src/knowledge/algorithms/dp/gamedp/NimGame.java) · [SpragueGrundy](java/src/knowledge/algorithms/dp/gamedp/SpragueGrundy.java)
* **⚡ DP 优化**（索引：[OptimizeDP](java/src/knowledge/algorithms/dp/optimizedp/OptimizeDP.java)）
  * 斜率优化：[SlopeOptimization](java/src/knowledge/algorithms/dp/optimizedp/SlopeOptimization.java) · 决策单调性：[DecisionMonotonicity](java/src/knowledge/algorithms/dp/optimizedp/DecisionMonotonicity.java)

---

## 🧱 数据结构 (Data Structures)

> 索引：[DataStructure](java/src/knowledge/datastructure/DataStructure.java)

### 📏 线性结构

* **数组 / 矩阵 / 区间**：[Arrays](java/src/knowledge/datastructure/array/Arrays.java) · [Matrix](java/src/knowledge/datastructure/array/Matrix.java) · [Interval](java/src/knowledge/datastructure/array/Interval.java)
* **链表**：[LinkedList](java/src/knowledge/datastructure/list/LinkedList.java) · [DoubleLinkedList](java/src/knowledge/datastructure/list/DoubleLinkedList.java)
* **栈**：[Stack](java/src/knowledge/datastructure/stack/Stack.java) · [MonotonicStack](java/src/knowledge/datastructure/stack/MonotonicStack.java)
* **队列**：[Queue](java/src/knowledge/datastructure/queue/Queue.java) · [MonotonicQueue](java/src/knowledge/datastructure/queue/MonotonicQueue.java) · [CircularQueue](java/src/knowledge/datastructure/queue/CircularQueue.java) · [CircularDeque](java/src/knowledge/datastructure/queue/CircularDeque.java) · [二维滑动窗口](java/src/knowledge/datastructure/queue/impl/SlidingWindowMatrix.java) · [多维滑动窗口](java/src/knowledge/datastructure/queue/impl/SlidingWindowND.java)
* **哈希**：[Hash](java/src/knowledge/datastructure/hash/Hash.java) · [MyHashMap](java/src/knowledge/datastructure/hash/impl/MyHashMap.java)

### 🌲 树与堆

* **二叉树遍历**：[Tree](java/src/knowledge/datastructure/tree/Tree.java) · 前中后序 / 层序 / N 叉树 / Morris 遍历（[tree/traverse](java/src/knowledge/datastructure/tree/traverse)）· BST 与二叉树序列化（[tree/serialize](java/src/knowledge/datastructure/tree/serialize)）
* **平衡树族**：[BSTree](java/src/knowledge/datastructure/tree/bst/BSTree.java) · [AVLTree](java/src/knowledge/datastructure/tree/bst/AVLTree.java) · [RedBlackTree](java/src/knowledge/datastructure/tree/bst/RedBlackTree.java) · [TreapTree](java/src/knowledge/datastructure/tree/bst/TreapTree.java) · [SplayTree](java/src/knowledge/datastructure/tree/bst/SplayTree.java) · [IntervalTree](java/src/knowledge/datastructure/tree/bst/IntervalTree.java)
* **堆**：[Heap](java/src/knowledge/datastructure/heap/Heap.java) · [BinaryHeap](java/src/knowledge/datastructure/heap/BinaryHeap.java) · [MaxHeap](java/src/knowledge/datastructure/heap/MaxHeap.java) · 对顶堆（[AbstractDualHeap](java/src/knowledge/datastructure/heap/AbstractDualHeap.java) / [MidDualHeap](java/src/knowledge/datastructure/heap/MidDualHeap.java) / [KthDualHeap](java/src/knowledge/datastructure/heap/KthDualHeap.java)）· [TopKHeap](java/src/knowledge/datastructure/heap/TopKHeap.java)，配 [堆_对顶堆与有序多重集_深度解析.md](java/src/knowledge/notebook/markdown/堆_对顶堆与有序多重集_深度解析.md)
* **有序多重集 / 极值容器**：[SkipList](java/src/knowledge/datastructure/other/impl/SkipList.java) · [TreeMultiset](java/src/knowledge/datastructure/other/impl/TreeMultiset.java) · [MinMaxContainer](java/src/knowledge/datastructure/other/MinMaxContainer.java)（Deque / 双堆 / 堆 / TreeMap / 线段树实现对比）

### 🏗️ 高级数据结构

> 索引：[AdvancedDS](java/src/knowledge/datastructure/adv/AdvancedDS.java)

| 主题 | 模板 |
| :--- | :--- |
| **RMQ / 并查集** | [STTable](java/src/knowledge/datastructure/adv/STTable.java) · [UnionFind](java/src/knowledge/datastructure/adv/UnionFind.java) |
| **树状数组 BIT** | [原理与变种](java/src/knowledge/datastructure/adv/BIT/README.md) · [BITree](java/src/knowledge/datastructure/adv/BIT/BITree.java)（单点改/区间和）· [BITreeRange](java/src/knowledge/datastructure/adv/BIT/BITreeRange.java)（区间改/区间和）· [BITree2D](java/src/knowledge/datastructure/adv/BIT/BITree2D.java)（二维矩形和）· [BITreeKth](java/src/knowledge/datastructure/adv/BIT/BITreeKth.java)（排名/第 K 小）· [BITreeMax](java/src/knowledge/datastructure/adv/BIT/BITreeMax.java)（前缀最大值）· [BITreeRangeMax](java/src/knowledge/datastructure/adv/BIT/BITreeRangeMax.java)（区间最大值） |
| **线段树 Segment Tree** | [SegTree](java/src/knowledge/datastructure/adv/segtree/SegTree.java) · 懒标记（[LazySegmentTree](java/src/knowledge/datastructure/adv/segtree/LazySegmentTree.java)）· 动态开点（[DynamicSegmentTree](java/src/knowledge/datastructure/adv/segtree/DynamicSegmentTree.java)）· 可持久化/主席树（[PersistentSegmentTree](java/src/knowledge/datastructure/adv/segtree/PersistentSegmentTree.java) / [FuncSegmentTree](java/src/knowledge/datastructure/adv/segtree/FuncSegmentTree.java)） |
| **树链剖分** | [HeavyLightDecomposition](java/src/knowledge/datastructure/adv/HeavyLightDecomposition.java) |

### 🔤 字符串 (Strings)

> 索引：[IString](java/src/knowledge/datastructure/string/IString.java)

* **模式匹配**：[KMP](java/src/knowledge/datastructure/string/match/KMP.java) · [Z 函数](java/src/knowledge/datastructure/string/match/ZAlgorithm.java) · [Rabin-Karp](java/src/knowledge/datastructure/string/match/RabinKarp.java) · [Boyer-Moore](java/src/knowledge/datastructure/string/match/BoyerMoore.java) · [单 / 双哈希匹配](java/src/knowledge/datastructure/string/match) · [AC 自动机](java/src/knowledge/datastructure/string/match/ACMaton.java)
* **字典树 / AC 自动机**：[Trie](java/src/knowledge/datastructure/string/trie/Trie.java) · [ACAutomaton](java/src/knowledge/datastructure/string/trie/ACAutomaton.java)
* **回文与后缀**：[Manacher](java/src/knowledge/datastructure/string/manacher/Manacher.java) · [SuffixArray](java/src/knowledge/datastructure/string/suffix/SuffixArray.java) · [SuffixAutomaton](java/src/knowledge/datastructure/string/suffix/SuffixAutomaton.java) · [SuffixTree](java/src/knowledge/datastructure/string/suffix/SuffixTree.java)
* **字符串哈希与计算**：[StringHash](java/src/knowledge/datastructure/string/hash/StringHash.java) · [DStringHash](java/src/knowledge/datastructure/string/hash/DStringHash.java) · [中缀转后缀 / 字符串数值转换](java/src/knowledge/datastructure/string/problems)

### 🕸️ 图论 (Graph Theory)

> 索引：[Graph](java/src/knowledge/datastructure/graph/Graph.java)

| 主题 | 模板 |
| :--- | :--- |
| **最短路** | [专题 README](java/src/knowledge/datastructure/graph/shortestpath/README.md) · [Dijkstra](java/src/knowledge/datastructure/graph/shortestpath/impl/Dijkstra.java) · [StateDijkstra](java/src/knowledge/datastructure/graph/shortestpath/impl/StateDijkstra.java) · [BellmanFord](java/src/knowledge/datastructure/graph/shortestpath/impl/BellmanFord.java) · [SPFA](java/src/knowledge/datastructure/graph/shortestpath/impl/SPFA.java) · [FloydWarshall](java/src/knowledge/datastructure/graph/shortestpath/impl/FloydWarshall.java) · [Johnson](java/src/knowledge/datastructure/graph/shortestpath/impl/Johnson.java) · [BFS01](java/src/knowledge/datastructure/graph/shortestpath/impl/BFS01.java) · [TopoOrder](java/src/knowledge/datastructure/graph/shortestpath/impl/TopoOrder.java) |
| **最小生成树** | [Kruskal](java/src/knowledge/datastructure/graph/mst/impl/Kruskal.java) · [Prim](java/src/knowledge/datastructure/graph/mst/impl/Prim.java) |
| **拓扑排序** | [TopoBFS](java/src/knowledge/datastructure/graph/topological/impl/TopoBFS.java) · [TopoDFS](java/src/knowledge/datastructure/graph/topological/impl/TopoDFS.java) |
| **连通性** | 连通分量（[BFS / DFS / 并查集](java/src/knowledge/datastructure/graph/connectivity/components)）· 环检测（[BFS / DFS / 并查集](java/src/knowledge/datastructure/graph/connectivity/hascycle)）· 强连通（[Tarjan](java/src/knowledge/datastructure/graph/connectivity/directed/Tarjan.java) / [Kosaraju](java/src/knowledge/datastructure/graph/connectivity/directed/Kosaraju.java)）· 点/边双连通（[TarjanVDCC](java/src/knowledge/datastructure/graph/connectivity/undirected/TarjanVDCC.java) / [TarjanEDCC](java/src/knowledge/datastructure/graph/connectivity/undirected/TarjanEDCC.java)）· 割点/桥（[TarjanPoint](java/src/knowledge/datastructure/graph/connectivity/undirected/TarjanPoint.java) / [TarjanEdge](java/src/knowledge/datastructure/graph/connectivity/undirected/TarjanEdge.java)） |
| **二分图** | 判定（[BiGraphBFS](java/src/knowledge/datastructure/graph/bipartite/impl/BiGraphBFS.java) / [BiGraphDFS](java/src/knowledge/datastructure/graph/bipartite/impl/BiGraphDFS.java)）· 匈牙利（[Hungarian](java/src/knowledge/datastructure/graph/bipartite/impl/Hungarian.java)）· [HopcroftKarp](java/src/knowledge/datastructure/graph/bipartite/impl/HopcroftKarp.java) · [KM](java/src/knowledge/datastructure/graph/bipartite/impl/KM.java) |
| **网络流** | [Dinic](java/src/knowledge/datastructure/graph/networkflow/impl/Dinic.java) · [ISAP](java/src/knowledge/datastructure/graph/networkflow/impl/ISAP.java) · [EdmondsKarp](java/src/knowledge/datastructure/graph/networkflow/impl/EdmondsKarp.java) · [FordFulkerson](java/src/knowledge/datastructure/graph/networkflow/impl/FordFulkerson.java) |
| **其他专题** | LCA（[LCA](java/src/knowledge/datastructure/graph/lca/LCA.java)）· 欧拉路（[eulergraph](java/src/knowledge/datastructure/graph/eulergraph/impl)）· 差分约束（[DiffConstraint](java/src/knowledge/datastructure/graph/diffconstraint/DiffConstraint.java)）· 基环树（[FundamentalCycle](java/src/knowledge/datastructure/graph/pseudotree/FundamentalCycle.java)） |

---

## 🔢 数学 (Mathematics)

> 索引：[Mathematics](java/src/knowledge/mathematics/Mathematics.java) · 通用工具 [MathUtil](java/src/knowledge/mathematics/MathUtil.java)。配套长文见 [算法的尽头是数学.md](java/src/knowledge/notebook/markdown/算法的尽头是数学.md)。

### ➗ 代数与数论 (Algebra)

> 索引：[Algebra](java/src/knowledge/mathematics/algebra/Algebra.java) · 工具 [NumberTheory](java/src/knowledge/mathematics/algebra/util/NumberTheory.java)

* **素数与分解**：[Sieve](java/src/knowledge/mathematics/algebra/impl/Sieve.java) · [MillerRabin](java/src/knowledge/mathematics/algebra/impl/MillerRabin.java) · [PollardRho](java/src/knowledge/mathematics/algebra/impl/PollardRho.java)
* **同余方程**：[EXCRT](java/src/knowledge/mathematics/algebra/impl/EXCRT.java) · [BSGS](java/src/knowledge/mathematics/algebra/impl/BSGS.java) / [ExBSGS](java/src/knowledge/mathematics/algebra/impl/ExBSGS.java) · [QuadraticResidue](java/src/knowledge/mathematics/algebra/impl/QuadraticResidue.java)
* **线性代数**：[Matrix](java/src/knowledge/mathematics/algebra/impl/Matrix.java)（行列式/秩/求逆）· [GaussElimination](java/src/knowledge/mathematics/algebra/impl/GaussElimination.java) · [LinearBasis](java/src/knowledge/mathematics/algebra/impl/LinearBasis.java)
* **变换与反演**：[NTT](java/src/knowledge/mathematics/algebra/impl/NTT.java) · [MobiusInversion](java/src/knowledge/mathematics/algebra/impl/MobiusInversion.java)

### 🎲 组合数学 (Combinatorics)

> 索引：[Combinatorics](java/src/knowledge/mathematics/combinatorics/Combinatorics.java) · 工具 [CombinatoricsUtil](java/src/knowledge/mathematics/combinatorics/util/CombinatoricsUtil.java)

* **计数基础**：[PascalsTriangle](java/src/knowledge/mathematics/combinatorics/impl/PascalsTriangle.java)（nCr 表）· [Multinomial](java/src/knowledge/mathematics/combinatorics/impl/Multinomial.java) · [StarsAndBars](java/src/knowledge/mathematics/combinatorics/impl/StarsAndBars.java) · [IntegerPartition](java/src/knowledge/mathematics/combinatorics/impl/IntegerPartition.java)
* **特殊数列**：[CatalanNumber](java/src/knowledge/mathematics/combinatorics/impl/CatalanNumber.java) · [BellNumber](java/src/knowledge/mathematics/combinatorics/impl/BellNumber.java) · [StirlingNumbers](java/src/knowledge/mathematics/combinatorics/impl/StirlingNumbers.java)（[第一类](java/src/knowledge/mathematics/combinatorics/impl/FirstKindStirling.java)）· [EulerianNumber](java/src/knowledge/mathematics/combinatorics/impl/EulerianNumber.java)
* **高级技巧**：[LucasTheorem](java/src/knowledge/mathematics/combinatorics/impl/LucasTheorem.java) / [ExLucas](java/src/knowledge/mathematics/combinatorics/impl/ExLucas.java) · [InclusionExclusion](java/src/knowledge/mathematics/combinatorics/impl/InclusionExclusion.java) · [BurnsidePolya](java/src/knowledge/mathematics/combinatorics/impl/BurnsidePolya.java)

### 📐 计算几何 (Geometry)

> 索引：[Geometry](java/src/knowledge/mathematics/geometry/Geometry.java) · 工具 [ComputationalGeometry](java/src/knowledge/mathematics/geometry/util/ComputationalGeometry.java)

* **凸包与卡壳**：[ConvexHull](java/src/knowledge/mathematics/geometry/impl/ConvexHull.java) · [RotatingCalipers](java/src/knowledge/mathematics/geometry/impl/RotatingCalipers.java) · [ConvexPolygonContains](java/src/knowledge/mathematics/geometry/impl/ConvexPolygonContains.java)（O(log n) 判定）
* **点/多边形/圆**：[PointInPolygon](java/src/knowledge/mathematics/geometry/impl/PointInPolygon.java) · [CircleOperations](java/src/knowledge/mathematics/geometry/impl/CircleOperations.java) · [MinimumEnclosingCircle](java/src/knowledge/mathematics/geometry/impl/MinimumEnclosingCircle.java)
* **进阶**：[HalfPlaneIntersection](java/src/knowledge/mathematics/geometry/impl/HalfPlaneIntersection.java)（半平面交）· [ClosestPair](java/src/knowledge/mathematics/geometry/impl/ClosestPair.java)（最近点对）

### 🎯 概率论 (Probability)

> 索引：[Probability](java/src/knowledge/mathematics/probability/Probability.java)

* **随机抽样**：[FisherYates](java/src/knowledge/mathematics/probability/impl/FisherYates.java) · 水塘抽样（[ReservoirSamplingK](java/src/knowledge/mathematics/probability/impl/ReservoirSamplingK.java) / [WeightedReservoirSampling](java/src/knowledge/mathematics/probability/impl/WeightedReservoirSampling.java)）· [AliasMethod](java/src/knowledge/mathematics/probability/impl/AliasMethod.java)
* **期望与马尔可夫**：[IndicatorExpectation](java/src/knowledge/mathematics/probability/impl/IndicatorExpectation.java)（期望线性性）· [ExpectationDP](java/src/knowledge/mathematics/probability/impl/ExpectationDP.java) / [GaussDP](java/src/knowledge/mathematics/probability/impl/GaussDP.java) · [MarkovChain](java/src/knowledge/mathematics/probability/impl/MarkovChain.java)（稳态分析）
* **随机选择**：[QuickSelect](java/src/knowledge/mathematics/probability/impl/QuickSelect.java)（随机划分，期望 O(n) 求第 k 小）

### 🧮 高精度 (Big Number)

> 索引：[BigDecimal](java/src/knowledge/mathematics/bigdecimal/BigDecimal.java)

* **四则运算**：[Add](java/src/knowledge/mathematics/bigdecimal/impl/BigDecimalAdd.java) · [Sub](java/src/knowledge/mathematics/bigdecimal/impl/BigDecimalSub.java) · [Mul](java/src/knowledge/mathematics/bigdecimal/impl/BigDecimalMul.java) · [Div](java/src/knowledge/mathematics/bigdecimal/impl/BigDecimalDiv.java) · [Pow](java/src/knowledge/mathematics/bigdecimal/impl/BigDecimalPow.java) · [Sqrt](java/src/knowledge/mathematics/bigdecimal/impl/BigDecimalSqrt.java)
* **进阶算法**：[Karatsuba](java/src/knowledge/mathematics/bigdecimal/impl/Karatsuba.java)（大数乘法）· [BigNumberMod](java/src/knowledge/mathematics/bigdecimal/impl/BigNumberMod.java) · [BigGcd](java/src/knowledge/mathematics/bigdecimal/impl/BigGcd.java)（Stein GCD）· [RepeatingDecimal](java/src/knowledge/mathematics/bigdecimal/impl/RepeatingDecimal.java)（循环小数）· [BaseConversion](java/src/knowledge/mathematics/bigdecimal/impl/BaseConversion.java) · [链表加减法](java/src/knowledge/mathematics/bigdecimal/impl)

---

## 📚 深度笔记 (Notebook)

「六维深度解析框架」专题与 XMind 思维导图见 [`knowledge/notebook`](java/src/knowledge/notebook)：

* [跨越算法鸿沟的通用方法论.md](java/src/knowledge/notebook/markdown/跨越算法鸿沟的通用方法论.md)
* [算法的尽头只有四个字：同构与降维.md](java/src/knowledge/notebook/markdown/算法的尽头只有四个字：同构与降维.md)
* [融会贯通的数据结构深度解析.md](java/src/knowledge/notebook/markdown/融会贯通的数据结构深度解析.md)
* [数学算法知识体系：从公式到可复用模板.md](java/src/knowledge/notebook/markdown/数学算法知识体系：从公式到可复用模板%20.md)
* [贪心.md](java/src/knowledge/notebook/markdown/贪心.md) · [BFS大融合.md](java/src/knowledge/notebook/markdown/BFS大融合.md) · [最短路：从松弛到状态图](java/src/knowledge/datastructure/graph/shortestpath/README.md)
* [字符串动态规划系统化题解与分析报告.md](java/src/knowledge/notebook/markdown/字符串动态规划系统化题解与分析报告.md) · [01背包深度解析.md](java/src/knowledge/notebook/markdown/01背包深度解析.md) · [堆与有序多重集深度解析.md](java/src/knowledge/notebook/markdown/堆_对顶堆与有序多重集_深度解析.md)

思维导图入口：[`知识大纲.xmind`](java/src/knowledge/notebook/xmind/知识大纲.xmind) · [`动态规划.xmind`](java/src/knowledge/notebook/xmind/动态规划.xmind) · [`滑动窗口.xmind`](java/src/knowledge/notebook/xmind/滑动窗口.xmind) · [`回溯.xmind`](java/src/knowledge/notebook/xmind/回溯.xmind) · [`树.xmind`](java/src/knowledge/notebook/xmind/树.xmind) · [`图.xmind`](java/src/knowledge/notebook/xmind/图.xmind) · [`数学.xmind`](java/src/knowledge/notebook/xmind/数学.xmind)

---

> 📌 **规范**：所有模板遵循 ACM 极简风格（信任调用者输入，不加防御性校验），统一 `@author wujingxinit@outlook.com` 头部与 `@see` 题号索引。
