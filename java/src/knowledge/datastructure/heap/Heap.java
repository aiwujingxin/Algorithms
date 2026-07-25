package knowledge.datastructure.heap;

import knowledge.algorithms.greedy.Greedy;
import knowledge.algorithms.sort.comparison.HeapSort;
import knowledge.algorithms.sort.selection.HeapSelect;
import knowledge.algorithms.sort.selection.TopK;
import knowledge.datastructure.graph.mst.impl.Prim;
import knowledge.datastructure.graph.shortestpath.impl.Dijkstra;
import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/25 12:00
 * @description 堆 / 优先队列精选题单(导航索引)
 * <解题识别>
 * 出现以下信号优先考虑堆:动态维护「最值/第 K 值」、多路有序流合并、按优先级反复取用与淘汰。
 * 1. 只关心极值而非全序:用堆以 O(log n) 增删,避免每次 O(n log n) 重排。
 * 2. 需要「第 K 大/小」:固定容量堆(大小 k),堆顶即答案。
 * 3. 需要「动态中位数/顺序统计」:对顶堆(两个堆共同维护分界)。
 * <核心性质>
 * - 结构:完全二叉树,只保证父子有序,不保证全局有序(故遍历非有序输出)。
 * - 复杂度:建堆 O(n)、插入/弹顶 O(log n)、看顶 O(1)、查找或删任意元素 O(n)。
 * - 方向:小顶堆(自然序)堆顶最小;大顶堆(逆序)堆顶最大。取「第 K 大」用小顶堆存 k 个,反之亦然。
 * - 局限:不支持高效随机删除,滑动窗口场景需配合「延迟删除」(见 AbstractDualHeap)。
 * <模板选择决策表>
 * @see BinaryHeap        通用最值，比较器控制方向（小顶 / 大顶一套代码切换）
 * @see MaxHeap           教学：理解上浮 / 下沉（手写 1-indexed 最大堆）
 * @see TopKHeap          只保留最优 k 个，求第 K 值（定容堆，堆顶即第 K 值）
 * @see AbstractDualHeap  动态中位数 / 第 K 小，支持删除（对顶堆 + 延迟删除）
 * @see knowledge.datastructure.other.impl.TreeMultiset  需双端极值 / 邻近查询 / 频繁任意删除（有序多重集，TreeMap）
 * (难度标记: E=Easy  M=Medium  H=Hard)
 * <I. Top K>
 * 策略:维护一个大小为 k 的堆。求「第 K 大」用小顶堆,堆满后新元素只有大于堆顶才替换,最终堆顶即第 K 大。
 * 本质:用一个反向的定容堆过滤掉 n-k 个无关元素,把全排序 O(n log n) 降为 O(n log k)。
 * 复杂度:O(n log k),空间 O(k)。
 * @see LeetCode215  [M] 数组中的第 K 个最大元素 (小顶堆存 k 个)
 * @see LeetCode347  [M] 前 K 个高频元素 (堆按频次)
 * @see LeetCode692  [M] 前 K 个高频单词 (频次 + 字典序双关键字)
 * @see LeetCode703  [E] 数据流中的第 K 大元素 (定容小顶堆在线维护)
 * @see LeetCode973  [M] 最接近原点的 K 个点 (大顶堆按距离,超容弹顶)
 * <II. 滑动窗口>
 * 策略:窗口右移时入堆,取堆顶前先判断是否已滑出窗口(存下标或延迟删除),过期则弹出。
 * 本质:堆无法直接删中间元素,故「懒删除」——让过期元素滞留,仅在其浮到堆顶时清理。
 * 复杂度:每元素至多入堆/出堆一次,均摊 O(log n)。
 * @see LeetCode239  [H] 滑动窗口最大值 (大顶堆存 [值,下标],顶部过期才弹)
 * @see LeetCode480_dualheap [H] 滑动窗口中位数 (对顶堆 + 延迟删除)
 * <III. K 路归并>
 * 策略:将 k 个有序序列的头部入堆,每次弹出最小并推入其后继,重复直至取够。
 * 本质:堆始终握有「所有活跃序列的当前最小者」,实现多路有序流的按序合并。
 * 复杂度:取 m 个元素为 O(m log k)。
 * @see LeetCode23   [H] 合并 K 个升序链表 (k 个链表头入堆)
 * @see LeetCode373  [M] 查找和最小的 K 对数字 (堆按对和,弹一入一)
 * @see LeetCode378  [M] 有序矩阵中第 K 小的元素 (行头入堆 / 二分)
 * @see LeetCode632  [H] 最小区间 (k 个列表指针,堆维护当前最小,同步最大)
 * @see LeetCode786  [M] 第 K 个最小的素数分数 (多路排序,堆按分数)
 * <IV. 区间与资源调度>
 * 策略:按开始时间排序,用小顶堆维护「各资源的释放/结束时刻」,新任务复用最早空闲的资源。
 * 本质:堆顶是最早可用资源,贪心复用以最小化资源数量(EDF / 会议室模型)。
 * 复杂度:O(n log n)。
 * @see LeetCode253  [M] 会议室 II (堆维护结束时间,顶部先释放则复用)
 * @see LeetCode621  [M] 任务调度器 (大顶堆按剩余频次,轮转冷却)
 * @see LeetCode630  [H] 课程表 III (反悔贪心:超时弹出耗时最长课程,见 Greedy VI)
 * @see LeetCode1845 [M] 座位预约管理系统 (小顶堆维护可用座位号)
 * @see LeetCode1942 [M] 最小未被占据椅子的编号 (空闲椅堆 + 离场事件堆)
 * <V. 贪心选择>
 * 策略:每步用堆取当前最值做决策;约束冲突时,从已选集合中弹出「最差」元素反悔替换。
 * 本质:堆把「动态取极值」降到 O(log n),是反悔贪心(时光倒流)的核心数据结构。
 * @see Greedy            贪心专题(反悔贪心详见其 VI 章节)
 * @see LeetCode502  [H] IPO (资本门槛:大顶堆取当前可解锁的最大利润)
 * @see LeetCode1962 [M] 移除石子使总数最小 (大顶堆每次砍最大堆减半)
 * @see LeetCode2233 [M] K 次增加后的最大乘积 (小顶堆每次给最小值 +1)
 * @see LeetCode2462 [M] 雇佣 K 位工人的总代价 (双指针 + 双堆取最小代价)
 * <VI. 图搜索>
 * 策略:小顶堆按「当前代价」出队,松弛邻边并入堆;瓶颈类问题把累加改为取路径最大边。
 * 本质:堆保证每次扩展的都是全局最小代价节点,支撑 Dijkstra 及其瓶颈式变形。
 * 差异:松弛式 dist=min(dist, d+w) ↔ 瓶颈式 dist=min(dist, max(d,w))。
 * @see Dijkstra          单源最短路(松弛 + 小顶堆)
 * @see Prim              最小生成树(点扩展 + 小顶堆)
 * @see LeetCode407  [H] 接雨水 II (最低围墙优先,木桶效应)
 * @see LeetCode778  [H] 水位上升的泳池中游泳 (路径瓶颈最小化)
 * @see LeetCode787  [M] K 站中转内最便宜的航班 (带层数限制的最短路)
 * @see LeetCode1631 [M] 最小体力消耗路径 (最小化路径最大边)
 * @see LeetCode2290 [H] 到达角落需移除障碍物的最小数目 (0-1 边权,堆/双端队列)
 * <VII. 模拟>
 * 策略:把带优先级的元素放入堆,反复取堆顶处理,处理后可能产生新元素再入堆。
 * 本质:堆作为优先级队列,天然表达「谁最紧急/最优先谁先出」的调度语义。
 * @see LeetCode355  [M] 设计推特 (多用户时间线多路归并)
 * @see LeetCode767  [M] 重构字符串 (大顶堆按剩余频次,隔板法)
 * @see LeetCode1405 [M] 最长快乐字符串 (大顶堆取剩余最多且不违规的字符)
 * @see LeetCode2182 [M] 构造限制重复的字符串 (大顶堆按字符大小)
 * <VIII. 对顶堆>
 * 策略:大顶堆存较小一半、小顶堆存较大一半,通过再平衡让分界(堆顶)恰为中位数或第 K 小。
 * 本质:两个堆把「动态顺序统计」拆成两侧极值查询;配合延迟删除即可支持滑动窗口。
 * 替代:需双端极值 / 邻近查询 / 无滞留的实时删除时,可换用有序多重集(TreeMap)——见 TreeMultiset。
 * @see AbstractDualHeap  对顶堆模板(中位数 / 第 K 小 / 延迟删除)
 * @see knowledge.datastructure.other.impl.TreeMultiset  有序多重集(TreeMap)——懒删除的实时删除替代方案
 * <相关工具>
 * @see HeapSort          堆排序
 * @see HeapSelect        基于堆的第 K 大选择
 * @see TopK              第 K 大选择接口
 */
public interface Heap<E> {

    void push(E element);

    E peek();

    E pop();

    int size();

    void clear();

    default boolean isEmpty() {
        return size() == 0;
    }
}
