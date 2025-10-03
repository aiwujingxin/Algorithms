package knowledge.datastructure.heap;

import knowledge.algorithms.sort.HeapSelect;
import knowledge.algorithms.sort.HeapSort;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/7/23 16:33
 * @description MaxHeap 最大堆
 * <a href="https://github.com/labuladong/fucking-algorithm/blob/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E7%B3%BB%E5%88%97/%E4%BA%8C%E5%8F%89%E5%A0%86%E8%AF%A6%E8%A7%A3%E5%AE%9E%E7%8E%B0%E4%BC%98%E5%85%88%E7%BA%A7%E9%98%9F%E5%88%97.md">...</a>
 * @see HeapSort
 * @see HeapSelect
 */
public class MaxHeap<E extends Comparable<E>> implements DualHeap<E> {

    private E[] pq;    // 基于堆的完全二叉树，1-indexed
    private int N = 0; // 存储于 pq[1 .. N] 中，pq[0] 没有使用

    @SuppressWarnings("unchecked")
    public MaxHeap(int capacity) { // 创建一个初始容量为 capacity 的优先队列
        pq = (E[]) new Comparable[capacity + 1];
    }

    // ========= Heap 接口适配 =========
    @Override
    public void add(E element) {
        push(element);
    }

    @Override
    public void remove(E element) {
        removeElement(element);
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public void clear() {
        // 将数组清空并重置计数
        Arrays.fill(pq, 1, N + 1, null);
        N = 0;
    }

    // ========= 原有 API（保留） =========

    // 插入一个元素
    public void push(E v) {
        ensureCapacity();
        pq[++N] = v;
        up(N);
    }

    // 集合中的最大值
    public E peek() {
        if (N == 0) return null;
        return pq[1];
    }

    // 删除并返回最大元素
    public E pop() {
        if (N == 0) return null;
        E max = pq[1];         // 从根结点得到最大元素
        swap(1, N--);          // 将其和最后一个结点交换
        pq[N + 1] = null;      // 防止对象游离
        down(1);               // 恢复堆的有序性
        return max;
    }

    // 删除任意一个元素（按值匹配，删除首次出现）
    public boolean removeElement(E target) {
        if (target == null || N == 0) return false;

        // 线性查找首次出现的位置（堆数组不是按序的）
        int idx = -1;
        for (int i = 1; i <= N; i++) {
            if (target.equals(pq[i])) {
                idx = i;
                break;
            }
        }
        if (idx == -1) return false;

        // 将待删除元素与最后一个元素交换，然后缩小堆
        swap(idx, N);
        pq[N] = null;
        N--;

        // 修复堆：由于替换位置元素可能比父大或比子小，需同时尝试 up/down
        if (idx <= N) {
            up(idx);
            down(idx);
        }
        return true;
    }

    // ========= 堆的内部实现 =========

    // 由下至上的堆有序化（上浮）
    private void up(int k) {
        while (k > 1 && less(parent(k), k)) {
            swap(parent(k), k);
            k = parent(k);
        }
    }

    // 由上至下的堆有序化（下沉）
    private void down(int k) {
        while (left(k) <= N) {
            int j = left(k);
            // 选择两个子结点中的较大者
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) break;
            swap(k, j);
            k = j;
        }
    }

    private void swap(int i, int j) {
        E t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    // 注意：less 应返回 i < j（比较值），用于最大堆判断
    // 原代码中：return pq[i].compareTo(pq[j]) >= 0; 是错误的
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private int parent(int k) {
        return k / 2;
    }

    private int left(int k) {
        return 2 * k;
    }

    private int right(int k) {
        return 2 * k + 1;
    }

    // 动态扩容（可选）
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (N + 1 == pq.length) {
            int newCap = pq.length * 2;
            E[] newArr = (E[]) new Comparable[newCap];
            System.arraycopy(pq, 0, newArr, 0, pq.length);
            pq = newArr;
        }
    }

    // ========== 示例算法：第 K 大元素 ==========
    // 注意：用最大堆求第 K 大应维护大小为 K 的最小堆更高效；
    // 但若坚持用 MaxHeap，这里给出一种做法：容量限制并按需 pop
    public int findKthLargest(int[] nums, int k) {
        MaxHeap<Integer> pq = new MaxHeap<>(Math.max(k, 16));
        for (int x : nums) {
            pq.push(x);
        }
        // 弹出前 k-1 个最大值，第 k 个即答案
        for (int i = 1; i < k; i++) {
            pq.pop();
        }
        return pq.peek();
    }
}
