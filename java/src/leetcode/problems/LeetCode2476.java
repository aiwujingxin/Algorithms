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
            int l = bsearch_2(a, q);
            if (l >= 0 && a.get(l) <= q) {
                min = a.get(l);
            }
            int r = bsearch_1(a, q);
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

    // 第一个大于等于target的数
    public int bsearch_1(List<Integer> nums, int target) {
        int l = 0;
        int r = nums.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums.get(mid) >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // 最后一个小于等于target的数
    public int bsearch_2(List<Integer> nums, int target) {
        int l = 0;
        int r = nums.size() - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums.get(mid) <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
