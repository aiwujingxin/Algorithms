package leetCode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/25 23:36
 */
public class LeetCode1361_topo {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        int edges = 0;
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                graph[i].add(leftChild[i]);
                degree[leftChild[i]]++;
                edges++;
            }
            if (rightChild[i] != -1) {
                graph[i].add(rightChild[i]);
                degree[rightChild[i]]++;
                edges++;
            }
            if (i == leftChild[i] || i == rightChild[i] || (leftChild[i] != -1 && leftChild[i] == rightChild[i]))
                return false;
        }
        if (edges != n - 1) return false;

        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
            if (degree[i] > 1) {
                return false;
            }
        }

        if (queue.size() > 1) return false;


        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                count++;
                for (int w : graph[curr]) {
                    if (--degree[w] == 0) {
                        queue.offer(w);
                    }
                }
            }
        }
        return count == n;

    }
}
