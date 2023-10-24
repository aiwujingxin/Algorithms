package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/19 15:12
 */
public class LeetCode47_v2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<>(), visited);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            used[i] = true;
            list.add(nums[i]);
            backtrack(nums, res, list, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
