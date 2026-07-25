package knowledge.datastructure.heap;

/**
 * @author wujingxinit@outlook.com
 * @description 对顶堆求中位数（支持延迟删除，适用于滑动窗口）。
 * small（大根堆）存较小一半，large（小根堆）存较大一半，始终保持
 * small.size() == large.size() 或 small.size() == large.size() + 1，
 * 故 small 堆顶即为下中位数。
 * @see AbstractDualHeap  对顶堆基类(延迟删除)
 * @see leetcode.problems.LeetCode295  [H] 数据流的中位数
 * @see leetcode.problems.LeetCode480_dualheap  [H] 滑动窗口中位数
 */
public class MidDualHeap<T extends Number & Comparable<? super T>> extends AbstractDualHeap<T> {

    @Override
    protected void makeBalance() {
        while (small.size() > large.size() + 1) {
            large.push(small.pop());
        }
        while (small.size() < large.size()) {
            small.push(large.pop());
        }
    }

    // 元素个数为奇数取 small 堆顶，偶数取两堆顶平均
    public double getMedian() {
        if (isEmpty()) return -1;
        if (size() % 2 == 1) {
            return small.peek().doubleValue();
        }
        return (small.peek().doubleValue() + large.peek().doubleValue()) / 2.0;
    }
}
