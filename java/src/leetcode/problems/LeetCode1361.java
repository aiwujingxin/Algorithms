package leetcode.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/25 23:36
 */
public class LeetCode1361 {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] indrgee = new int[n];
        int[] outdrgee = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                indrgee[leftChild[i]]++;
                outdrgee[i]++;
            }
            if (rightChild[i] != -1) {
                indrgee[rightChild[i]]++;
                outdrgee[i]++;
            }
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (indrgee[i] == 0) {
                if (root == -1) {
                    root = i;
                } else {
                    return false;
                }
            }
            if (indrgee[i] > 1 || outdrgee[i] > 2) {
                return false;
            }
        }
        if (root == -1) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        HashSet<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (set.contains(node)) {
                return false;
            }
            set.add(node);
            if (leftChild[node] != -1) {
                queue.add(leftChild[node]);
            }
            if (rightChild[node] != -1) {
                queue.add(rightChild[node]);
            }
        }
        return set.size() == n;
    }
}
