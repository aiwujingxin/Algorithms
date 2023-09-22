package leetcode.problems;


/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/25 23:58
 */
public class LeetCode1361_dfs {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Integer root = null;
        boolean[] visited = new boolean[leftChild.length];
        for (int i = 0; i < leftChild.length; i++) {
            if (leftChild[i] != -1) {
                visited[leftChild[i]] = true;
            }
            if (rightChild[i] != -1) {
                visited[rightChild[i]] = true;
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                if (root != null) {
                    return false;
                }
                root = i;
            }
        }
        visited = new boolean[leftChild.length];
        if (root == null) {
            return false;
        }
        boolean ans = dfs(root, leftChild, rightChild, visited);
        for (boolean ele : visited) {
            if (!ele) {
                return false;
            }
        }
        return ans;
    }

    public boolean dfs(int root, int[] left, int[] right, boolean[] visited) {
        if (root == -1) {
            return true;
        }
        if (visited[root]) {
            return false;
        }
        visited[root] = true;
        return dfs(left[root], left, right, visited) && dfs(right[root], left, right, visited);
    }
}
