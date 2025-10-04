package knowledge.algorithms.search.dfsAndBfs.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author wujingxinit@outlook.com
 * @date 9/28/25 11:51
 * @description 分支限界法解决旅行商问题(TSP)
 */

public class TspBranchAndBound {

    public class Main {

        static private int n;                  // 村庄数量
        static private int[][] dist;           // 距离矩阵
        static private int bestCost = Integer.MAX_VALUE; // 当前找到的最优解成本

        /**
         * 分支界定法求解主函数
         */
        public static void solve() {
            // 优先队列，存储待探索的节点，按 lowerBound 升序排列
            PriorityQueue<Node> pq = new PriorityQueue<>();

            // 1. 创建初始节点 (从商店0出发)
            List<Integer> initialPath = new ArrayList<>();
            initialPath.add(0);

            boolean[] visited = new boolean[n];
            visited[0] = true;

            // 计算初始下界并创建初始节点
            double initialLowerBound = calculateLowerBound(0, visited);

            Node root = new Node(initialPath, 0, 0, initialLowerBound);
            pq.add(root);

            // 2. 开始分支界定搜索
            while (!pq.isEmpty()) {
                Node currentNode = pq.poll();

                // --- 剪枝 1: 如果当前节点的下界已经不优于已知最优解，则跳过 ---
                if (currentNode.lowerBound >= bestCost) {
                    continue;
                }

                // --- 判断是否找到一个完整的回路 ---
                if (currentNode.path.size() == n) {
                    // 路径已包含所有村庄，现在需要返回商店(0)
                    int finalCost = currentNode.cost + dist[currentNode.currentCity][0];
                    if (finalCost < bestCost) {
                        bestCost = finalCost;
                        // 如果需要输出路径，可以在这里保存
                    }
                    continue; // 这个分支已经探索到底，继续处理队列中其他节点
                }

                // 3. 分支：扩展当前节点，为每一个未访问的邻居创建一个子节点
                for (int nextCity = 0; nextCity < n; nextCity++) {
                    // 检查 nextCity 是否尚未访问
                    if (!currentNode.path.contains(nextCity)) {

                        int newCost = currentNode.cost + dist[currentNode.currentCity][nextCity];

                        // --- 剪枝 2: 如果仅凭已走过的路程就已经不优，提前剪枝 ---
                        if (newCost >= bestCost) {
                            continue;
                        }

                        List<Integer> newPath = new ArrayList<>(currentNode.path);
                        newPath.add(nextCity);

                        boolean[] newVisited = new boolean[n];
                        for (int city : newPath) newVisited[city] = true;


                        // 计算新的下界
                        double newLowerBound = calculateLowerBound(newCost, newPath);

                        // --- 剪枝 3: 如果新节点的下界不优，也不用加入队列 ---
                        if (newLowerBound >= bestCost) {
                            continue;
                        }

                        // 将有希望的子节点加入优先队列
                        Node childNode = new Node(newPath, nextCity, newCost, newLowerBound);
                        pq.add(childNode);
                    }
                }
            }
        }

        /**
         * 计算成本下界 (Lower Bound)
         * 这个函数计算的是未来预估成本，即从当前状态走完剩余路径的最小预估成本。
         *
         * @param currentCost 已走路径的实际成本
         * @param visited     一个布尔数组，标记哪些城市已被访问
         * @return 预估的未来成本
         */
        static private double calculateLowerBound(int currentCost, boolean[] visited) {
            double futureCost = 0;

            // 对每一个尚未访问的城市
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    // 找到从这个城市出发的最短出边
                    int minEdge = Integer.MAX_VALUE;
                    for (int j = 0; j < n; j++) {
                        // 可以去往任何其他未访问的城市，或者最终返回商店(0)
                        if (i != j && (!visited[j] || j == 0)) {
                            minEdge = Math.min(minEdge, dist[i][j]);
                        }
                    }
                    // 如果一个孤立的未访问节点无法到达任何目标，则此路不通
                    if (minEdge == Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE; // 返回一个极大值，使得该分支被剪掉
                    }
                    futureCost += minEdge;
                }
            }
            return futureCost;
        }

        // 为了让下界更紧凑，我们使用更优的下界计算方法
        // 这里的下界计算的是整个路径的预估总成本
        private static double calculateLowerBound(int currentCost, List<Integer> path) {
            double bound = currentCost;
            boolean[] visited = new boolean[n];
            for (int city : path) visited[city] = true;
            int lastCityInPath = path.get(path.size() - 1);

            // 对于路径的终点，找到连接它的最短出边（到未访问节点或起点）
            int minOutOfLast = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!visited[i] || i == 0) { // 可以去往未访问节点或起点
                    if (lastCityInPath != i) {
                        minOutOfLast = Math.min(minOutOfLast, dist[lastCityInPath][i]);
                    }
                }
            }
            if (minOutOfLast != Integer.MAX_VALUE) bound += minOutOfLast;

            // 对于所有未访问的节点，找到它们的最短出边
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int minEdge = Integer.MAX_VALUE;
                    for (int j = 0; j < n; j++) {
                        if (i != j && (!visited[j] || j == 0)) {
                            minEdge = Math.min(minEdge, dist[i][j]);
                        }
                    }
                    if (minEdge != Integer.MAX_VALUE) bound += minEdge;
                    else return Integer.MAX_VALUE; // 无法完成回路
                }
            }
            return bound;
        }


        // Node 类，代表搜索树中的一个节点
        static class Node implements Comparable<Node> {
            List<Integer> path; // 当前已经走过的路径 (e.g., [0, 2, 1])
            int currentCity;    // 当前所在的村庄 (索引)
            int cost;           // 从起点走到当前村庄的实际成本
            double lowerBound;  // 成本下界 (已走成本 + 预估未来成本)

            public Node(List<Integer> path, int currentCity, int cost, double lowerBound) {
                this.path = path;
                this.currentCity = currentCity;
                this.cost = cost;
                this.lowerBound = lowerBound;
            }

            // 实现 Comparable 接口，让优先队列能根据 lowerBound 排序
            @Override
            public int compareTo(Node other) {
                return Double.compare(this.lowerBound, other.lowerBound);
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = scanner.nextInt();
                }
            }
            scanner.close();
            solve();
            System.out.println(bestCost);
        }
    }

}
