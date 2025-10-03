package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/30 21:34
 */
public class LeetCode126 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return res;
        }
        Map<String, List<String>> graph = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                char[] chars = cur.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char t = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (t == c) {
                            continue;
                        }
                        chars[j] = c;
                        String s = new String(chars);
                        if (wordSet.contains(s)) {
                            if (s.equals(endWord)) {
                                flag = true;
                            }
                            if (!set.contains(s)) {
                                queue.add(s);
                                set.add(s);
                            }
                            List<String> list = graph.getOrDefault(s, new ArrayList<>());
                            list.add(cur);
                            graph.put(s, list);
                        }
                    }
                    chars[j] = t;
                }
            }
            for (String s : set) {
                wordSet.remove(s);
            }
            if (flag) {
                LinkedList<String> path = new LinkedList<>();
                path.add(endWord);
                backtrack(res, path, endWord, beginWord, graph);
                return res;
            }
        }
        return res;
    }

    public void backtrack(List<List<String>> res, LinkedList<String> path, String cur, String endWord, Map<String, List<String>> graph) {
        if (cur.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (String next : graph.get(cur)) {
            path.addFirst(next);
            backtrack(res, path, next, endWord, graph);
            path.removeFirst();
        }
    }
}
