package knowledge.datastructure.other.impl;

import knowledge.datastructure.other.MinMaxContainer;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 8/20/25 11:22
 */

public class DualHeapMinMax implements MinMaxContainer {
    // 小根堆 -> 取最小值
    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // 大根堆 -> 取最大值
    private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    // 分别给两个堆维护延迟删除表（因为同一个值在两个堆里都各有一份）
    private final Map<Integer, Integer> delayedMin = new HashMap<>();
    private final Map<Integer, Integer> delayedMax = new HashMap<>();

    // 有效元素个数
    private int size = 0;

    public void insert(int x) {
        minHeap.offer(x);
        maxHeap.offer(x);
        size++;
    }

    public void remove(int x) {
        if (size == 0) return; // 防御
        // 在两个堆里各标记一份删除
        delayedMin.put(x, delayedMin.getOrDefault(x, 0) + 1);
        delayedMax.put(x, delayedMax.getOrDefault(x, 0) + 1);
        size--;

        // 立刻清理堆顶可能命中的值，避免下次读到脏数据
        pruneMin();
        pruneMax();
    }

    public int getMin() {
        if (isEmpty()) throw new NoSuchElementException("Container is empty");
        pruneMin();
        return minHeap.peek();
    }

    public int getMax() {
        if (isEmpty()) throw new NoSuchElementException("Container is empty");
        pruneMax();
        return maxHeap.peek();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 清理 minHeap 堆顶的“幽灵元素”
    private void pruneMin() {
        while (!minHeap.isEmpty()) {
            int x = minHeap.peek();
            Integer cnt = delayedMin.get(x);
            if (cnt == null || cnt == 0) break;
            // 真正删除一份
            minHeap.poll();
            if (cnt == 1) delayedMin.remove(x);
            else delayedMin.put(x, cnt - 1);
        }
    }

    // 清理 maxHeap 堆顶的“幽灵元素”
    private void pruneMax() {
        while (!maxHeap.isEmpty()) {
            int x = maxHeap.peek();
            Integer cnt = delayedMax.get(x);
            if (cnt == null || cnt == 0) break;
            // 真正删除一份
            maxHeap.poll();
            if (cnt == 1) delayedMax.remove(x);
            else delayedMax.put(x, cnt - 1);
        }
    }
}
