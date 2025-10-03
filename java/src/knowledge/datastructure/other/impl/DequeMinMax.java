package knowledge.datastructure.other.impl;

import knowledge.datastructure.other.MinMaxContainer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wujingxinit@outlook.com
 * @date 8/20/25 10:58
 */

public class DequeMinMax implements MinMaxContainer {
    private Deque<Integer> maxDeque = new LinkedList<>();
    private Deque<Integer> minDeque = new LinkedList<>();

    public void insert(int x) {
        while (!maxDeque.isEmpty() && x > maxDeque.peekLast()) {
            maxDeque.pollLast();
        }
        maxDeque.offerLast(x);

        while (!minDeque.isEmpty() && x < minDeque.peekLast()) {
            minDeque.pollLast();
        }
        minDeque.offerLast(x);
    }

    public void remove(int x) {
        if (!maxDeque.isEmpty() && x == maxDeque.peekFirst()) {
            maxDeque.pollFirst();
        }
        if (!minDeque.isEmpty() && x == minDeque.peekFirst()) {
            minDeque.pollFirst();
        }
    }

    public int getMin() {
        return minDeque.peekFirst();
    }

    public int getMax() {
        return maxDeque.peekFirst();
    }

    public boolean isEmpty() {
        return maxDeque.isEmpty();
    }
}
