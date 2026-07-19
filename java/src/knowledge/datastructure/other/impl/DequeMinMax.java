package knowledge.datastructure.other.impl;

import knowledge.datastructure.other.MinMaxContainer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wujingxinit@outlook.com
 * @date 8/20/25 10:58
 */

public class DequeMinMax implements MinMaxContainer {
    // 替换为 ArrayDeque，CPU 缓存友好，无节点分配开销
    private final Deque<Integer> max = new ArrayDeque<>();
    private final Deque<Integer> min = new ArrayDeque<>();

    public void insert(int x) {
        while (!max.isEmpty() && x >= max.peekLast()) {
            max.pollLast();
        }
        max.addLast(x);
        while (!min.isEmpty() && x <= min.peekLast()) {
            min.pollLast();
        }
        min.addLast(x);
    }

    public void remove(int x) {
        if (!max.isEmpty() && x > max.peekFirst()) max.pollFirst();
        if (!min.isEmpty() && x < min.peekFirst()) min.pollFirst();
    }

    public int getMin() {
        return min.peekFirst();
    }

    public int getMax() {
        return max.peekFirst();
    }

    public boolean isEmpty() {
        return max.isEmpty();
    }
}
