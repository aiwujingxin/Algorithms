package leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/29 21:59
 */
public class LeetCode1514_Dijkstra {

    //https://leetcode.com/problems/path-with-maximum-probability/solutions/2440627/java-dijkstra-algorithm/

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<Pair>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            graph[e[0]].add(new Pair(succProb[i], e[1]));
            graph[e[1]].add(new Pair(succProb[i], e[0]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        double[] d = new double[n];
        pq.add(new Pair(1, start));
        d[start] = 1;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            double pr = pair.probability;
            int u = pair.node;
            if (pr < d[u]) {
                continue;
            }
            for (Pair edge : graph[u]) {
                double w = edge.probability;
                int v = edge.node;
                if (d[v] < d[u] * w) {
                    d[v] = d[u] * w;
                    pq.offer(new Pair(d[v], v));
                }
            }
        }
        return d[end];
    }

    static class Pair implements Comparable<Pair> {
        double probability;
        int node;

        public Pair(double probability, int node) {
            this.probability = probability;
            this.node = node;
        }

        public int compareTo(Pair pair2) {
            if (this.probability == pair2.probability) {
                return this.node - pair2.node;
            }
            return this.probability - pair2.probability > 0 ? -1 : 1;
        }
    }
}

