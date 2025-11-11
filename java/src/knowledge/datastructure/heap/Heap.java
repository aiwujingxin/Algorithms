package knowledge.datastructure.heap;

import knowledge.algorithms.greedy.Greedy;
import knowledge.algorithms.sort.HeapSelect;
import knowledge.algorithms.sort.HeapSort;
import knowledge.algorithms.sort.TopK;
import knowledge.datastructure.graph.mst.impl.Prim;
import knowledge.datastructure.graph.shortestpath.impl.Dijkstra;
import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 11/5/25 04:49
 * @description 优先队列优先队列
 * <解决问题>
 * 最值查找：通过使用最小（大）优先队列，可以快速找到一组元素中的最小（大）值。
 * 搜索算法：在一些搜索算法中，如A*算法，优先队列可以用来选择下一个要扩展的节点，以便找到最优解。
 * 任务调度：按照优先级调度任务，确保高优先级的任务先执行。
 * 图算法：最短路径算法（Dijkstra算法）、最小生成树算法（Prim算法、Kruskal算法）
 * 哈夫曼编码：在哈夫曼编码中，通过使用优先队列来构建最优的编码树，以便实现高效的数据压缩。
 * <基础>
 * @see HeapSort
 * @see HeapSelect
 * @see TopK
 * <排序>
 * @see LeetCode239
 * @see LeetCode373
 * @see LeetCode378
 * @see LeetCode786
 * @see LeetCode355
 * @see LeetCode347
 * @see LeetCode692
 * <任务调度>
 * @see LeetCode253
 * <贪心>
 * @see Greedy
 * @see Dijkstra
 * @see Prim
 * <对顶堆>
 * @see DualHeap
 */
public interface Heap {
}
