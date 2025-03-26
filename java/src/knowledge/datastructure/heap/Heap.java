package knowledge.datastructure.heap;

import knowledge.datastructure.graph.mst.MinSpanningTree;
import knowledge.datastructure.graph.shortestpath.ShortestPath;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/26 23:16
 * @description 优先队列 PriorityQueue
 * <解决问题>
 * 最（K）小（大）值查找：通过使用最小（大）优先队列，可以快速找到一组元素中的最小（大）值。这在一些排序问题中非常有用，例如找到数组中的最小（大）k个元素。
 * 任务调度：在任务调度问题中，任务具有不同的优先级和执行时间。通过使用优先队列，可以按照优先级调度任务，确保高优先级的任务先执行。
 * 图算法：在一些图算法中，如最短路径算法（Dijkstra算法）、最小生成树算法（Prim算法、Kruskal算法）等，优先队列可以用来选择下一个要处理的顶点或边。
 * 哈夫曼编码：哈夫曼编码是一种用于数据压缩的技术。在哈夫曼编码中，通过使用优先队列来构建最优的编码树，以便实现高效的数据压缩。
 * 搜索算法：在一些搜索算法中，如A*算法，优先队列可以用来选择下一个要扩展的节点，以便找到最优解。
 * <排序问题>
 * @see knowledge.algorithms.sort.HeapSort
 * @see knowledge.algorithms.sort.TopK
 * @see leetcode.problems.LeetCode4
 * @see leetcode.problems.LeetCode239
 * @see leetcode.problems.LeetCode373
 * @see leetcode.problems.LeetCode378
 * @see leetcode.problems.LeetCode786
 * @see leetcode.problems.LeetCode355
 * @see leetcode.problems.LeetCode347
 * @see leetcode.problems.LeetCode692
 * <任务调度>
 * @see leetcode.problems.LeetCode253
 * <图问题>
 * @see ShortestPath
 * @see MinSpanningTree
 */
public interface Heap {

    default int findKthLargest(int[] nums, int k) {
        MaxHeap<Integer> pq = new MaxHeap<>(nums.length + 1);
        for (int j : nums) {
            pq.push(j);
            if (pq.size() > k) {
                pq.pop();
            }
        }
        return pq.peek();
    }
}
