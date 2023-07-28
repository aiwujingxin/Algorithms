package leetcode.problems;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/12 00:15
 */
public class LeetCode889 {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int N = pre.length;
        if (N == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if (N == 1) {
            return root;
        }
        int L = 0;
        for (int i = 0; i < N; ++i) {
            if (post[i] == pre[1]) {
                L = i + 1;
            }
        }
        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L + 1), Arrays.copyOfRange(post, 0, L));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, L + 1, N), Arrays.copyOfRange(post, L, N - 1));
        return root;
    }
}
