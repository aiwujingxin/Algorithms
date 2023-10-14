package leetcode.lists.lcr;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/26 18:41
 */

public class LCR114 {

    public String alienOrder(String[] words) {
        if (words.length == 0) {
            return "";
        }

        // 创建邻接表
        Map<Character, Set<Character>> graph = new HashMap<>();
        // 创建入度表
        int[] inDegrees = new int[26];

        // 将所有字符加入图中
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.put(c, new HashSet<>());
            }
        }

        // 获取所有的边
        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];
            int j = 0;
            int minLen = Math.min(w1.length(), w2.length());
            while (j < minLen) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegrees[c2 - 'a']++;
                    }
                    break;
                }
                j++;
            }
            // 如果没有找到边，说明较短词语是较长词语的前缀，那么正确的顺序应该是较长的词在后面，否则就是非法输入
            if (j == minLen && w1.length() > w2.length()) {
                return "";
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();

        // 将入度为0的字符入队
        for (char c : graph.keySet()) {
            if (inDegrees[c - 'a'] == 0) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            char node = queue.poll();
            sb.append(node);
            for (char next : graph.get(node)) {
                inDegrees[next - 'a']--;
                if (inDegrees[next - 'a'] == 0) {
                    queue.offer(next);
                }
            }
        }

        // 如果结果字符串的长度等于字符集的大小，说明可以构建外星语字母顺序
        if (sb.length() == graph.size()) {
            return sb.toString();
        }

        return "";
    }
}
