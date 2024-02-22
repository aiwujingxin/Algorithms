package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/7 18:00
 */
public class LeetCode1311 {

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = watchedVideos.size();
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends[i].length; j++) {
                graph[i].add(friends[i][j]);
                graph[friends[i][j]].add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(id);
        visited[id] = true;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Integer cur = queue.poll();
                for (Integer next : graph[cur]) {
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    queue.add(next);
                    list.add(next);
                }
            }
            if (level == 0) {
                break;
            }
            level--;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (Integer f : list) {
            for (String w : watchedVideos.get(f)) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
        }
        // 将Map中的键值对转换为List以便排序
        List<Map.Entry<String, Integer>> res = new ArrayList<>(map.entrySet());

        // 使用自定义的Comparator进行排序
        res.sort(new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                int valueComparison = entry1.getValue().compareTo(entry2.getValue());
                if (valueComparison != 0) {
                    return valueComparison;
                }
                return entry1.getKey().compareTo(entry2.getKey());
            }
        });

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : res) {
            result.add(entry.getKey());
        }
        return result;
    }
}
