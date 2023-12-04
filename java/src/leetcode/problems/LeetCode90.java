package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/27 04:23
 */
public class LeetCode90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            // 剪枝逻辑，值相同的相邻树枝，只遍历第一条
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            backtrack(nums, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }
}
