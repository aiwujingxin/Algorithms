package knowledge.algorithms.sort;

import knowledge.datastructure.heap.TopKHeap;

import java.util.Comparator;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/9 21:07
 */
public class HeapSelect implements TopK {

    @Override
    public int findKthLargest(int[] nums, int k) {
        TopKHeap<Integer> topK = new TopKHeap<>(k, Comparator.naturalOrder());
        for (int num : nums) {
            topK.offer(num);
        }
        return topK.getKth();
    }
}
