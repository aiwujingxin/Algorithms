package leetcode;

import java.util.*;

public class LeetCode126_BFS {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (beginWord == null || endWord == null || wordList == null) {
            return res;
        }
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
            Set<String> vis = new HashSet<>();
            while (size > 0) {
                String cur = queue.poll();
                char[] ch = cur.toCharArray();
                for (int i = 0; i < ch.length; i++) {
                    char temp = ch[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (temp == j) {
                            continue;
                        }
                        ch[i] = j;
                        String str = new String(ch);
                        if (wordSet.contains(str)) {
                            if (str.equals(endWord)) {
                                flag = true;
                            }
                            if (!vis.contains(str)) {
                                List<String> list = new ArrayList<>();
                                list.add(cur);
                                graph.put(str, list);
                                queue.add(str);
                                vis.add(str);
                            } else {
                                List<String> list = graph.get(str);
                                list.add(cur);
                                graph.put(str, list);
                            }
                        }
                    }
                    ch[i] = temp;
                }
                size--;
            }
            for (String s : vis) {
                wordSet.remove(s);
            }
            if (flag) {
                LinkedList<String> path = new LinkedList<>();
                path.add(endWord);
                dfs(res, path, endWord, beginWord, graph);
                return res;
            }
        }
        return res;
    }

    public void dfs(List<List<String>> res, LinkedList<String> path, String cur, String endWord, Map<String, List<String>> graph) {
        if (cur.equals(endWord)) {
            List<String> copy = new LinkedList<>(path);
            res.add(copy);
            return;
        }
        List<String> nexts = graph.get(cur);
        for (String next : nexts) {
            path.addFirst(next);
            dfs(res, path, next, endWord, graph);
            path.removeFirst();
        }
    }
}
