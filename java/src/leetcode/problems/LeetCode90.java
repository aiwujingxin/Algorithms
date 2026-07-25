package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/10 23:46
 * @description 添加了排序和剪枝的逻辑，其他都不变
 * 剪枝逻辑，值相同的相邻树枝，只遍历第一条
 */
public class LeetCode90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) { // 去重策略是基于层级的：只跳过同一层中重复的元素。
                continue;
            }
            list.add(nums[i]);
            backtrack(nums, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }
}
