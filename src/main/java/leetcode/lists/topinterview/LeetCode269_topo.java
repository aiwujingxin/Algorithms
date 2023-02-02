package leetcode.lists.topinterview;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/27 15:13
 */

//https://leetcode.cn/problems/alien-dictionary/solution/by-yukiyama-2cam/
public class LeetCode269_topo {

    public String alienOrder(String[] words) {
        int n = words.length;
        int[] indegree = new int[26]; // 入度
        Arrays.fill(indegree, -1);
        for (String word : words) { // 初始化入度，值为0表示顶点，-1表示非顶点
            char[] chs = word.toCharArray();
            for (char ch : chs) indegree[ch - 'a'] = 0;
        }
        List<List<Integer>> graph = new ArrayList<>(); // 邻接表
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            char[] chs1 = w1.toCharArray();
            char[] chs2 = w2.toCharArray();
            int w1n = w1.length(), w2n = w2.length();
            int wn = Math.min(w1n, w2n), j = 0;
            for (; j < wn; j++) {
                int u = chs1[j] - 'a', v = chs2[j] - 'a'; // u > v
                if (u != v) {
                    graph.get(u).add(v);
                    indegree[v]++;
                    break; // 一对相邻单词最多决定一条边，处理这条边后直接break
                }
            }
            if (j == wn && w1n > w2n) {
                return "";
            } // word2为word1的真前缀，非法输入
        }
        return topoSort(graph, indegree);
    }

    // 拓扑排序，排序过程中判断图是否有圈
    private String topoSort(List<List<Integer>> graph, int[] indegree) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new ArrayDeque<>();
        int count = 0, vNum = 0; // 拓扑排序计数 & 图中总节点数
        for (int i = 0; i < indegree.length; i++) { // 将入度为0的顶点加入q中
            if (indegree[i] != -1) {
                vNum++; // 存在
                if (indegree[i] == 0) { // 存在且入度为0
                    q.add(i);
                    sb.append((char) (i + 'a')); // 入度为0的顶点先输出
                    count++; // 排序一个计数一个
                }
            }
        }
        while (!q.isEmpty()) { // 拓扑排序
            int u = q.remove();
            for (int v : graph.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.add(v);
                    sb.append((char) (v + 'a'));
                    count++; // 排序一个计数一个
                }
            }
        }
        return count != vNum ? "" : sb.toString(); // 判断是否有圈
    }
}
