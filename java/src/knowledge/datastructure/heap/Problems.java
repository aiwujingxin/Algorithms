package knowledge.datastructure.heap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/26 23:16
 * @description 优先队列 PriorityQueue
 * @see leetcode.problems.LeetCode4
 * @see leetcode.problems.LeetCode239
 * @see leetcode.problems.LeetCode253
 * <p>
 * 多路排序
 * @see leetcode.problems.LeetCode373
 * @see leetcode.problems.LeetCode378
 * @see leetcode.problems.LeetCode786
 * @see leetcode.problems.LeetCode355
 * <p>
 * 最短路
 * @see knowledge.graph.shortestpath.Dijkstra
 */
public interface Problems {

    default int findKthLargest(int[] nums, int k) {
        MaxHeap<Integer> pq = new MaxHeap<>(nums.length + 1);
        for (int j : nums) {
            pq.insert(j);
            if (pq.size() > k) {
                pq.delMax();
            }
        }
        return pq.Max();
    }
}
