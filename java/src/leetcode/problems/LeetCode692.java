package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2/16/25 23:37
 */
public class LeetCode692 {

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.freq == o2.freq) {
                return o2.value.compareTo(o1.value);
            }
            return o1.freq - o2.freq;
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            result.add(node.value);
        }
        Collections.reverse(result);
        return result;
    }

    static class Node {
        String value;
        int freq;

        public Node(String v, int f) {
            this.value = v;
            this.freq = f;
        }
    }
}
