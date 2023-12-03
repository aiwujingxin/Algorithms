package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/1 12:54
 */
public class LeetCode46 {

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), res, used);
        return res;
    }

    void backtrack(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            backtrack(nums, list, res, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
