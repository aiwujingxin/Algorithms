package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/19 15:12
 */
public class LeetCode47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
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
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            list.add(nums[i]);
            used[i] = true;
            backtrack(nums, list, res, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
