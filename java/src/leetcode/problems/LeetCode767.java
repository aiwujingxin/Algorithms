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
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.num - a.num);
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 1) {
            Node first = pq.poll();
            Node second = pq.poll();
            sb.append(first.c);
            sb.append(second.c);
            if (--first.num > 0) pq.add(first);
            if (--second.num > 0) pq.add(second);
        }
        // 处理剩下的一个字符
        if (!pq.isEmpty()) {
            Node last = pq.poll();
            if (last.num > 1) {
                return "";
            }
            sb.append(last.c);
        }
        return sb.toString();
    }

    static class Node {
        char c;
        int num;

        Node(char c, int num) {
            this.c = c;
            this.num = num;
        }
    }

}
