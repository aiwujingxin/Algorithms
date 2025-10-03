package knowledge.datastructure.other.impl;

import knowledge.datastructure.other.MinMaxContainer;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 8/20/25 10:58
 */
class HeapMinMax implements MinMaxContainer {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private Map<Integer, Integer> freq = new HashMap<>(); // 当前窗口内各值出现次数
    private int size = 0; // 窗口内有效元素个数

    public void insert(int x) {
        minHeap.offer(x);
        maxHeap.offer(x);
        freq.put(x, freq.getOrDefault(x, 0) + 1);
        size++;
    }

    public void remove(int x) {
        // 这里假定 x 一定在窗口里（典型滑动窗口用法）
        int c = freq.getOrDefault(x, 0);
        if (c <= 0)
            return; // 防御
        if (c == 1)
            freq.remove(x);
        else
            freq.put(x, c - 1);
        size--;
        // 不在这里清堆；等到 getMin/getMax 再按需清理堆顶
    }

    public int getMin() {
        clean(minHeap);
        return minHeap.peek();
    }

    public int getMax() {
        clean(maxHeap);
        return maxHeap.peek();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void clean(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int v = heap.peek();
            if (freq.getOrDefault(v, 0) == 0)
                heap.poll(); // 堆顶已过期，弹掉
            else
                break; // 堆顶是有效值
        }
    }
}
