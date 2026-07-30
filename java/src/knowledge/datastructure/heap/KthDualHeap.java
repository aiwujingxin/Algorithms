package knowledge.datastructure.heap;

import leetcode.problems.LeetCode2653_heap;

/**
 * @author wujingxinit@outlook.com
 * @description 对顶堆求第 k 小元素（支持延迟删除）。
 * small（大根堆）恰好维护当前最小的 k 个元素，其堆顶即第 k 小。
 * @see AbstractDualHeap  对顶堆基类(延迟删除)
 * @see LeetCode2653_heap  [M] 滑动子数组的美丽值
 */
public class KthDualHeap<T extends Comparable<? super T>> extends AbstractDualHeap<T> {

    private final int k;

    public KthDualHeap(int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("k must be > 0");
        }
        this.k = k;
    }

    @Override
    protected void makeBalance() {
        while (small.size() > k) {
            large.push(small.pop());
        }
        while (small.size() < k && !large.isEmpty()) {
            small.push(large.pop());
        }
    }

    public T getKthSmallest() {
        if (small.size() < k) {
            throw new IllegalStateException("当前有效元素不足 " + k + " 个");
        }
        return small.peek();
    }
}
