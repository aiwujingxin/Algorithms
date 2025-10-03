package knowledge.datastructure.heap;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 9/10/25 13:44
 * @description 延迟删除优先队列 支持O(1)获取最小/最大值，O(log n)插入，O(1)懒删除
 */
public class LazyDualHeap<E> implements DualHeap<E> {
    private final PriorityQueue<E> heap; // 主堆
    private final Map<E, Integer> pendingRemovals; // 待删除元素计数

    // 构造方法
    public LazyDualHeap() {
        this.heap = new PriorityQueue<>();
        this.pendingRemovals = new HashMap<>();
    }

    public LazyDualHeap(Comparator<? super E> comparator) {
        this.heap = new PriorityQueue<>(comparator);
        this.pendingRemovals = new HashMap<>();
    }

    public LazyDualHeap(Collection<? extends E> c) {
        this.heap = new PriorityQueue<>(c);
        this.pendingRemovals = new HashMap<>();
    }

    // 添加元素
    @Override
    public void add(E e) {
        heap.add(e);
    }

    // 懒删除：标记元素为待删除，实际删除延迟到下次访问时
    @Override
    public void remove(E element) {
        if (!heap.contains(element)) {
            return;
        }
        pendingRemovals.put(element, pendingRemovals.getOrDefault(element, 0) + 1);
    }

    // 获取最小/最大元素（清理待删除元素后）
    public E peek() {
        clean();
        return heap.peek();
    }

    // 删除并返回最小/最大元素
    public E poll() {
        clean();
        return heap.poll();
    }

    // 清理堆顶的待删除元素
    private void clean() {
        while (!heap.isEmpty() && pendingRemovals.containsKey(heap.peek())) {
            E top = heap.peek();
            int count = pendingRemovals.get(top);
            if (count == 1) {
                pendingRemovals.remove(top);
            } else {
                pendingRemovals.put(top, count - 1);
            }
            heap.poll(); // 实际删除
        }
    }

    // 获取实际大小（不包含待删除元素）
    @Override
    public int size() {
        clean();
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        clean();
        return heap.isEmpty();
    }

    @Override
    public void clear() {
        heap.clear();
        pendingRemovals.clear();
    }

    // 检查是否包含元素（考虑待删除状态）
    public boolean contains(Object o) {
        if (pendingRemovals.containsKey(o)) {
            return false; // 已被标记删除
        }
        return heap.contains(o);
    }

    // 获取堆的大小（包含待删除元素）
    public int totalSize() {
        return heap.size();
    }

    // 获取待删除元素数量
    public int pendingSize() {
        return pendingRemovals.values().stream().mapToInt(Integer::intValue).sum();
    }

    // 可选：提供 offer 方法（不是 Heap 接口要求）
    public boolean offer(E e) {
        return heap.offer(e);
    }
}