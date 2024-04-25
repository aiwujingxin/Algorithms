package leetcode.problems;

import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/26 01:05
 */
public class LeetCode1405 {

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair<Integer, Character>> pq = new PriorityQueue<>(
                (x, y) -> y.getKey() - x.getKey());
        if (a != 0) pq.add(new Pair<>(a, 'a'));
        if (b != 0) pq.add(new Pair<>(b, 'b'));
        if (c != 0) pq.add(new Pair<>(c, 'c'));

        StringBuilder ret = new StringBuilder();
        while (!pq.isEmpty()) {
            if (pq.size() == 1) {
                int k = Math.min(2, pq.peek().getKey());
                for (int i = 0; i < k; i++)
                    ret.append(pq.peek().getValue());
                return ret.toString();
            }

            Pair<Integer, Character> x = pq.poll();
            Pair<Integer, Character> y = pq.poll();

            int k = Math.min(1 + x.getKey() - y.getKey(), 2);
            for (int i = 0; i < k; i++)
                ret.append(x.getValue());
            ret.append(y.getValue());

            x = new Pair<>(x.getKey() - k, x.getValue());
            y = new Pair<>(y.getKey() - 1, y.getValue());
            if (x.getKey() != 0)
                pq.add(x);
            if (y.getKey() != 0)
                pq.add(y);
        }
        return ret.toString();
    }

    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
