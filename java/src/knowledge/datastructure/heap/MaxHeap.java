package knowledge.datastructure.heap;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author wujingxinit@outlook.com
 * @description MaxHeap 最大堆（数组实现，1-indexed，自动扩容）。
 * 完全二叉树存于 pq[1..n]，pq[0] 空置：结点 k 的父为 k/2，左右子为 2k、2k+1。
 * 用于教学理解上浮/下沉；生产场景优先用比较器可控方向的 {@link BinaryHeap}。
 * @see BinaryHeap        比较器控制方向的通用二叉堆
 */
public class MaxHeap<E extends Comparable<? super E>> implements Heap<E> {

    private E[] pq;
    private int n;

    @SuppressWarnings("unchecked")
    public MaxHeap(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must be >= 0");
        }
        pq = (E[]) new Comparable[capacity + 1];
    }

    // 插入元素并上浮
    @Override
    public void push(E v) {
        Objects.requireNonNull(v);
        if (n + 1 == pq.length) {
            pq = Arrays.copyOf(pq, pq.length * 2);
        }
        pq[++n] = v;
        up(n);
    }

    // 返回堆顶（最大值），空堆返回 null
    @Override
    public E peek() {
        return n == 0 ? null : pq[1];
    }

    // 删除并返回堆顶
    @Override
    public E pop() {
        if (n == 0) return null;
        E max = pq[1];
        swap(1, n--);
        pq[n + 1] = null; // 防止对象游离
        down(1);
        return max;
    }

    // 按值删除首次出现的元素
    public boolean remove(E target) {
        if (target == null) return false;
        for (int i = 1; i <= n; i++) {
            if (target.equals(pq[i])) {
                swap(i, n--);
                pq[n + 1] = null;
                if (i <= n) { // 被换上来的元素可能需要上浮或下沉
                    up(i);
                    down(i);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(pq, 1, n + 1, null);
        n = 0;
    }

    // 上浮：比父结点大则交换
    private void up(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k /= 2;
        }
    }

    // 下沉：与较大的子结点比较，比子小则交换
    private void down(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            swap(k, j);
            k = j;
        }
    }

    // pq[i] < pq[j]
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void swap(int i, int j) {
        E t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
