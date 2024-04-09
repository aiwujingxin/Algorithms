package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/13 13:26
 */
public class LeetCode2476 {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> a = new ArrayList<>();
        dfs(root, a);
        List<List<Integer>> ans = new ArrayList<>();
        for (int q : queries) {
            int min = -1;
            int max = -1;
            int l = rightBound(a, q);
            if (l >= 0 && a.get(l) <= q) {
                min = a.get(l);
            }
            int r = leftBound(a, q);
            if (r < a.size() && a.get(r) >= q) {
                max = a.get(r);
            }
            List<Integer> result = new ArrayList<>();
            result.add(min);
            result.add(max);
            ans.add(result);
        }
        return ans;
    }

    private void dfs(TreeNode o, List<Integer> a) {
        if (o == null) {
            return;
        }
        dfs(o.left, a);
        a.add(o.val);
        dfs(o.right, a);
    }

    public int leftBound(List<Integer> nums, int target) {
        int l = 0;
        int r = nums.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums.get(mid) < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public int rightBound(List<Integer> nums, int target) {
        int l = 0;
        int r = nums.size() - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums.get(mid) > target) r = mid - 1;
            else l = mid;
        }
        return l;
    }
}
