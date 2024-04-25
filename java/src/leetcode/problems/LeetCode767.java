package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/26 00:39
 */
public class LeetCode767 {

    public String reorganizeString(String S) {
        Map<Character, Integer> count = new HashMap<>();
        for (char ch : S.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> b.num - a.num
        );
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }
        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            int k = Math.min(2, pq.size());
            List<Node> temp = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                Node entry = pq.poll();
                char ch = entry.c;
                int num = entry.num;
                result.append(ch);
                num--;
                if (num != 0) {
                    temp.add(new Node(ch, num));
                }
            }
            if (k < 2 && !temp.isEmpty()) {
                return "";
            }
            pq.addAll(temp);
        }
        return result.toString();
    }

    static class Node {
        char c;
        int num;

        public Node(char c, int num) {
            this.c = c;
            this.num = num;
        }
    }
}
