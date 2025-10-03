package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 9/2/25 11:40
 */
public class LeetCode1462 {

    List<Integer>[] graph;
    List<Integer>[] pa_graph;
    HashMap<Integer, Set<Integer>> child2PaMap;

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        child2PaMap = new HashMap<>();
        graph = new List[numCourses];
        pa_graph = new List[numCourses];
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
            pa_graph[i] = new ArrayList<>();
        }
        for (int[] p : prerequisites) {
            inDegree[p[1]]++;
            graph[p[0]].add(p[1]);
            pa_graph[p[1]].add(p[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int rootOfCur : pa_graph[cur]) {
                Set<Integer> set = child2PaMap.getOrDefault(cur, new HashSet<>());
                set.add(rootOfCur);
                set.addAll(child2PaMap.getOrDefault(rootOfCur, new HashSet<>()));
                child2PaMap.put(cur, set);
            }
            for (int ch : graph[cur]) {
                inDegree[ch]--;
                if (inDegree[ch] == 0) {
                    queue.add(ch);
                }
            }
        }
        List<Boolean> list = new ArrayList<>();
        for (int[] query : queries) {
            list.add(child2PaMap.getOrDefault(query[1], new HashSet<>()).contains(query[0]));
        }
        return list;
    }
}
