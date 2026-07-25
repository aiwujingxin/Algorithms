package knowledge.datastructure.heap;

import leetcode.problems.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @description 对顶堆模板：用大根堆 small 与小根堆 large 维护有序的两部分。
 * <不变量>
 * - 顺序：small 中任意有效元素不大于 large 中任意有效元素。
 * - 大小：由子类的 {@link #makeBalance()} 定义,例如两边均分或 small 固定保留 k 个。
 * - 删除：{@link LazyHeap} 先标记、后清理堆顶,将任意删除的均摊复杂度降为 O(log n)。
 * <复杂度>
 * 添加、删除和重平衡均为 O(log n),查看中位数或第 k 小为 O(1),空间 O(n)。
 * <懒删除 vs 有序集合(TreeMap)>
 * 本类用「懒删除」支持任意删除:remove 只在 {@link LazyHeap} 里打标记,待目标浮到堆顶才真正弹出,
 * 均摊 O(log n),代价是堆内会滞留失效元素(靠独立计数保证 size 准确)。
 * 等价能力也可用有序多重集实现,取舍如下:
 * - 删除:对顶堆懒删除(标记 + 延迟清理) ↔ {@link knowledge.datastructure.other.impl.TreeMultiset} 实时删除(按 key 定位,无滞留)。
 * - 能力:堆每端只暴露一个极值,取中位数须两个堆对顶;TreeMap 两端与邻近查询(floor/ceiling)皆 O(log n)。
 * - 常数:堆基于数组、常数小、缓存友好;红黑树常数偏大但功能更全。
 * - 选择:只需一端极值 → 堆;需双端 / 邻近查询 / 频繁任意删除 → 有序集合。
 * <力扣题型>
 * @see MidDualHeap       中位数模板(数据流 / 滑动窗口)
 * @see KthDualHeap       滑动窗口第 k 小模板
 * @see TopKHeap          无删除的动态第 k 大,单堆更简单
 * @see knowledge.datastructure.other.impl.TreeMultiset  有序多重集(TreeMap)——懒删除的实时删除替代方案
 * @see LeetCode4    [H] 寻找两个正序数组的中位数
 * @see LeetCode295  [H] 数据流的中位数 (对顶堆均分)
 * @see LeetCode480_dualheap [H] 滑动窗口中位数 (对顶堆 + 延迟删除)
 * @see LeetCode2653 [M] 滑动子数组的美丽值 (滑动窗口第 k 小)
 * @see LeetCode703  [E] 数据流中的第 K 大元素 (无删除,单堆即可)
 * @see LeetCode3321 [H] 计算子数组的 x-sum II (分区统计扩展)
 */
public abstract class AbstractDualHeap<T extends Comparable<? super T>> {

    protected final LazyHeap<T> small = new LazyHeap<>((a, b) -> b.compareTo(a)); // 大根堆：较小的一半
    protected final LazyHeap<T> large = new LazyHeap<>((a, b) -> a.compareTo(b)); // 小根堆：较大的一半

    public void add(T element) {
        if (small.isEmpty() || element.compareTo(small.peek()) <= 0) {
            small.push(element);
        } else {
            large.push(element);
        }
        makeBalance();
    }

    public boolean remove(T element) {
        boolean removed;
        if (!small.isEmpty() && element.compareTo(small.peek()) <= 0) {
            removed = small.remove(element);
        } else {
            removed = large.remove(element);
        }
        if (removed) makeBalance();
        return removed;
    }

    public int size() {
        return small.size() + large.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        small.clear();
        large.clear();
    }

    // 平衡两堆大小，由子类定义具体规则
    protected abstract void makeBalance();

    /**
     * 支持延迟删除的堆：remove 只做标记，待目标浮到堆顶时才真正弹出，
     * 从而以 O(logn) 均摊代价支持删除任意元素。size 始终反映有效元素数。
     */
    public static class LazyHeap<E> {

        private final PriorityQueue<E> pq;
        private final Map<E, Integer> delayed = new HashMap<>(); // 待删除元素 -> 次数
        private final Map<E, Integer> frequency = new HashMap<>(); // 有效元素 -> 次数
        private int size;

        public LazyHeap(Comparator<E> comparator) {
            this.pq = new PriorityQueue<>(comparator);
        }

        public void push(E e) {
            pq.offer(e);
            frequency.merge(e, 1, Integer::sum);
            size++;
        }

        public boolean remove(E e) {
            Integer count = frequency.get(e);
            if (count == null) return false;
            decrease(frequency, e, count);
            delayed.merge(e, 1, Integer::sum);
            size--;
            clean();
            return true;
        }

        public E peek() {
            clean();
            return pq.peek();
        }

        public E pop() {
            clean();
            if (pq.isEmpty()) return null;
            E top = pq.poll();
            decrease(frequency, top, frequency.get(top));
            size--;
            return top;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void clear() {
            pq.clear();
            delayed.clear();
            frequency.clear();
            size = 0;
        }

        // 清除堆顶已被标记删除的元素
        private void clean() {
            while (!pq.isEmpty() && delayed.containsKey(pq.peek())) {
                E top = pq.poll();
                if (delayed.merge(top, -1, Integer::sum) == 0) {
                    delayed.remove(top);
                }
            }
        }

        private void decrease(Map<E, Integer> counts, E element, int count) {
            if (count == 1) {
                counts.remove(element);
            } else {
                counts.put(element, count - 1);
            }
        }
    }
}
