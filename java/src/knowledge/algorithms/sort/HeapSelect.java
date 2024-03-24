package knowledge.algorithms.sort;

import knowledge.datastructure.heap.MaxHeap;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/9 21:07
 */
public class HeapSelect implements TopK {

    @Override
    public int findKthLargest(int[] nums, int k) {
        MaxHeap<Integer> pq = new MaxHeap<>(nums.length + 1);
        for (int num : nums) {
            pq.push(num);
            if (pq.size() > k) {
                pq.pop();
            }
        }
        return pq.peek();
    }
}