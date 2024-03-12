package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/19 15:12
 */
public class LeetCode47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), res, used);
        return res;
    }

    public void backtrack(int[] nums, List<Integer> path, List<List<Integer>> res, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // used作用: 固定相同的元素在排列中的相对位置，以保证相同元素在排列中的相对位置保持不变
            //!used[i - 1] 如果前面的相邻相等元素没有用过，则跳过; 2' 只有在 2 已经被使用的情况下才会被选择(2 -> 2' -> 2'')。这种剪枝逻辑剪得干净利落, 从源头就剪掉了
            // used[i - 1] 仅仅维护了 2'' -> 2' -> 2 的相对顺序, 效率会差
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, path, res, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
