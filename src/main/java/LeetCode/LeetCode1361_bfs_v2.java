package LeetCode;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/25 23:52
 */
public class LeetCode1361_bfs_v2 {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // handle find 1 root
        boolean[] isRoot = new boolean[n];
        Arrays.fill(isRoot, true);
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                isRoot[leftChild[i]] = false;
            }
            if (rightChild[i] != -1) {
                isRoot[rightChild[i]] = false;
            }
        }

        int rootCount = 0;
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (isRoot[i]) {
                rootCount++;
                root = i;
            }
        }
        if (rootCount != 1) {
            return false;
        }

        // bfs to find cycle
        boolean[] visited = new boolean[n];
        int count = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            if (visited[cur]) {
                return false;
            }
            visited[cur] = true;

            if (leftChild[cur] != -1) {
                queue.add(leftChild[cur]);
            }

            if (rightChild[cur] != -1) {
                queue.add(rightChild[cur]);
            }
        }

        return count == n;
    }
}
