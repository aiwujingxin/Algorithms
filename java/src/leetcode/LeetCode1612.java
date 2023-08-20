package leetcode;

import common.Node;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/13 13:38
 */
public class LeetCode1612 {

    public boolean checkEquivalence(Node root1, Node root2) {
        int[] arr1 = new int[127];
        int[] arr2 = new int[127];
        dfs(root1, arr1);
        dfs(root2, arr2);
        for (int i = 'a'; i <= 'z'; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public void dfs(Node root, int[] arr) {
        if (root.val != '+') {
            arr[root.val]++;
            return;
        }
        dfs(root.left, arr);
        dfs(root.right, arr);
    }
}
