package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/29 21:59
 */
public class LeetCode1514_Dijkstra {

    //https://leetcode.com/problems/path-with-maximum-probability/solutions/2440627/java-dijkstra-algorithm/

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            graph.get(e[0]).add(new Pair(succProb[i], e[1]));
            graph.get(e[1]).add(new Pair(succProb[i], e[0]));
        }

        PriorityQueue<Pair> que = new PriorityQueue<>();
        double[] prob = new double[n];

        que.offer(new Pair(1, start));
        prob[start] = 1;
        while (!que.isEmpty()) {
            Pair pair = que.poll();
            double pr = pair.probability;
            int node = pair.node;
            if (pr < prob[node]) {
                continue;
            }
            for (Pair pairNext : graph.get(node)) {
                double prNext = pairNext.probability;
                int nodeNext = pairNext.node;
                if (prob[nodeNext] < prob[node] * prNext) {
                    prob[nodeNext] = prob[node] * prNext;
                    que.offer(new Pair(prob[nodeNext], nodeNext));
                }
            }
        }
        return prob[end];
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
            } else {
                return this.probability - pair2.probability > 0 ? -1 : 1;
            }
        }
    }
}

