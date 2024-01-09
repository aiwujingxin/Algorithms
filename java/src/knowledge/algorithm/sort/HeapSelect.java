package knowledge.algorithm.sort;

import knowledge.datastructure.heap.MaxHeap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/9 14:43
 */
public class HeapSelect implements TopK {

    @Override
    public int findKthLargest(int[] nums, int k) {
        MaxHeap<Integer> pq = new MaxHeap<>(nums.length + 1);
        for (int j : nums) {
            pq.insert(j);
            if (pq.size() > k) {
                pq.delMax();
            }
        }
        return pq.Max();
    }

    @Override
    public int findKthSmallest(int[] nums, int k) {
        return 0;
    }
}
