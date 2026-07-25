package knowledge.datastructure.heap;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author wujingxinit@outlook.com
 * @description 固定容量 Top K 模板。
 * <思路>
 * {@code ranking} 定义“更优”的方向：当 {@code ranking.compare(a, b) > 0} 时,
 * a 比 b 更应被保留。内部堆顶始终是已保留元素中最差的一个,故新元素只需与堆顶比较。
 * <用法>
 * <pre>{@code
 * // 保留最大的 3 个数，getKth() 返回第 3 大
 * TopKHeap<Integer> largest = new TopKHeap<>(3, Comparator.naturalOrder());
 *
 * // 保留最小的 3 个数，getKth() 返回第 3 小
 * TopKHeap<Integer> smallest = new TopKHeap<>(3, Comparator.reverseOrder());
 * }</pre>
 * <复杂度>
 * 每次加入 O(log k),空间 O(k)。适用于第 K 大、Top K 高频元素、数据流第 K 大等问题。
 * @see BinaryHeap        底层通用二叉堆
 * @see leetcode.problems.LeetCode215  [M] 数组中的第 K 个最大元素
 * @see leetcode.problems.LeetCode347  [M] 前 K 个高频元素
 * @see leetcode.problems.LeetCode692  [M] 前 K 个高频单词
 * @see leetcode.problems.LeetCode703  [E] 数据流中的第 K 大元素
 * @see leetcode.problems.LeetCode973  [M] 最接近原点的 K 个点
 * @see knowledge.algorithms.sort.HeapSelect  基于堆的第 K 大选择
 */
public class TopKHeap<E> {

    private final int k;
    private final Comparator<? super E> ranking;
    private final BinaryHeap<E> heap;

    public TopKHeap(int k, Comparator<? super E> ranking) {
        if (k <= 0) {
            throw new IllegalArgumentException("k must be > 0");
        }
        this.k = k;
        this.ranking = Objects.requireNonNull(ranking);
        this.heap = new BinaryHeap<>(k, ranking);
    }

    /**
     * 尝试加入元素。
     *
     * @return 元素进入 Top K 返回 true；被过滤返回 false
     */
    public boolean offer(E element) {
        Objects.requireNonNull(element);
        if (heap.size() < k) {
            heap.push(element);
            return true;
        }
        if (ranking.compare(element, heap.peek()) <= 0) {
            return false;
        }
        heap.pop();
        heap.push(element);
        return true;
    }

    /**
     * 返回当前第 k 优元素。
     *
     * @throws IllegalStateException 有效元素不足 k 个
     */
    public E getKth() {
        if (!isFull()) {
            throw new IllegalStateException("有效元素不足 " + k + " 个");
        }
        return heap.peek();
    }

    public int size() {
        return heap.size();
    }

    public boolean isFull() {
        return size() == k;
    }

    public void clear() {
        heap.clear();
    }
}
