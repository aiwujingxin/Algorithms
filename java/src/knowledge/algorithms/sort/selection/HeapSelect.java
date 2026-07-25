package knowledge.algorithms.sort.selection;

import knowledge.datastructure.heap.TopKHeap;

import java.util.Comparator;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 */
public class HeapSelect implements TopK {

    @Override
    public int findKthLargest(int[] nums, int k) {
        TopKHeap<Integer> topK = new TopKHeap<>(k, Comparator.naturalOrder());
        for (int num : nums) topK.offer(num);
        return topK.getKth();
    }
}
