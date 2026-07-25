package knowledge.datastructure.other.impl;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @description 有序多重集模板（TreeMap 计数法）——对顶堆 + 懒删除的“有序集合”替代方案。
 * <定位>
 * 真正的 O(log n) 任意删除,是滑动窗口最值 / 中位数的另一主流写法。
 * <对比：对顶堆(懒删除) vs 本类(TreeMap)>
 * - 删除：对顶堆是「懒删除」(先标记,浮到堆顶才真正弹出,均摊 O(log n)),
 * TreeMap 是「实时删除」(按 key 定位,最坏也 O(log n)),无滞留元素、size 恒准。
 * - 能力：堆只暴露一端极值,取中位数需两个堆对顶;TreeMap 两端 {@link #first()}/{@link #last()}
 * 均可 O(log n) 访问,还支持 {@code floor/ceiling} 等邻近查询,单结构即可。
 * - 常数：堆基于数组、常数更小、缓存友好;TreeMap 为红黑树、常数偏大但功能更全。
 * - 选择：只需一端极值且删除集中在堆顶 → 用堆;需要双端 / 邻近查询 / 频繁任意删除 → 用本类。
 * @see knowledge.datastructure.heap.AbstractDualHeap  对顶堆 + 懒删除(数组实现,常数小)
 * @see TreeMapMinMax  int 特化的最值容器
 * @see leetcode.problems.LeetCode220  [H] 存在重复元素 III (滑动窗口 + 邻近查询)
 * @see leetcode.problems.LeetCode480  [H] 滑动窗口中位数 (TreeSet 对顶写法)
 * @see leetcode.problems.LeetCode1438 [M] 绝对差不超过限制的最长连续子数组 (窗口最值)
 */
public class TreeMultiset<E> {

    private final NavigableMap<E, Integer> counts;
    private int size;

    public TreeMultiset() {
        this.counts = new TreeMap<>();
    }

    public TreeMultiset(Comparator<? super E> comparator) {
        this.counts = new TreeMap<>(Objects.requireNonNull(comparator));
    }

    public void add(E element) {
        Objects.requireNonNull(element);
        counts.merge(element, 1, Integer::sum);
        size++;
    }

    /**
     * 删除一个 element；不存在返回 false。
     */
    public boolean remove(E element) {
        Integer count = counts.get(element);
        if (count == null) return false;
        if (count == 1) {
            counts.remove(element);
        } else {
            counts.put(element, count - 1);
        }
        size--;
        return true;
    }

    public boolean contains(E element) {
        return counts.containsKey(element);
    }

    /**
     * 最小元素，空集返回 null。
     */
    public E first() {
        return counts.isEmpty() ? null : counts.firstKey();
    }

    /**
     * 最大元素，空集返回 null。
     */
    public E last() {
        return counts.isEmpty() ? null : counts.lastKey();
    }

    /**
     * 小于等于 element 的最大元素，不存在返回 null。
     */
    public E floor(E element) {
        return counts.floorKey(element);
    }

    /**
     * 大于等于 element 的最小元素，不存在返回 null。
     */
    public E ceiling(E element) {
        return counts.ceilingKey(element);
    }

    /**
     * 元素总数（计入重复）。
     */
    public int size() {
        return size;
    }

    /**
     * 去重后的元素种类数。
     */
    public int distinctSize() {
        return counts.size();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        counts.clear();
        size = 0;
    }

    /**
     * 某元素的出现次数。
     */
    public int count(E element) {
        return counts.getOrDefault(element, 0);
    }

    /**
     * 弹出并返回最小元素，空集返回 null。
     */
    public E pollFirst() {
        return poll(counts.firstEntry());
    }

    /**
     * 弹出并返回最大元素，空集返回 null。
     */
    public E pollLast() {
        return poll(counts.lastEntry());
    }

    private E poll(Map.Entry<E, Integer> entry) {
        if (entry == null) return null;
        E key = entry.getKey();
        remove(key);
        return key;
    }
}
