package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/6 21:21
 */
public class LeetCode491 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> list, List<List<Integer>> results) {
        if (list.size() > 1) {
            results.add(new ArrayList<>(list));
        }
        if (index == nums.length) {
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (!list.isEmpty() && nums[i] < list.get(list.size() - 1)) {
                continue;
            }
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);

            list.add(nums[i]);
            dfs(nums, i + 1, list, results);
            list.remove(list.size() - 1);
        }
    }
}
