package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 21:48
 */
public class LeetCode40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, 0, res, new ArrayList<>(), target);
        return res;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> res, List<Integer> list, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            list.add(nums[i]);
            backtrack(nums, i + 1, res, list, target - nums[i]);
            list.remove(list.size() - 1);
        }
    }
}
