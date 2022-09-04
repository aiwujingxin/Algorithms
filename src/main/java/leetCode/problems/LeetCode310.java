package leetCode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/14 22:22
 */
public class LeetCode310 {

    public static void main(String[] args) {
//        System.out.println(new LeetCode310().findMinHeightTreesV2(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
        System.out.println(new LeetCode310().findMinHeightTreesV2(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}));
//        System.out.println(new LeetCode310().findMinHeightTreesV2(2, new int[][]{{0, 1}}));
    }

    /*
     * 树是一个无向图，其中任何两个顶点只通过一条路径连接。
     * 换句话说，一个任何没有简单环路的连通图都是一棵树。
     */
    public List<Integer> findMinHeightTrees_wrong(int n, int[][] edges) {
        List<Integer> list = new ArrayList<>();
        if (n == 1) {
            list.add(0);
            return list;
        }
        if (n == 2) {
            list.add(0);
            list.add(1);
            return list;
        }
        int[] arr = new int[n];
        for (int[] edge : edges) {
            arr[edge[0]]++;
            arr[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 1) {
                q.add(i);
            }
        }
        HashSet<Integer> res = new HashSet<>();
        while (!q.isEmpty()) {
            Integer root = q.poll();
            List<Integer> end = find(root, edges);
            for (Integer e : end) {
                arr[e]--;
                arr[root]--;
                res.add(root);
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    q.add(i);
                }
            }
        }
        return new ArrayList<>(res);
    }

    private List<Integer> find(Integer root, int[][] edges) {
        List<Integer> list = new ArrayList<>();
        for (int[] edge : edges) {
            if (edge[0] == root) {
                list.add(edge[1]);
            } else if (edge[1] == root) {
                list.add(edge[0]);
            }
        }
        return list;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> myGraph = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            myGraph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            myGraph.get(edge[0]).add(edge[1]);
            myGraph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Queue<Integer> myQueue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                return res;
            } else if (degree[i] == 1) {
                myQueue.offer(i);
            }
        }
        while (!myQueue.isEmpty()) {
            res = new ArrayList<>();
            int size = myQueue.size();
            for (int i = 0; i < size; i++) {
                int curr = myQueue.poll();
                res.add(curr);
                degree[curr]--;
                for (int k = 0; k < myGraph.get(curr).size(); k++) {
                    int next = myGraph.get(curr).get(k);
                    if (degree[next] == 0) {
                        continue;
                    }
                    degree[next]--;
                    if (degree[next] == 1) {
                        myQueue.offer(next);
                    }
                }
            }
        }
        return res;
    }

    public List<Integer> findMinHeightTreesV2(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new HashSet<>());
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                list.add(cur);
                for (int parent : map.get(cur)) {
                    degree[parent]--;
                    if (degree[parent] == 1) {
                        q.offer(parent);
                    }
                }
            }
            res = list;
        }
        return res;
    }
}
