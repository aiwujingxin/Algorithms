package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/10 20:22
 */
public class LeetCode255 {

    public boolean verifyPreorder(int[] preorder) {
        return dfs(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean dfs(int[] preorder, int start, int end, int min, int max) {
        if (start > end) {
            return true;
        }
        if (start == end) {
            int root = preorder[start];
            return root < max && root > min;
        }
        int root = preorder[start];
        if (root > max || root < min) {
            return false;
        }
        int index = start + 1;
        while (index <= end && preorder[index] < preorder[start]) {
            index++;
        }
        return dfs(preorder, start + 1, index - 1, min, root) && dfs(preorder, index, end, root, max);
    }
}
